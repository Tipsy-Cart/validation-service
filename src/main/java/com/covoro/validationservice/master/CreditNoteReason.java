package com.covoro.validationservice.master;

public enum CreditNoteReason {

    SUPPLY_CANCELLED("DL8.61.1.A", "If the supply was cancelled."),
    TAX_TREATMENT_CHANGED("DL8.61.1.B", "If the tax treatment of the supply has changed due to a change in the nature of the supply."),
    CONSIDERATION_ALTERED("DL8.61.1.C", "If the previously agreed consideration for the supply was altered for any reason (i.e. bad debt relief)."),
    GOODS_OR_SERVICES_RETURNED("DL8.61.1.D", "If the recipient of goods or recipient of services returned them to the registrant in full or in part and the Consideration was returned in full or in part."),
    TAX_ERROR("DL8.61.1.E", "If the tax was charged or tax treatment was applied in error."),
    VOLUME_DISCOUNT("VD", "Volume Discount.");

    final String code;
    final String description;

    CreditNoteReason(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
