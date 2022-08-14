package com.streamermanagersimulator.streamermanagersimulator.controller;

import com.streamermanagersimulator.streamermanagersimulator.model.Account;
import com.streamermanagersimulator.streamermanagersimulator.repository.AccountRepository;
import com.streamermanagersimulator.streamermanagersimulator.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/createaccount")
    public Account createAccount(@RequestBody Account credential) {
        accountService.addAccount(credential);
        return accountRepository.findAccount(credential.getUsername(), credential.getPassword());
    }

    @PostMapping("/auth")
    public Account getAccountToken(@RequestBody Account credential) {
        return accountRepository.findAccount(credential.getUsername(), credential.getPassword());
    }

}
