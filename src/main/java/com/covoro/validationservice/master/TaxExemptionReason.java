package com.covoro.validationservice.master;

public enum TaxExemptionReason {

    CERTAIN_FINANCIAL_SERVICES("DL8.46.1", "Certain financial services"),
    SUPPLY_OF_RESIDENTIAL_UNITS("DL8.46.2", "Supply of residential units (lease or sale)"),
    BARE_LAND("DL8.46.3", "Bare land"),
    LOCAL_PASSENGER_TRANSPORT("DL8.46.4", "Local passenger transport");

    final String code;
    final String description;

    TaxExemptionReason(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
