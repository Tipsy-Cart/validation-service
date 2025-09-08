package com.covoro.validationservice.handler;

import com.covoro.validationservice.bean.JsonHelper;
import com.covoro.validationservice.bean.Taxes;
import com.covoro.validationservice.bean.ValidationError;
import com.covoro.validationservice.bean.ValidationResult;
import com.covoro.validationservice.helper.JsonSchemaManager;
import com.covoro.validationservice.helper.KieBaseManager;
import com.covoro.validationservice.logging.Logger;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.networknt.schema.InputFormat;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ValidationHandler {

    private final Logger logger;
    private final JsonSchemaManager jsonSchemaManager;
    private final KieBaseManager kieBaseManager;
    private static final Pattern ARRAY_INDEX_PATTERN = Pattern.compile("/(\\d+)");

    public ValidationHandler(Logger logger, JsonSchemaManager jsonSchemaManager, KieBaseManager kieBaseManager) {
        this.logger = logger;
        this.jsonSchemaManager = jsonSchemaManager;
        this.kieBaseManager = kieBaseManager;
    }

    public Map<String, String> validateJson(String id, String json) {
        logger.info("Start validating json");
        JsonSchema schema = jsonSchemaManager.getSchema(id);
        Set<ValidationMessage> validationMessages = schema.validate(json, InputFormat.JSON);
        Map<String, String> errors = this.beautifyMessage(validationMessages, jsonSchemaManager.getSchemaError(id));
        return errors;
    }

    public void reloadJsonSchema(String id) {
        logger.info("Clearing json schema for id: " + id);
        this.jsonSchemaManager.refresh(id);
    }

    public Map<String, String> validateDrool(String id, List<String> groups, String json) {
        logger.info("Start validating json");
        ValidationResult results = new ValidationResult();
        Taxes taxes = new Taxes();
        Configuration config = Configuration.builder()
                .options(Option.SUPPRESS_EXCEPTIONS)
                .build();
        KieBase kieBase = kieBaseManager.get(id);
        KieSession kieSession = kieBase.newKieSession();
        kieSession.setGlobal("results", results);
        kieSession.setGlobal("taxes", taxes);
        kieSession.setGlobal("jsonHelper", new JsonHelper());
        DocumentContext invoiceCtx = JsonPath.using(config).parse(json);
        kieSession.insert(invoiceCtx);
        if (null != groups && !groups.isEmpty()) {
            for (int i = 0; i < groups.size(); i++) {
                kieSession.getAgenda().getAgendaGroup(groups.get(i)).setFocus();
                kieSession.fireAllRules();
                if (!results.get().isEmpty()) {
                    kieSession.dispose();
                    break;
                }
            }
        }
        //System.out.println(taxes.toString());
        return results.get().stream().collect(Collectors.toMap(ValidationError::getField, ValidationError::getMessage));
    }

    private Map<String, String> beautifyMessage(Set<ValidationMessage> validationMessages, Map<String, ValidationError> errorMap) {
        Map<String, String> errors = new HashMap<>();
        validationMessages.forEach(vm -> {
            String location = vm.getInstanceLocation().toString();
            String property = vm.getProperty();
            String type = vm.getType();
            property = null != property ? "." + property : "";
            String errorKey = location + property + "|" + type;
            if ("pattern".equals(type)) {
                String pattern = vm.getArguments()[0].toString();
                errorKey = errorKey + "|" + pattern;
            }
            System.out.println(errorKey);
            Matcher matcher = ARRAY_INDEX_PATTERN.matcher(errorKey);
            List<Integer> indices = new ArrayList<>();
            while (matcher.find()) {
                indices.add(Integer.parseInt(matcher.group(1)));
            }
            if (indices.isEmpty()) {
                ValidationError validationError = errorMap.get(errorKey);
                if (null != validationError) {
                    errors.put(validationError.getField(), validationError.getMessage());
                }
            } else {
                String path = errorKey.replaceAll("/(\\d+)", "/%d");
                ValidationError validationError = errorMap.get(path);
                if (null != validationError) {
                    errors.put(String.format(validationError.getField(), indices.toArray()), validationError.getMessage());
                }
            }
        });
        return errors;
    }
}
