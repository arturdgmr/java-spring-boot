package com.java.oo.solid.openclosed.situacao;

public class Frete {
    public double para(String cidade){
        if("SAO PAULO".equalsIgnoreCase(cidade)){
            return 15;
        }
        return 30;
    }
}
