package com.java.oo.solid.openclosed.problema;

public class TabelaDePrecoDiferenciada {
    public double descontoPara(double valor){
        if(valor>5000) return 0.05;
        if(valor>1000) return 0.07;
        return 0;
    }
}
