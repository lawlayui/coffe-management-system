package com.lawlayui.coffe_shop.menu.application.out;

import java.util.List;
import java.util.Optional;

import com.lawlayui.coffe_shop.menu.domain.MenuItem;

public interface MenuItemRepository {
    void save(MenuItem menuItem);
    void update(MenuItem menuItem);
    Optional<MenuItem> getById(String id);
    List<MenuItem> getAll(int page, int pageSize);
}

