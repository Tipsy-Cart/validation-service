package com.covoro.validationservice.master;

public enum InvoiceTransactionType {

    Not_Applicable("Not Applicable", "00000000"),
    Free_Trade_Zone("Free Trade zone", "10000000"),
    Deemed_Supply("Deemed Supply", "01000000"),
    Margin_Scheme("Margin Scheme", "00100000"),
    Summary_Invoice("Summary Invoice", "00010000"),
    Continuous_Supply("Continuous Supply", "00001000"),
    Disclosed_Agent_Billing("Disclosed Agent Billing", "00000100"),
    Supply_Through_Ecommerce("Supply through e- commerce", "00000010"),
    Exports("Exports", "00000001");

    final String description;
    final String code;

    InvoiceTransactionType(final String description, final String code) {
        this.description = description;
        this.code = code;
    }

}
