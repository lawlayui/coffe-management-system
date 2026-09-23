package com.lawlayui.coffe_shop.account.domain.account_root;

import com.lawlayui.coffe_shop.account.domain.account_root.value_object.AccountId;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Email;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Name;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Role;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Status;

public class Account {
    private AccountId accountId; 
    private Name name; 
    private Email email;
    private Role role; 
    private Status status;

    private Account(AccountId accountId,
        Name name, 
        Email email, 
        Role role, 
        Status status
    ) {
        this.accountId = accountId; 
        this.name = name; 
        this.email = email; 
        this.role = role; 
        this.status = status;
    }

    public static Account create(String accountId, 
        String name, 
        String email, 
        Role role 
        ) {

        return new Account(
            new AccountId(accountId), 
            new Name(name), 
            new Email(email), 
            Role.CUSTOMER, 
            Status.UNVERIFIED
        );

    }

    public void suspendAccount() {
        this.status = Status.SUSPENDED;
    }

    public void verifyAccount() {
        this.status = Status.ACTIVE;
    }

    public void assignRole(Role newRole) {
        this.role = newRole;
    }

    public AccountId getAccountId() {
        return accountId;
    }
    public Name getName() {
        return name;
    }
    public Email getEmail() {
        return email;
    }
    public Role getRole() {
        return role;
    }
    public Status getStatus() {
        return status;
    }
}
