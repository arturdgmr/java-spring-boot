package com.java.oo.solid.interfacesegregation.problema;

public class ISS implements Imposto{
    @Override
    public NotaFiscal geraNota() {
        return new NotaFiscal("Teste", 200);
    }

    @Override
    public double imposto(double valorCheio) {
        return 0.1 * valorCheio;
    }
}
