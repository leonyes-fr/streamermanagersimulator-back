package com.streamermanagersimulator.streamermanagersimulator.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  username;

    private String password;

    private String token;

    @ManyToMany
    @JoinTable(name = "accountHasStreamer",
            joinColumns = {@JoinColumn(name = "accountId")},
            inverseJoinColumns = {@JoinColumn(name = "streamerId")})
    private Set<Streamer> streamer = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
