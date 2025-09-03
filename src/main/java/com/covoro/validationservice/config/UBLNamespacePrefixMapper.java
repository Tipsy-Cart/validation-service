package com.covoro.validationservice.config;

import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;

public class UBLNamespacePrefixMapper extends NamespacePrefixMapper {
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean b) {
        switch (namespaceUri) {
            case "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2":
                return "cbc";
            case "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2":
                return "cac";
            case "http://www.w3.org/2001/XMLSchema-instance":
                return "xsi";
            case "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2":
                return ""; // default namespace
            default:
                return suggestion;
        }
    }
}
