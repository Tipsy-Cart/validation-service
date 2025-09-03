package com.covoro.validationservice.helper;

import com.covoro.validationservice.bean.ValidationError;
import com.covoro.validationservice.constant.ValidationServiceError;
import com.covoro.validationservice.exception.ValidationServiceException;
import com.covoro.validationservice.logging.Logger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JsonSchemaManager {

    private final Logger logger;
    private final Map<String, JsonSchema> jsonSchemaMap;
    private final Map<String, Map<String, ValidationError>> jsonSchemaErrorMap;
    private final ResourceLoader resourceLoader;

    public JsonSchemaManager(Logger logger, ResourceLoader resourceLoader) {
        this.logger = logger;
        this.jsonSchemaMap = new ConcurrentHashMap<>();
        this.jsonSchemaErrorMap = new ConcurrentHashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public JsonSchema getSchema(String id) {
        return this.jsonSchemaMap.computeIfAbsent(id, this::loadJsonSchema);
    }

    public Map<String, ValidationError> getSchemaError(String id) {
        return this.jsonSchemaErrorMap.computeIfAbsent(id, this::loadJsonSchemaError);
    }

    public void refresh(String id) {
        this.jsonSchemaMap.remove(id);
        this.jsonSchemaErrorMap.remove(id);
    }

    private JsonSchema loadJsonSchema(String id) {
        Resource schemaResource = resourceLoader.getResource("classpath:Schema/" + id + "/Schema.json");
        try (InputStream schemaStream = schemaResource.getInputStream()) {
            SchemaValidatorsConfig config = SchemaValidatorsConfig.builder()
                    .formatAssertionsEnabled(true)
                    .build();
            JsonMetaSchema metaSchema = JsonMetaSchema.builder(JsonMetaSchema.getV202012())
                    .format(new DateFormatValidator())
                    .build();
            JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012, builder -> builder.metaSchema(metaSchema));
            return jsonSchemaFactory.getSchema(schemaStream, config);
        } catch (Exception e) {
            logger.trace("Exception While Loading Json Schema for Id: " + id, e);
            throw new ValidationServiceException(ValidationServiceError.VALIDATION_SERVICE_EXCEPTION, e.getMessage());
        }
    }

    private Map<String, ValidationError> loadJsonSchemaError(String id) {
        Resource schemaErrorResource = resourceLoader.getResource("classpath:Schema/" + id + "/Error.json");
        try (InputStream schemaErrorStream = schemaErrorResource.getInputStream()) {
            return new ObjectMapper().readValue(schemaErrorStream, new TypeReference<>() {
            });
        } catch (Exception e) {
            logger.trace("Exception While Loading Json Schema Error for Id: " + id, e);
            throw new ValidationServiceException(ValidationServiceError.VALIDATION_SERVICE_EXCEPTION, e.getMessage());
        }
    }

}
