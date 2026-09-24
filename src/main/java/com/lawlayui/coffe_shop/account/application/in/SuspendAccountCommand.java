package com.lawlayui.coffe_shop.account.application.in;

public record SuspendAccountCommand(String id, String reason) {
    public SuspendAccountCommand {
        if (reason.isEmpty() || reason.isBlank()) {
            throw new IllegalArgumentException("Reason value cannot be null or empty");
        }

        if (reason.length() < 30) {
            throw new IllegalArgumentException("Reason value must be at least 30 characters");
        }

        if (reason.length() > 300) {
            throw new IllegalArgumentException("Reason value cannot exceed 300 characters");
        }
    }
}
