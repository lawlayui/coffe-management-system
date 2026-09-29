package com.lawlayui.coffe_shop.menu.infrastructure.persistence;

import java.util.List;

import com.lawlayui.coffe_shop.menu.domain.MenuItem;
import com.lawlayui.coffe_shop.menu.domain.value_object.MenuStatus;

public class MenuItemPersistenceMapper {
    public static MenuItem toDomain(MenuItemEntityJpa entityJpa) {
        MenuItem menuItem = MenuItem.create(
            entityJpa.getMenuItemId(), 
            entityJpa.getBranchId(), 
            entityJpa.getRecipe_id(), 
            entityJpa.getMenuStatus() == "AVAILABLE" ? MenuStatus.AVAILABLE : MenuStatus.NOT_AVAILABLE, 
            entityJpa.getPrice()
        );

        return menuItem;
    }

    public static MenuItemEntityJpa toEntity(MenuItem domain) {
        MenuItemEntityJpa menuItemEntityJpa = MenuItemEntityJpa.builder()  
            .menuItemId(domain.getMenuItemId().value())
            .branchId(domain.getBranchId().value())
            .recipe_id(domain.getRecipeId().value())
            .menuStatus(domain.getMenuStatus().name())
            .price(domain.getPrice().value())
            .build();

        return menuItemEntityJpa;
    }
    
    public static List<MenuItem> toDomains(List<MenuItemEntityJpa> entitys) {
        List<MenuItem> menuItems = entitys.stream()
            .map(entity -> toDomain(entity))
            .toList();

        return menuItems;
    }

    public static List<MenuItemEntityJpa> toEntitys(List<MenuItem> menuItems) {
        List<MenuItemEntityJpa> menuItemEntityJpas = menuItems.stream()
            .map(menuItem -> toEntity(menuItem))
            .toList();

        return menuItemEntityJpas;
    }
}
