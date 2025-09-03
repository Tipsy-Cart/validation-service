package com.covoro.validationservice.master;

public enum BillingFrequency {

    DAILY("Daily", "DLY"),
    WEEKLY("Weekly", "WKY"),
    ONCE_IN_15_DAYS("Once in 15 days", "Q15"),
    MONTHLY("Monthly", "MTH"),
    ONCE_IN_45_DAYS("Once in 45 days", "Q45"),
    ONCE_IN_60_DAYS("Once in 60 days", "Q60"),
    QUARTERLY("Quarterly", "QTR"),
    YEARLY("Yearly", "YRL"),
    HALF_YEARLY("Half-Yearly", "HYR"),
    OTHERS("Others", "OTH");

    final String description;
    final String code;

    BillingFrequency(String description, String code) {
        this.description = description;
        this.code = code;
    }

}
