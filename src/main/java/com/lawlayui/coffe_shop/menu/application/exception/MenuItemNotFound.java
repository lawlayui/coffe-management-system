package com.lawlayui.coffe_shop.menu.application.exception;

public class MenuItemNotFound extends RuntimeException{
    public MenuItemNotFound(String id) {
        super("Menu item with id " + id + " not found");
    }
}
