package com.streamermanagersimulator.streamermanagersimulator.service;

import com.streamermanagersimulator.streamermanagersimulator.model.Account;
import com.streamermanagersimulator.streamermanagersimulator.model.Streamer;
import com.streamermanagersimulator.streamermanagersimulator.repository.StreamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class StreamerService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StreamerRepository streamerRepository;

    @PersistenceContext
    public EntityManager entityManager;


    public Iterable<Streamer> getStreamers(String token) {
        Account user = accountService.getActualUser(token);
        Iterable<Streamer> test = streamerRepository.getByUser(user.getId());
        return test;
    }

}
