package com.ascendmoney.riskmanagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TemplateDTO implements Serializable {
    private String name;

    private String email;

    private String phoneNumber;

    private String country;
}
