package com.lawlayui.coffe_shop.account.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositoryJpa extends JpaRepository<AccountJpaEntity, String>{
    Optional<AccountJpaEntity> findByGoogleSub(String googleSub);
}
