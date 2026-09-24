package com.lawlayui.coffe_shop.account.application.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String id) {
        super("Account with id " + id + " not found");
    } 
}
