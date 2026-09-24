package com.lawlayui.coffe_shop.account.application.services;

import com.lawlayui.coffe_shop.account.application.exception.AccountNotFoundException;
import com.lawlayui.coffe_shop.account.application.out.AccountRepository;
import com.lawlayui.coffe_shop.account.domain.account_root.Account;

public class AccountGetByIdUseCase {
    private  AccountRepository accountRepository;

    public AccountGetByIdUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getById(String id) {
        Account account = accountRepository.getById(id)
            .orElseThrow(() -> new AccountNotFoundException(id));

        return account;
    }
}
