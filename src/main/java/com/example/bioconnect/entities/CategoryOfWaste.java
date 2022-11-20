package com.example.bioconnect.entities;

public enum CategoryOfWaste {
    HASH("HASH"), GRASS("GRASS"), WOOD("WOOD");
    private final String code;

    CategoryOfWaste(String role) {
        code = role;
    }

    public String getCode() {
        return code;
    }
}
