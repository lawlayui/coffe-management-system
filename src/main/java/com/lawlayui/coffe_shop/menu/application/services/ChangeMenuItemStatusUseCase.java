package com.lawlayui.coffe_shop.menu.application.services;

import java.math.BigDecimal;

import com.lawlayui.coffe_shop.menu.application.exception.MenuItemNotFound;
import com.lawlayui.coffe_shop.menu.application.out.MenuItemRepository;
import com.lawlayui.coffe_shop.menu.domain.MenuItem;

public class ChangeMenuItemStatusUseCase {
    private MenuItemRepository menuItemRepository;

    public ChangeMenuItemStatusUseCase(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public void changePrice(String id, BigDecimal newPrice) {
        MenuItem menuItem = menuItemRepository.getById(id)
            .orElseThrow(() -> new MenuItemNotFound(id));

        menuItem.changePrice(newPrice);
        menuItemRepository.update(menuItem);
    }
}
