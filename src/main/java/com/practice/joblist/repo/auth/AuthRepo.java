package com.practice.joblist.repo.auth;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<AuthModel, String> {
    AuthModel findByUsername(String username);
}
