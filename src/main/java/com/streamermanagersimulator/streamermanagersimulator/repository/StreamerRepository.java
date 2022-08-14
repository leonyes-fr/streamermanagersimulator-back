package com.streamermanagersimulator.streamermanagersimulator.repository;

import com.streamermanagersimulator.streamermanagersimulator.model.Account;
import com.streamermanagersimulator.streamermanagersimulator.model.Streamer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamerRepository extends CrudRepository<Streamer, Long> {

    @Query(value = "SELECT * FROM streamer s INNER JOIN accountHasStreamer a on s.id = a.streamerId where a.accountId = :id", nativeQuery = true)
    Iterable<Streamer> getByUser(long id);



}