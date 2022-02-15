package com.java.oo.solid.interfacesegregation.problema;

/** Qual o problema dessa classe ?
 * - Você estará quebrando o contrato da classe imposto e por consequencia, pode quebrar as classes clientes.
 * - Você estará quebrando o princípio de Liskov.
 * */


public class IXMX implements Imposto{
    @Override
    public NotaFiscal geraNota() {
        throw new RuntimeException("Não gera nota para esse imposto");
        // ou return null;
    }

    @Override
    public double imposto(double valorCheio) {
        return 0.2 * valorCheio;
    }
}
