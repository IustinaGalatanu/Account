package com.example.userAccount.service;

import com.example.userAccount.model.Account;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final String APP_NAME = "AccountApp";
    private static final String SUPPORT_EMAIL = "support@accountapp.com";

    public void sendWelcomeEmail(Account account) {
        String message = "Subject: Welcome to " + APP_NAME + "!\n\n" +
                "Hello " + account.getFirstName() + ",\n\n" +
                "We're excited to let you know that your account for " + APP_NAME + " has been successfully created!\n\n" +
                "You can check your account here: http://localhost:8080/api/account/" + account.getId() + "\n\n" +
                "Our support team is here to assist you. You can reach us at " + SUPPORT_EMAIL + "\n\n" +
                "Thank you for choosing " + APP_NAME + "!\n\n" +
                "Warm regards,\nThe " + APP_NAME + " Team";

             System.out.println(message);
    }
}
