package com.lawlayui.coffe_shop.account.application.services;

import com.lawlayui.coffe_shop.account.application.exception.AccountNotFoundException;
import com.lawlayui.coffe_shop.account.application.in.SuspendAccountCommand;
import com.lawlayui.coffe_shop.account.application.out.AccountRepository;
import com.lawlayui.coffe_shop.account.domain.account_root.Account;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Reason;

public class SuspendAccountUseCase {
    private AccountRepository accountRepository;

    public SuspendAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void suspendAccount(SuspendAccountCommand command) {
        Account account = accountRepository.getById(command.id())
            .orElseThrow(() -> new AccountNotFoundException(command.id()));

        account.suspendAccount(new Reason(command.reason()));

        accountRepository.update(account);
    }
}
