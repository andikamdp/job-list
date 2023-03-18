package com.practice.joblist.repo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Account {
    @Id
    @Column(name = "ACC_NUMBER")
    private String accountNumber;
    private String accountOwner;
    @Column(name = "ACC_DATE_CREATED")
    private Date createdDate;
    @Column(name = "ACC_BALANCE")
    private BigDecimal accountBalance;
}
