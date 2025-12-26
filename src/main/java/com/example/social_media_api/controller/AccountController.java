package com.example.social_media_api.controller;

import com.example.social_media_api.entity.Account;
import com.example.social_media_api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        try {
            Account saved = service.register(account);
            if (saved == null) return ResponseEntity.badRequest().build();
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        Account found = service.login(account);
        if (found == null)
            return ResponseEntity.status(401).build();
        return ResponseEntity.ok(found);
    }
}
