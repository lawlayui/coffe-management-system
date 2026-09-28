package com.lawlayui.coffe_shop.menu.application.services;

import com.lawlayui.coffe_shop.menu.application.exception.MenuItemNotFound;
import com.lawlayui.coffe_shop.menu.application.out.MenuItemRepository;
import com.lawlayui.coffe_shop.menu.domain.MenuItem;

public class MarkMenuItemStatusNotAvailableUseCase {
    
    private MenuItemRepository menuItemRepository; 
    
    public MarkMenuItemStatusNotAvailableUseCase(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public void mark(String id) {
        MenuItem menuItem = menuItemRepository.getById(id)
            .orElseThrow(() -> new MenuItemNotFound(id));

        menuItem.markAsOutOfStock();
        menuItemRepository.update(menuItem);
    }
}
