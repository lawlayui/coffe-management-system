package com.lawlayui.coffe_shop.menu.domain.value_object;

public record BranchId(String value) {
    public BranchId {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException("Branch id cannot be blank or emtpy");
        }
    }
}
