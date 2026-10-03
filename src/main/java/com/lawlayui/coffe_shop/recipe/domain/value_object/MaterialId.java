package com.lawlayui.coffe_shop.recipe.domain.value_object;

import java.util.Objects;
import java.util.UUID;

public record MaterialId(String value) {
    public MaterialId {
        Objects.requireNonNull(value);
        if (value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException("Material id cannot be empty or blank");
        }
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
