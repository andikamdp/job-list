package com.practice.joblist.dto.response;

import lombok.Data;

@Data
public class RecrutementResponse {
    private String id;
    private String type;
    private String url;
    private String created_at;
    private String company;
    private String company_url;
    private String location;
    private String title;
    private String description;
    private String how_to_apply;
    private String company_logo;
}
