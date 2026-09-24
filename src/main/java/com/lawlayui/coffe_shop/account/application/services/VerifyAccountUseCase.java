package com.lawlayui.coffe_shop.account.application.services;


import com.lawlayui.coffe_shop.account.application.exception.AccountNotFoundException;
import com.lawlayui.coffe_shop.account.application.out.AccountRepository;
import com.lawlayui.coffe_shop.account.domain.account_root.Account;

public class VerifyAccountUseCase {
    private AccountRepository accountRepository;

    public VerifyAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void verifyAccount(String id) {
        Account account = accountRepository.getById(id)
            .orElseThrow(() -> new AccountNotFoundException(id));

        account.verifyAccount();

        accountRepository.update(account);
    }
}
