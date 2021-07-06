package com.project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private Long accountId;
    private String accountType;
    private String branch;
    private String micrCode;
    private String ifscCode;
    private String branchAddress;
    private Customer customer;
}
