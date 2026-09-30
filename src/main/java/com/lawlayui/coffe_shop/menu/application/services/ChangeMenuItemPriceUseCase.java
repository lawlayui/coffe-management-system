package com.lawlayui.coffe_shop.menu.application.services;

import com.lawlayui.coffe_shop.menu.application.exception.MenuItemNotFoundException;
import com.lawlayui.coffe_shop.menu.application.in.ChangeMenuItemPriceCommand;
import com.lawlayui.coffe_shop.menu.application.out.MenuItemRepository;
import com.lawlayui.coffe_shop.menu.domain.MenuItem;

public class ChangeMenuItemPriceUseCase {
    private MenuItemRepository menuItemRepository;

    public ChangeMenuItemPriceUseCase(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public void changePrice(ChangeMenuItemPriceCommand command) {
        MenuItem menuItem = menuItemRepository.getById(command.id())
            .orElseThrow(() -> new MenuItemNotFoundException(command.id()));

        menuItem.changePrice(command.price());
        menuItemRepository.update(menuItem);
    }
}
