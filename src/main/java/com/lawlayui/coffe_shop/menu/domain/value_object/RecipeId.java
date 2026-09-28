package com.lawlayui.coffe_shop.menu.domain.value_object;

public record RecipeId(String value) {
    public RecipeId {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException("Recipe id cannot be blank or empty");
        }
    }
}
