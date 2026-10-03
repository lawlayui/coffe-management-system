package com.lawlayui.coffe_shop.recipe.domain.value_object;

import java.util.Objects;
import java.util.UUID;

public record RecipeId(String value) {
    public RecipeId {
        Objects.requireNonNull(value);
        if (value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException("Recipe id value cannot be blank or empty");
        }
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
