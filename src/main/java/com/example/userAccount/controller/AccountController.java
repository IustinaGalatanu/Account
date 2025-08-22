package com.example.userAccount.controller;

import com.example.userAccount.model.Account;
import com.example.userAccount.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<Account> getById(@PathVariable UUID idUser) {
        return service.findById(idUser)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) {
        return ResponseEntity.ok(service.createAccount(account.getFirstName(), account.getLastName(), account.getEmail()));
    }
}
