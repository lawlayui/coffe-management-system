package com.lawlayui.coffe_shop.menu.application.services;

import java.util.List;

import com.lawlayui.coffe_shop.menu.application.in.GetAllMenuItemQuery;
import com.lawlayui.coffe_shop.menu.application.out.MenuItemRepository;
import com.lawlayui.coffe_shop.menu.domain.MenuItem;

public class GetAllMenuItemUseCase {
    private MenuItemRepository menuItemRepository; 

    public GetAllMenuItemUseCase(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getAll(GetAllMenuItemQuery query) {
        return menuItemRepository.getAll(query.page(), query.pageSize());
    }
}
