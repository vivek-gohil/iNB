package com.inb.accounts.dto;

import lombok.Data;

//It will generate getter setter equals and hashcode
@Data
public class AccountsDto {
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}