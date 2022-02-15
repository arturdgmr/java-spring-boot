package com.java.oo.solid.openclosed.problema;

public class Frete {
    public double para(String cidade){
        if("SAO PAULO".equalsIgnoreCase(cidade)){
            return 15;
        }
        return 30;
    }
}
