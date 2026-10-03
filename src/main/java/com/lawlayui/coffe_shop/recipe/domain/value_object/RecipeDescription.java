package com.lawlayui.coffe_shop.recipe.domain.value_object;

import java.util.Objects;

public record RecipeDescription(String value) {
    public RecipeDescription {
        Objects.requireNonNull(value);
        if (value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException("Recipe description cannot be empty or blank");
        }
        if (value.length() < 20) {
            throw new IllegalArgumentException("Recipe description must be at least 20 characters");
        } 
        if (value.length() > 300) {
            throw new IllegalArgumentException("Recipe description cannot exceed 300 characters");
        }
    }
}
