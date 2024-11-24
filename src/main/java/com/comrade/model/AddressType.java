package com.comrade.model;

public enum AddressType {

    PERMANENT("Permanent"),
    TEMPORARY("Temporary");
    private final String name;
    AddressType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
