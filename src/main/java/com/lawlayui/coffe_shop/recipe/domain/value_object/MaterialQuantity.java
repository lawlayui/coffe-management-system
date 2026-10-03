package com.lawlayui.coffe_shop.recipe.domain.value_object;

import java.util.Objects;

public record MaterialQuantity(Float value) {
    public MaterialQuantity {
        Objects.requireNonNull(value);
        if (value < 0) {
            throw new IllegalArgumentException("Material quantity cannot be negative");
        }
    }
}
