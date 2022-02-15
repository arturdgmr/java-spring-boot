package com.java.oo.solid.singleresponsiblity.solucao;

public enum CargoEnum {
    DESENVOLVEDOR(new DezOuVintePorCento()),
    TESTER(new QuinzeOuVinteCincoPorCento()),
    DBA(new QuinzeOuVinteCincoPorCento());

    private RegraDeCalculo regraDeCalculo;

    CargoEnum(RegraDeCalculo regraDeCalculo) {
        this.regraDeCalculo = regraDeCalculo;
    }

    public RegraDeCalculo getRegraDeCalculo() {
        return regraDeCalculo;
    }
}
