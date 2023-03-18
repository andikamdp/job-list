package com.practice.joblist.service;

import com.practice.joblist.dto.response.RecrutementResponse;
import com.practice.joblist.feign.RecrutementPositionFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecrutementImpl implements RecrutementService<RecrutementResponse,byte[]>{

    private final RecrutementPositionFeign recrutementPositionFeign;

    @Override
    public List<RecrutementResponse> findAllRecrutement() {
        return recrutementPositionFeign.recrutement();
    }

    @Override
    public RecrutementResponse findRecrutementById(String id) {
        return recrutementPositionFeign.recrutement(id);
    }

    @Override
    public byte[] reportRecrutement() {
        return new byte[0];
    }
}
