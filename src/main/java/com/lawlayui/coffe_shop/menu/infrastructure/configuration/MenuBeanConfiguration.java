package com.lawlayui.coffe_shop.menu.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lawlayui.coffe_shop.menu.application.out.MenuItemRepository;
import com.lawlayui.coffe_shop.menu.application.services.ChangeMenuItemPriceUseCase;
import com.lawlayui.coffe_shop.menu.application.services.GetAllMenuItemUseCase;
import com.lawlayui.coffe_shop.menu.application.services.GetMenuItemByIdUseCase;
import com.lawlayui.coffe_shop.menu.application.services.MarkMenuItemStatusAvailableUseCase;
import com.lawlayui.coffe_shop.menu.application.services.MarkMenuItemStatusNotAvailableUseCase;

@Configuration 
public class MenuBeanConfiguration {
    @Bean
    public GetAllMenuItemUseCase getAllMenuItemUseCase(MenuItemRepository menuItemRepository) {
        return new GetAllMenuItemUseCase(menuItemRepository);
    }

    @Bean
    public GetMenuItemByIdUseCase getMenuItemByIdUseCase(MenuItemRepository menuItemRepository) {
        return new GetMenuItemByIdUseCase(menuItemRepository);
    }

    @Bean 
    public ChangeMenuItemPriceUseCase changeMenuItemStatusUseCase(MenuItemRepository menuItemRepository) {
        return new ChangeMenuItemPriceUseCase(menuItemRepository);
    }

    @Bean 
    public MarkMenuItemStatusAvailableUseCase markMenuItemStatusAvailableUseCase(MenuItemRepository menuItemRepository) {
        return new MarkMenuItemStatusAvailableUseCase(menuItemRepository);
    }

    @Bean 
    public MarkMenuItemStatusNotAvailableUseCase markMenuItemStatusNotAvailableUseCase(MenuItemRepository menuItemRepository) {
        return new MarkMenuItemStatusNotAvailableUseCase(menuItemRepository);
    }
}
