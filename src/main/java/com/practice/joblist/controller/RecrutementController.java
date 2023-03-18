package com.practice.joblist.controller;

import com.practice.joblist.dto.response.RecrutementResponse;
import com.practice.joblist.service.RecrutementService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecrutementController {

    private final RecrutementService<RecrutementResponse, Writer> recrutementResponseRecrutementService;

    @GetMapping("/recruitment")
    public List<RecrutementResponse> recrutement(){
        return this.recrutementResponseRecrutementService.findAllRecrutement();
    }

    @GetMapping("/recruitment/{id}")
    public RecrutementResponse recrutement(@PathVariable(value = "id") String id){
        return this.recrutementResponseRecrutementService.findRecrutementById(id);
    }

    @GetMapping("/recruitment/report")
    public void recrutementReport(HttpServletResponse servletResponse){
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"recrutement.csv\"");

        try {
            this.recrutementResponseRecrutementService.reportRecrutement(servletResponse.getWriter());
        } catch (IOException e) {
           log.error(e.getMessage());
        }
    }

}
