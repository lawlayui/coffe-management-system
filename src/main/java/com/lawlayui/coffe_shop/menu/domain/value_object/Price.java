package com.lawlayui.coffe_shop.menu.domain.value_object;

import java.math.BigDecimal;
import java.util.Objects;

public record Price(BigDecimal value) {
    public Price {
        Objects.requireNonNull(value);
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Price cannot be zero");
        }
    }
}
