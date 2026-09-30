package com.lawlayui.coffe_shop.menu.application.in;

import java.math.BigDecimal;

public record ChangeMenuItemPriceCommand(String id, BigDecimal price) {
    public ChangeMenuItemPriceCommand {
        if (price.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Price cannot be zero");
        }
        if (price.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
}
