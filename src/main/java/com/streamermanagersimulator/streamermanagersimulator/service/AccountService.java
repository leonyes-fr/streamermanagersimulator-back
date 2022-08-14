package com.streamermanagersimulator.streamermanagersimulator.service;

import com.streamermanagersimulator.streamermanagersimulator.model.Account;
import com.streamermanagersimulator.streamermanagersimulator.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public void addAccount(Account credential) {
        entityManager.createNativeQuery("INSERT INTO account (username, password, token) values(?, ?, ?)")
                .setParameter(1, credential.getUsername())
                .setParameter(2, credential.getPassword())
                .setParameter(3, credential.getUsername())
                .executeUpdate();
    }

    public Optional<Account> getAccountToken(Long id) {
        return accountRepository.findById(id);
    }

    public Account getActualUser(String token) {
        return accountRepository.getActualUser(token);

    }


}
