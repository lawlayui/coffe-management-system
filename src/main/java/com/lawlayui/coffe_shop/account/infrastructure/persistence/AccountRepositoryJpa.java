package com.lawlayui.coffe_shop.account.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositoryJpa extends JpaRepository<AccountJpaEntity, String>{
    
}
