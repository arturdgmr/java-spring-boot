package com.java.oo.solid.dependencyinversion.problema;

public class NotaFiscalDao {
    public void persiste(NotaFiscal nf) {
        System.out.println("Persistindo NF de: "+nf.getValor()+"R$");
    }
}
