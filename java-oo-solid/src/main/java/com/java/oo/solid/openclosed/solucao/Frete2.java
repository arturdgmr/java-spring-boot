package com.java.oo.solid.openclosed.solucao;

public class Frete2 implements ServicoEntrega{
    public double para(String cidade){
        if("PERNAMBUCO".equalsIgnoreCase(cidade)){
            return 30;
        }
        return 50;
    }
}
