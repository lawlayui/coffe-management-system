package com.lawlayui.coffe_shop.account.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lawlayui.coffe_shop.account.application.out.AccountRepository;
import com.lawlayui.coffe_shop.account.application.services.*;

@Configuration 
public class AccountBeanConfiguration {
    @Bean 
    public AccountGetAllUseCase accountGetAllUseCase(AccountRepository accountRepository) {
        return new AccountGetAllUseCase(accountRepository);
    }

    @Bean 
    public AccountGetByIdUseCase accountGetByIdUseCase(AccountRepository accountRepository) {
        return new AccountGetByIdUseCase(accountRepository);
    }

    @Bean 
    public AssignRoleAccountUseCase assignRoleAccountUseCase(AccountRepository accountRepository) {
        return new AssignRoleAccountUseCase(accountRepository);
    }

    @Bean 
    public SuspendAccountUseCase suspendAccountUseCase(AccountRepository accountRepository) {
        return new SuspendAccountUseCase(accountRepository);
    }

    @Bean 
    public VerifyAccountUseCase verifyAccountUseCase(AccountRepository accountRepository) {
        return new VerifyAccountUseCase(accountRepository);
    }
}
