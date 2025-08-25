package com.example.userAccount.service;

import com.example.userAccount.model.Account;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final Map<UUID, Account> users = new HashMap<>();
    private final EmailService emailService;

    public AccountService(EmailService emailService) {
        this.emailService = emailService;
    }

    public Account createAccount(String firstName, String lastName, String email) {
        Account user = new Account(UUID.randomUUID(), firstName, lastName, email, LocalDateTime.now());
        users.put(user.getId(), user);
        emailService.sendWelcomeEmail(user);
        return user;
    }

    public Optional<Account> findById(UUID id) {
        return Optional.ofNullable(users.get(id));
    }
}
