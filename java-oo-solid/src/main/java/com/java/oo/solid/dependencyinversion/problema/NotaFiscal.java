package com.java.oo.solid.dependencyinversion.problema;

public class NotaFiscal {
    private double valor;
    private double impostoSimples;

    public NotaFiscal(double valor, double importoSimplesSobreO) {
        this.impostoSimples = importoSimplesSobreO;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getImpostoSimples() {
        return impostoSimples;
    }

    public void setImpostoSimples(double impostoSimples) {
        this.impostoSimples = impostoSimples;
    }
}
