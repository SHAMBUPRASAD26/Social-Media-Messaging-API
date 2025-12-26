package com.example.social_media_api.service;

import com.example.social_media_api.entity.Account;
import com.example.social_media_api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    public Account register(Account account) {
        if (account.getUsername().isBlank() || account.getPassword().length() < 4)
            return null;

        if (repo.findByUsername(account.getUsername()).isPresent())
            throw new RuntimeException("DUPLICATE");

        return repo.save(account);
    }

    public Account login(Account account) {
        return repo.findByUsername(account.getUsername())
                .filter(a -> a.getPassword().equals(account.getPassword()))
                .orElse(null);
    }

    public boolean exists(Integer id) {
        return repo.existsById(id);
    }
}
