package com.practice.joblist.service;

import java.util.List;

public interface RecrutementService<T, F> {

    List<T> findAllRecrutement();
    T findRecrutementById(String id);
    void reportRecrutement(F reportEngine);

}
