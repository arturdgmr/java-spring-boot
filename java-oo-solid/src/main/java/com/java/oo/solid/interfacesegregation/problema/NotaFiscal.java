package com.java.oo.solid.interfacesegregation.problema;

public class NotaFiscal {

    private String nome;
    private double valor;

    public NotaFiscal(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }
}
