package com.lawlayui.coffe_shop.account.infrastructure.persistence;

import java.util.List;

import com.lawlayui.coffe_shop.account.domain.account_root.Account;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Role;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Status;

public class AccountPersistenceMapper {
    public static Account toDomain(AccountJpaEntity accountJpaEntity) {
        Account account = Account.create(
            accountJpaEntity.getId(),
            accountJpaEntity.getName(), 
            accountJpaEntity.getEmail(), 
            accountJpaEntity.getRole() == Role.CUSTOMER.name() ? Role.CUSTOMER : Role.ADMIN,
            accountJpaEntity.getStatus() == Status.ACTIVE.name() ? Status.ACTIVE : Status.SUSPENDED,
            accountJpaEntity.getReason(),
            accountJpaEntity.getGoogleSub()
        );

        return account;
    }

    public static AccountJpaEntity toEntity(Account account) {
        AccountJpaEntity accountJpaEntity = AccountJpaEntity.builder()
            .id(account.getAccountId().value())
            .name(account.getName().value())
            .email(account.getEmail().value())
            .googleSub(account.getGoogleSub())
            .reason(account.getReason().value())
            .status(account.getStatus().name())
            .role(account.getRole().name())
            .build();

        return accountJpaEntity;
    }

    public static List<Account> toDomains(List<AccountJpaEntity> accountJpaEntities) {
        return accountJpaEntities.stream()
            .map((accountJpaEntity) -> toDomain(accountJpaEntity))
            .toList();
    }

    public static List<AccountJpaEntity> toEntities(List<Account> accounts) {
        return accounts.stream()   
            .map((account) -> toEntity(account))
            .toList();
    }
}
