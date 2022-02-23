package com.java.oo.solid.dependencyinversion.solucao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GeradorDeNotaFiscal geradorDeNotaFiscal = new GeradorDeNotaFiscal(List.of(new EnviadorDeEmail(), new NotaFiscalDao()));
        geradorDeNotaFiscal.gera(new Fatura(200));
    }
}
