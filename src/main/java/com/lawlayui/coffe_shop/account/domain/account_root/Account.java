package com.lawlayui.coffe_shop.account.domain.account_root;


import com.lawlayui.coffe_shop.account.domain.account_root.value_object.AccountId;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Email;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Name;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Reason;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Role;
import com.lawlayui.coffe_shop.account.domain.account_root.value_object.Status;

public class Account {
    private AccountId accountId; 
    private Name name; 
    private Email email;
    private Role role; 
    private Status status;
    private Reason reason;
    private String googleSub;

    private Account(AccountId accountId,
        Name name, 
        Email email, 
        Role role, 
        Status status,
        Reason reason,
        String googleSub
    ) {
        this.accountId = accountId; 
        this.name = name; 
        this.email = email; 
        this.role = role; 
        this.status = status;
        this.reason = reason;
        this.googleSub = googleSub;
    }

    public static Account create(String accountId, 
        String name, 
        String email, 
        Role role,
        Status status,
        String reason,
        String googleSub
        ) {

        return new Account(
            new AccountId(accountId), 
            new Name(name), 
            new Email(email), 
            role, 
            status,
            new Reason(reason),
            googleSub
        );

    }

    public void suspendAccount(Reason reason) {
        this.status = Status.SUSPENDED;
        this.reason = reason;
    }

    public void verifyAccount() {
        this.status = Status.ACTIVE;
    }

    public void assignRole() {
        this.role = this.role == Role.CUSTOMER ? Role.ADMIN : Role.CUSTOMER;
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
    public Reason getReason() {
        return reason;
    }
    public String getGoogleSub() {
        return this.googleSub;
    }
}
