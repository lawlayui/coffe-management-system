package com.lawlayui.coffe_shop.account.domain.account_root.value_object;

public record Name(String value) {
    public Name {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException("Account name cannot be blank or empty");
        }
         
        String trimmedValue = value.trim();

        if (trimmedValue.length() < 3) {
            throw new IllegalArgumentException("Account name must be at least 3 characters");
        }

        if (trimmedValue.length() > 60) {
            throw new IllegalArgumentException("Account name cannot exceed 60 characters");
        }
    }
}
