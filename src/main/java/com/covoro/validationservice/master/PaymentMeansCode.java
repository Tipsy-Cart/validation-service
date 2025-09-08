package com.covoro.validationservice.master;

public enum PaymentMeansCode {

    INSTRUMENT_NOT_DEFINED("1", "Instrument not defined"),
    IN_CASH("10", "In cash"),
    CHEQUE("20", "Cheque"),
    BANKERS_DRAFT("21", "Banker's draft"),
    CREDIT_TRANSFER("30", "Credit transfer"),
    DIRECT_DEBIT("49", "Direct debit"),
    CREDIT_CARD("54", "Credit card"),
    DEBIT_CARD("55", "Debit card"),
    ONLINE_PAYMENT_SERVICE("68", "Online payment service");

    final String code;
    final String description;

    PaymentMeansCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
