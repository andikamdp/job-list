package com.practice.joblist.repo.auth;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuthModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public AuthModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDetails asUser() {
        return User.withDefaultPasswordEncoder() //
                .username(getUsername()) //
                .password(getPassword()) //
                .authorities(getAuthorities()) //
                .build();
    }
}
