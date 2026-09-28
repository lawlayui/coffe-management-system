package com.lawlayui.coffe_shop.menu.domain;

import java.math.BigDecimal;

import com.lawlayui.coffe_shop.menu.domain.value_object.BranchId;
import com.lawlayui.coffe_shop.menu.domain.value_object.MenuItemId;
import com.lawlayui.coffe_shop.menu.domain.value_object.MenuStatus;
import com.lawlayui.coffe_shop.menu.domain.value_object.Price;
import com.lawlayui.coffe_shop.menu.domain.value_object.RecipeId;

public class MenuItem {
    private MenuItemId menuItemId;
    private BranchId branchId;
    private RecipeId recipeId; 
    private MenuStatus menuStatus; 
    private Price price; 
    
    
    private MenuItem(MenuItemId menuItemId, BranchId branchId, RecipeId recipeId, MenuStatus menuStatus, Price price) {
        this.menuItemId = menuItemId;
        this.branchId = branchId;
        this.recipeId = recipeId;
        this.menuStatus = menuStatus;
        this.price = price;
    }

    public static MenuItem create(String id, String branchId, String recipeId, MenuStatus status, BigDecimal price) {
        return new MenuItem(
            new MenuItemId(id), 
            new BranchId(branchId), 
            new RecipeId(recipeId),
            status, 
            new Price(price)
        );
    }
    
    public void markAsAvailable() {
        this.menuStatus = MenuStatus.AVAILABLE;
    }

    public void markAsOutOfStock() {
        this.menuStatus = MenuStatus.NOT_AVAILABLE;
    }

    public void changePrice(BigDecimal newPrice) {
        this.price = new Price(newPrice);
    }
    
    public MenuItemId getMenuItemId() {
        return menuItemId;
    }
    public BranchId getBranchId() {
        return branchId;
    }
    public RecipeId getRecipeId() {
        return recipeId;
    }
    public MenuStatus getMenuStatus() {
        return menuStatus;
    }
    public Price getPrice() {
        return price;
    }
}
