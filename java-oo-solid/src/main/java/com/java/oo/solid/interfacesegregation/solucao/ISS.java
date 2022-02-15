package com.java.oo.solid.interfacesegregation.solucao;

public class ISS implements CalculadoraDeImposto, GeradorDeNota {
    @Override
    public NotaFiscal geraNota() {
        return new NotaFiscal("Teste", 200);
    }

    @Override
    public double imposto(double valorCheio) {
        return 0.1 * valorCheio;
    }
}
