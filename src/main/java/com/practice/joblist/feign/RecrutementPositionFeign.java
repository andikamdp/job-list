package com.practice.joblist.feign;

import com.practice.joblist.dto.response.RecrutementResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "recrutement", url = "${url.recrutement}")
public interface RecrutementPositionFeign {

    @GetMapping("/api/recruitment/positions.json")
    List<RecrutementResponse> recrutement();

    @GetMapping("/api/recruitment/positions/{id}")
    RecrutementResponse recrutement(@PathVariable(value = "id") String id);

}
