package com.covoro.validationservice.master;

public enum TaxCategory {

    STANDARD_RATE("S", "Standard rate."),
    EXEMPT("E", "Exempt from tax"),
    OUT_OF_SCOPE("O", "Services outside scope of tax / Not subject to tax"),
    REVERSE_CHARGE("AE", "VAT Reverse Charge"),
    ZERO_RATED("Z", "Zero rated"),
    STANDARD_RATE_ADDITIONAL("Ν", "Standard rate additional VAT");

    final String code;
    final String description;

    TaxCategory(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
