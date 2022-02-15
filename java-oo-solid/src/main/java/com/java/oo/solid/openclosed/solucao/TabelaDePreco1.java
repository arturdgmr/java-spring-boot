package com.java.oo.solid.openclosed.solucao;

public class TabelaDePreco1 implements TabelaDePreco{

    @Override
    public double descontoPara(double valor){
        if(valor>5000) return 0.03;
        if(valor>1000) return 0.05;
        return 0;
    }
}
