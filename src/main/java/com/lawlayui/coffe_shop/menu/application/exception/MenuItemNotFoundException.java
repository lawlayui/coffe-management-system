package com.lawlayui.coffe_shop.menu.application.exception;

public class MenuItemNotFoundException extends RuntimeException{
    public MenuItemNotFoundException(String id) {
        super("Menu item with id " + id + " not found");
    }
}
