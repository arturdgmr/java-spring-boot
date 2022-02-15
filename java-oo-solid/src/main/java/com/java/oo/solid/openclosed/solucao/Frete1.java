package com.java.oo.solid.openclosed.solucao;

public class Frete1 implements ServicoEntrega{
    public double para(String cidade){
        if("SAO PAULO".equalsIgnoreCase(cidade)){
            return 15;
        }
        return 30;
    }
}
