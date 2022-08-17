package com.streamermanagersimulator.streamermanagersimulator.repository;

import com.streamermanagersimulator.streamermanagersimulator.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO account (username, password, token) values(:username, :password, :username)", nativeQuery = true)
    void addAccount(String username, String password );

    @Query(value = "SELECT * FROM account a where a.username= :username and a.password= :password", nativeQuery = true)
    Account findAccount(String username, String password);

    @Query(value = "SELECT * FROM account a where a.token= :token", nativeQuery = true)
    Account getActualUser(String token);


}
