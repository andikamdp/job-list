package com.practice.joblist.repo.user;

import com.practice.joblist.repo.auth.AuthModel;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<AuthModel, String> {
    AuthModel findByUsername(String username);
}
