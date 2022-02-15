package com.java.oo.solid.singleresponsiblity.solucao;

public class DezOuVintePorCento implements RegraDeCalculo{
    @Override
    public double calcula(Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 3000) {
            return funcionario.getSalarioBase() * 0.8;
        } else {
            return funcionario.getSalarioBase() * 0.9;
        }
    }
}
