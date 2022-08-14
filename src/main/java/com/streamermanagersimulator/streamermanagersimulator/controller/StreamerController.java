package com.streamermanagersimulator.streamermanagersimulator.controller;

import com.streamermanagersimulator.streamermanagersimulator.model.Account;
import com.streamermanagersimulator.streamermanagersimulator.model.Streamer;
import com.streamermanagersimulator.streamermanagersimulator.service.StreamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class StreamerController {

    @Autowired
    private StreamerService streamerService;


    @GetMapping("/streamers")
    public Iterable<Streamer> getInventories(@RequestHeader("authorization") String token) {
        return streamerService.getStreamers(token);
    }


}
