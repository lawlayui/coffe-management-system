package com.lawlayui.coffe_shop.menu.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.lawlayui.coffe_shop.menu.application.out.MenuItemRepository;
import com.lawlayui.coffe_shop.menu.domain.MenuItem;

@Repository 
public class MenuItemRepositoryImpl implements  MenuItemRepository{

    private MenuItemRepositoryJpa menuItemRepositoryJpa;

    public MenuItemRepositoryImpl(MenuItemRepositoryJpa menuItemRepositoryJpa) {
        this.menuItemRepositoryJpa = menuItemRepositoryJpa;
    }

    @Override 
    public Optional<MenuItem> getByIdAndBranchId(String id, String branchId) {
        return menuItemRepositoryJpa.findByIdAndBranchId(id, branchId).map(MenuItemPersistenceMapper::toDomain);
    }

    @Override
    public List<MenuItem> getAll(int page, int pageSize) {
        return MenuItemPersistenceMapper.toDomains(menuItemRepositoryJpa.findAll(PageRequest.of(page, pageSize)).getContent());
    }

    @Override
    public Optional<MenuItem> getById(String id) {
        return menuItemRepositoryJpa.findById(id)
            .map(MenuItemPersistenceMapper::toDomain);
    }

    @Override
    public void save(MenuItem menuItem) {
        menuItemRepositoryJpa.save(MenuItemPersistenceMapper.toEntity(menuItem));
        
    }

    @Override
    public void update(MenuItem menuItem) {
        menuItemRepositoryJpa.save(MenuItemPersistenceMapper.toEntity(menuItem));
    }
    
}
