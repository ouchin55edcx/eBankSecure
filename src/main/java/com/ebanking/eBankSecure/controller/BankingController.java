package com.ebanking.eBankSecure.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class BankingController {

    @GetMapping("/notices")
    public ResponseEntity<String> getNotices() {
        return ResponseEntity.ok("System Announcements Available");
    }

    @GetMapping("/contact")
    public ResponseEntity<String> getContactInfo() {
        return ResponseEntity.ok("Customer Support: support@ebanking.com");
    }

    @GetMapping("/myLoans")
    public ResponseEntity<String> getMyLoans(Authentication authentication) {
        return ResponseEntity.ok("Loans for user: " + authentication.getName());
    }

    @GetMapping("/myCards")
    public ResponseEntity<String> getMyCards(Authentication authentication) {
        return ResponseEntity.ok("Cards for user: " + authentication.getName());
    }

    @GetMapping("/myAccount")
    public ResponseEntity<String> getMyAccount(Authentication authentication) {
        return ResponseEntity.ok("Account details for user: " + authentication.getName());
    }

    @GetMapping("/myBalance")
    public ResponseEntity<String> getMyBalance(Authentication authentication) {
        return ResponseEntity.ok("Balance for user: " + authentication.getName());
    }
}