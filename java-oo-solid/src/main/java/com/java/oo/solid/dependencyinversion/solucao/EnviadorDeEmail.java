package com.java.oo.solid.dependencyinversion.solucao;

public class EnviadorDeEmail implements AcaoAposGerarNota{
    @Override
    public void executa(NotaFiscal nf) {
        System.out.println("Enviando email com NF de: "+nf.getValor()+"R$");
    }
}
