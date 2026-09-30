package com.lawlayui.coffe_shop.menu.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepositoryJpa extends JpaRepository<MenuItemEntityJpa, String>{
    Optional<MenuItemEntityJpa> findByIdAndBranchId(String id, String branchId);
}
