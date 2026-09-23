package com.lawlayui.coffe_shop.account.domain.account_root.value_object;

import java.util.regex.Pattern;

public record Email(String value) {
    public Email {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException("Account email cannot be null or empty");
        }

        Pattern emailPattern = Pattern.compile("^[a-zA-L0-9_+&*-]+(?:\\.[a-zA-L0-9_+&*-]+)*@(?:[a-zA-L0-9-]+\\.)+[a-zA-L]{2,7}$");
        
        if (!emailPattern.matcher(value.trim()).matches()){
            throw new IllegalArgumentException("Invalid format email");
        }
    }
}
