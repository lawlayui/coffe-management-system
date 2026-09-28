package com.lawlayui.coffe_shop.infrastructure.services;


import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.lawlayui.coffe_shop.account.domain.account_root.value_object.AccountId;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Role;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Status;
import com.lawlayui.coffe_shop.account.infrastructure.persistence.AccountJpaEntity;
import com.lawlayui.coffe_shop.account.infrastructure.persistence.AccountRepositoryJpa;

@Service 
public class CustomOidcUserService extends OidcUserService {
    private AccountRepositoryJpa accountRepository;

    public CustomOidcUserService(AccountRepositoryJpa accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override 
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);

        String googleSub = oidcUser.getSubject();

        String email = oidcUser.getEmail();
        String name = oidcUser.getName();

        processUserLogin(googleSub, email, name);

        return oidcUser;
    }

    private void processUserLogin(String googleSub, String email, String name) {
        accountRepository.findByGoogleSub(googleSub)
            .map(existingUser -> {
                existingUser.setName(name);
                return accountRepository.save(existingUser);
            })

            .orElseGet(() -> {
                AccountJpaEntity accountJpaEntity = AccountJpaEntity.builder()
                .id(AccountId.generateId())
                .googleSub(googleSub)
                .name(name)
                .email(email)
                .status(Status.ACTIVE.name())
                .role(Role.CUSTOMER.name())
                .build();

                return accountJpaEntity;
            });
    }
}
