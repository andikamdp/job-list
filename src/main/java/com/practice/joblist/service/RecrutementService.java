package com.practice.joblist.service;

import com.practice.joblist.dto.response.RecrutementResponse;

import java.util.List;

public interface RecrutementService<T, F> {

    List<T> findAllRecrutement();
    T findRecrutementById(String id);
    F reportRecrutement();

}
