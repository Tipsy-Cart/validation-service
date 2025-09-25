package com.covoro.validationservice.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.*;

public class FutureDate extends AbstractKeyword {

    public FutureDate() {
        super("futureDate"); // must match schema
    }

    @Override
    public JsonValidator newValidator(SchemaLocation schemaLocation, JsonNodePath evaluationPath, JsonNode schemaNode, JsonSchema parentSchema, ValidationContext validationContext) throws JsonSchemaException, Exception {
        return new FutureDateValidator(schemaNode, schemaLocation, evaluationPath, parentSchema, validationContext);
    }
}
