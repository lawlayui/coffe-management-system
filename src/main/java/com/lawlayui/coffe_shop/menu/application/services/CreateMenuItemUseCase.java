package com.lawlayui.coffe_shop.menu.application.services;

import java.util.UUID;

import com.lawlayui.coffe_shop.menu.application.in.CreateMenuItemCommand;
import com.lawlayui.coffe_shop.menu.application.out.EventPublisher;
import com.lawlayui.coffe_shop.menu.application.out.MenuItemRepository;
import com.lawlayui.coffe_shop.menu.domain.MenuItem;
import com.lawlayui.coffe_shop.menu.domain.value_object.MenuItemId;
import com.lawlayui.coffe_shop.menu.domain.value_object.MenuStatus;
import com.lawlayui.coffe_shop.menu.event.MenuItemCreatedEvent;

public class CreateMenuItemUseCase {
    private MenuItemRepository menuItemRepository;
    private EventPublisher eventPublisher;

    public CreateMenuItemUseCase(MenuItemRepository menuItemRepository, EventPublisher eventPublisher) {
        this.menuItemRepository = menuItemRepository;
        this.eventPublisher = eventPublisher;
    }

    public void create(CreateMenuItemCommand command) {
        MenuItem menuItem = MenuItem.create(
            MenuItemId.generateId(), 
            command.branchId(), 
            command.recipeId(), 
            MenuStatus.DRAFT, 
            command.price(),
            UUID.randomUUID().toString()
        );

        menuItemRepository.save(menuItem);
        eventPublisher.publish(new MenuItemCreatedEvent(menuItem.getUnivId()));
    }
}
