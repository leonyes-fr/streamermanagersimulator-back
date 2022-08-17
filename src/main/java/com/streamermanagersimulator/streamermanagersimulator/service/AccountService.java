package com.streamermanagersimulator.streamermanagersimulator.service;

import com.streamermanagersimulator.streamermanagersimulator.model.Account;
import com.streamermanagersimulator.streamermanagersimulator.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void addAccount(Account credential) {
        accountRepository.addAccount(credential.getUsername(), credential.getPassword());
    }

    public Account getActualUser(String token) {
        return accountRepository.getActualUser(token);

    }

}
