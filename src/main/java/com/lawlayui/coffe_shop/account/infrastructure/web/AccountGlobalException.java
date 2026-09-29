package com.lawlayui.coffe_shop.account.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lawlayui.coffe_shop.account.application.exception.AccountNotFoundException;
import com.lawlayui.coffe_shop.account.application.in.ErrorDto;

@RestControllerAdvice 
public class AccountGlobalException {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new ErrorDto(400, ex.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointer(NullPointerException ex) {
        return ResponseEntity.badRequest().body(new ErrorDto(400, ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleNotFound(AccountNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorDto(404, ex.getMessage()));
    }
}
