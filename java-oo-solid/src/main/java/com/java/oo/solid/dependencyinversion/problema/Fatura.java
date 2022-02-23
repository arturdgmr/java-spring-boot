package com.java.oo.solid.dependencyinversion.problema;

public class Fatura {
    private double valodMensal;

    public Fatura(double valodMensal) {
        this.valodMensal = valodMensal;
    }

    public double getValodMensal() {
        return valodMensal;
    }

    public void setValodMensal(double valodMensal) {
        this.valodMensal = valodMensal;
    }
}
