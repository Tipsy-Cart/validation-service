package com.covoro.validationservice.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashSet;
import java.util.Set;

public class FutureDateValidator implements JsonValidator {

    private final boolean disallowFuture;
    private final String keywordName = "futureDate";
    private final SchemaLocation schemaLocation;
    private final JsonNodePath evaluationPath;
    private final JsonSchema parentSchema;
    private final ValidationContext validationContext;

    public FutureDateValidator(JsonNode schemaNode,
                               SchemaLocation schemaLocation,
                               JsonNodePath evaluationPath,
                               JsonSchema parentSchema,
                               ValidationContext validationContext) {
        this.disallowFuture = schemaNode.asBoolean(false);
        this.schemaLocation = schemaLocation;
        this.evaluationPath = evaluationPath;
        this.parentSchema = parentSchema;
        this.validationContext = validationContext;
    }

    @Override
    public Set<ValidationMessage> validate(ExecutionContext executionContext, JsonNode node, JsonNode rootNode, JsonNodePath instanceLocation) {
        Set<ValidationMessage> errors = new HashSet<>();

        if (!node.isTextual()) return errors; // let type validator handle non-string

        if (disallowFuture) return errors;   // future allowed

        String value = node.asText();
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd")
                    .withResolverStyle(ResolverStyle.STRICT);
            LocalDate parsed = LocalDate.parse(value, dateTimeFormatter);
            if (parsed.isAfter(LocalDate.now())) {
                errors.add(ValidationMessage.builder()
                        .code("futureDate")
                        .type(keywordName)
                        .instanceLocation(instanceLocation)
                        .message("Date must not be in the future")
                        .build());
            }
        } catch (DateTimeParseException e) {
            // Format validator will handle pattern errors
        }

        return errors;
    }

    @Override
    public SchemaLocation getSchemaLocation() {
        return this.schemaLocation;
    }

    @Override
    public JsonNodePath getEvaluationPath() {
        return this.evaluationPath;
    }

    @Override
    public String getKeyword() {
        return this.keywordName;
    }
}
