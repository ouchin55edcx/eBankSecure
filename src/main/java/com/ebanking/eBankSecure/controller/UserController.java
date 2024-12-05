package com.ebanking.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/account")
    public String getAccountInfo(Authentication authentication) {
        return "Account information for user: " + authentication.getName();
    }

    @GetMapping("/balance")
    public String getBalance(Authentication authentication) {
        return "Balance information for user: " + authentication.getName();
    }
}
