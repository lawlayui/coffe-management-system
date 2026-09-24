package com.lawlayui.coffe_shop.account.domain.account_root.value_object;

public record Reason(String value) {
    public Reason {
        if (value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException("Reason value cannot be null or empty");
        }

        if (value.length() < 30) {
            throw new IllegalArgumentException("Reason value must be at least 30 characters");
        }

        if (value.length() > 300) {
            throw new IllegalArgumentException("Reason value cannot exceed 300 characters");
        }
    }
}
