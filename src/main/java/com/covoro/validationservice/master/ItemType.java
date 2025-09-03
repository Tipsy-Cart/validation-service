package com.covoro.validationservice.master;

public enum ItemType {

    G("Goods", "G"),
    S("Service", "S"),
    B("Both", "B");

    final String description;
    final String code;

    ItemType(String description, String code) {
        this.description = description;
        this.code = code;
    }

}
