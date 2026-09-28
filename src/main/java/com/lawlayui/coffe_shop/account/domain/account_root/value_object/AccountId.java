package com.lawlayui.coffe_shop.account.domain.account_root.value_object;

import java.util.UUID;

public record AccountId(String value) {
    public AccountId {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException("Account id value cannot be blank or empty");
        }
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
