package com.java.oo.solid.dependencyinversion.solucao;

public class NotaFiscalDao implements AcaoAposGerarNota {

    @Override
    public void executa(NotaFiscal nf) {
        System.out.println("Persistindo NF de: "+nf.getValor()+"R$");
    }
}
