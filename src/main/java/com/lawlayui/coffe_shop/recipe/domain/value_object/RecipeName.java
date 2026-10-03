package com.lawlayui.coffe_shop.recipe.domain.value_object;

import java.util.Objects;

public record RecipeName(String value) {
    public RecipeName {
        Objects.requireNonNull(value);
        if (value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException("Recipe name cannot be empty or blank");
        }
        if (value.length() < 3) {
            throw new IllegalArgumentException("Recipe name must be at least 3 characters");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("Recipe name cannot exceed 255 characters");
        }
    }
}
