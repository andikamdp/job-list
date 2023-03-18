package com.practice.joblist.service;

import com.practice.joblist.dto.response.RecrutementResponse;
import com.practice.joblist.feign.RecrutementPositionFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecrutementImpl implements RecrutementService<RecrutementResponse, Writer>{

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
    public void reportRecrutement(Writer reportEngine) {
        List<RecrutementResponse> recrutements = recrutementPositionFeign.recrutement();
        try (CSVPrinter csvPrinter = new CSVPrinter(reportEngine, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("ID"
                    , "Type"
                    , "URL"
                    ,"CreatedDate"
                    ,"companyUrl"
                    ,"company Logo"
                    ,"Title"
                    ,"Description"
                    ,"ApplyGuid"
                    ,"Description"
                    ,"Company Logo"
                    ,"Conpay");
            for (RecrutementResponse recrutement : recrutements) {
                csvPrinter.printRecord(recrutement.getId()
                        , recrutement.getType()
                        , recrutement.getUrl()
                        , recrutement.getCreated_at()
                        , recrutement.getCompany()
                        , recrutement.getCompany_url()
                        , recrutement.getCompany_logo()
                        , recrutement.getTitle()
                        , recrutement.getDescription()
                        , recrutement.getHow_to_apply()
                        , recrutement.getCompany_logo());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}
