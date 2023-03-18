package com.practice.joblist.controller;

import com.practice.joblist.dto.response.RecrutementResponse;
import com.practice.joblist.service.RecrutementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecrutementController {

    private final RecrutementService<RecrutementResponse, byte[]> recrutementResponseRecrutementService;

    @ResponseStatus
    @GetMapping("/api/recruitment/positions")
    public List<RecrutementResponse> recrutement(){
        return this.recrutementResponseRecrutementService.findAllRecrutement();
    }

    @ResponseStatus
    @GetMapping("/api/recruitment/positions/{id}")
    public RecrutementResponse recrutement(@PathVariable(value = "id") String id){
        return this.recrutementResponseRecrutementService.findRecrutementById(id);
    }

}
