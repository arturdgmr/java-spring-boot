package com.java.springretry.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InvestmentEnum {

    FUNDOS("Fundos"),
    CDB("CDB");

    private final String nome;
}
