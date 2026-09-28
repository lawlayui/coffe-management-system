package com.lawlayui.coffe_shop.account.application.services;

import java.util.List;

import com.lawlayui.coffe_shop.account.application.in.AccountGetAllQuery;
import com.lawlayui.coffe_shop.account.application.out.AccountRepository;
import com.lawlayui.coffe_shop.account.domain.account_root.Account;

public class AccountGetAllUseCase {
    private AccountRepository accountRepository;

    public AccountGetAllUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAll(AccountGetAllQuery query) {
        return accountRepository.getAll(query.page(), query.pageSize());
    }
}
