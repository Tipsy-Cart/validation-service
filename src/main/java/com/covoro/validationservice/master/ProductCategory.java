package com.covoro.validationservice.master;

public enum ProductCategory {

    ELECTRONIC_DEVICES("DL8.48.8.2", "Electronic Devices"),
    GOLD_AND_DIAMONDS("DL8.48.8.1", "Gold and Diamonds"),
    CRUDE_OR_REFINED_OIL("DL8.48.3.1", "Crude or refined oil"),
    NATURAL_GAS("DL8.48.3.2", "Unprocessed or processed natural gas"),
    PURE_HYDROCARBONS("DL8.48.3.3", "Pure hydrocarbons");

    final String code;
    final String description;

    ProductCategory(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
