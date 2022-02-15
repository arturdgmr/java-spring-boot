package com.java.oo.solid.interfacesegregation.solucao;

public class IXMX implements CalculadoraDeImposto {
    @Override
    public double imposto(double valorCheio) {
        return 0.2 * valorCheio;
    }
}
