package com.lawlayui.coffe_shop.recipe.domain.value_object;

import java.util.Objects;

public record UnivId(String value) {
    public UnivId {
        Objects.requireNonNull(value);
        if (value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException("Univ id cannot be empty or blank");
        }
    }
}
