package com.covoro.validationservice.bean;

import com.jayway.jsonpath.DocumentContext;
import lombok.Data;

@Data
public class JsonFact {

    private String type;
    private int index;
    private DocumentContext context;
    private JsonFact jsonFact;

    public JsonFact(String type, int index, DocumentContext context) {
        this.type = type;
        this.index = index;
        this.context = context;
    }

    public JsonFact(String type, int index, DocumentContext context, JsonFact jsonFact) {
        this.type = type;
        this.index = index;
        this.context = context;
        this.jsonFact = jsonFact;
    }
}
