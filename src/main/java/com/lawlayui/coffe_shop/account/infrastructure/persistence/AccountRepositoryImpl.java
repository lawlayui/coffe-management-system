package com.lawlayui.coffe_shop.account.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.lawlayui.coffe_shop.account.application.out.AccountRepository;
import com.lawlayui.coffe_shop.account.domain.account_root.Account;

@Repository 
public class AccountRepositoryImpl implements AccountRepository{
    private AccountRepositoryJpa accountRepositoryJpa; 

    public AccountRepositoryImpl(AccountRepositoryJpa accountRepositoryJpa) {
        this.accountRepositoryJpa= accountRepositoryJpa;
    }

    @Override
    public List<Account> getAll(int page, int pageSize) {
        List<AccountJpaEntity> accountJpaEntities = accountRepositoryJpa.findAll(PageRequest.of(page, pageSize)).getContent();
        return AccountPersistenceMapper.toDomains(accountJpaEntities);
    }

    @Override
    public Optional<Account> getById(String id) {
        Optional<AccountJpaEntity> accountJpaEntity = accountRepositoryJpa.findById(id);
        return accountJpaEntity.map(AccountPersistenceMapper::toDomain);
    }

    @Override
    public void save(Account account) {
        AccountJpaEntity accountJpaEntity = AccountPersistenceMapper.toEntity(account);
        accountRepositoryJpa.save(accountJpaEntity);
    }

    @Override
    public void update(Account account) {
        accountRepositoryJpa.save(AccountPersistenceMapper.toEntity(account));
    }

    @Override
    public Optional<Account> getByGoogleSub(String googleSub) {
        return accountRepositoryJpa.findByGoogleSub(googleSub)
            .map(AccountPersistenceMapper::toDomain);
    }

    
}
