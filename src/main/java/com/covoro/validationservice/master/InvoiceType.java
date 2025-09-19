package com.covoro.validationservice.master;

public enum InvoiceType {

    COMMERCIAL_INVOICE("380", "Commercial Invoice"),
    INVOICE_OUT_OF_SCOPE("480", "Invoice out of Scope of Tax"),
    CREDIT_NOTE("381", "Credit note"),
    CREDIT_NOTE_GOODS_SERVICES("81", "Credit note related to goods or services"),
    SELF_BILLED_INVOICE("389", "Self-billed invoice"),
    SELF_BILLED_CREDIT_NOTE("261", "Self billed credit note");

    final String description;
    final String code;

    InvoiceType(String description, String code) {
        this.description = description;
        this.code = code;
    }

}
