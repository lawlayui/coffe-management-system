package com.lawlayui.coffe_shop.account.application.out;

import java.util.List;
import java.util.Optional;

import com.lawlayui.coffe_shop.account.domain.account_root.Account;

public interface AccountRepository {
    void save(Account account);    
    void update(Account account);
    Optional<Account> getById(String id);
    List<Account> getAll(int page, int pageSize);
    Optional<Account> getByGoogleSub(String googleSub);
}
