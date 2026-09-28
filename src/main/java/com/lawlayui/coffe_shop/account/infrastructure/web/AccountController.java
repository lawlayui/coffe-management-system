package com.lawlayui.coffe_shop.account.infrastructure.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawlayui.coffe_shop.account.application.in.AccountGetAllQuery;
import com.lawlayui.coffe_shop.account.application.in.SuspendAccountCommand;
import com.lawlayui.coffe_shop.account.application.services.AccountGetAllUseCase;
import com.lawlayui.coffe_shop.account.application.services.AccountGetByIdUseCase;
import com.lawlayui.coffe_shop.account.application.services.AssignRoleAccountUseCase;
import com.lawlayui.coffe_shop.account.application.services.SuspendAccountUseCase;
import com.lawlayui.coffe_shop.account.application.services.VerifyAccountUseCase;
import com.lawlayui.coffe_shop.account.domain.account_root.Account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor 
@NoArgsConstructor 
public class AccountController {
    private AccountGetByIdUseCase accountGetByIdUseCase;
    private AccountGetAllUseCase accountGetAllUseCase;
    private SuspendAccountUseCase suspendAccountUseCase;
    private AssignRoleAccountUseCase assignRoleAccountUseCase;
    private VerifyAccountUseCase verifyAccountUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable String id) {
        return ResponseEntity.ok(accountGetByIdUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll(@RequestParam  int page, @RequestParam  int pageSize) {
        return ResponseEntity.ok(accountGetAllUseCase.getAll(new AccountGetAllQuery(page, pageSize)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> suspend(@PathVariable String id, @RequestBody SuspendAccountCommand command) {
        suspendAccountUseCase.suspendAccount(new SuspendAccountCommand(id, command.reason()));
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> assignRole(@PathVariable String id) {
        assignRoleAccountUseCase.assignRole(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> verify(@PathVariable String id) {
        verifyAccountUseCase.verifyAccount(id);
        return ResponseEntity.noContent().build();
    }
}
