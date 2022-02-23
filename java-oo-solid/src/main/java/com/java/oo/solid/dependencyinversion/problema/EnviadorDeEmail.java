package com.java.oo.solid.dependencyinversion.problema;

public class EnviadorDeEmail {

    public void enviaEmail(NotaFiscal nf) {
        System.out.println("Enviando email com NF de: "+nf.getValor()+"R$");
    }

}
