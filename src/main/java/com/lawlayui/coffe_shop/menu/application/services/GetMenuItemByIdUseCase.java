package com.lawlayui.coffe_shop.menu.application.services;

import com.lawlayui.coffe_shop.menu.application.exception.MenuItemNotFoundException;
import com.lawlayui.coffe_shop.menu.application.out.MenuItemRepository;
import com.lawlayui.coffe_shop.menu.domain.MenuItem;

public class GetMenuItemByIdUseCase {
    private MenuItemRepository menuItemRepository;

    public GetMenuItemByIdUseCase(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem GetById(String id) {
        MenuItem menuItem = menuItemRepository.getById(id)  
            .orElseThrow(() -> new MenuItemNotFoundException(id));

        return menuItem;
    }
}