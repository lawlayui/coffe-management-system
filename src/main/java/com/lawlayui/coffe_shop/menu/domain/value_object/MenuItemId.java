package com.lawlayui.coffe_shop.menu.domain.value_object;

import java.util.UUID;

public record MenuItemId(String value) {
    public MenuItemId {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException("Menu id value cannot be blank or empty");
        }
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
