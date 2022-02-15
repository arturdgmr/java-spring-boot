package com.java.oo.solid.singleresponsiblity.problema;

/** Qual o problema dessa classe ?
 *  - Falta de coesão
 *  - Classe tende a ser gigante com a entrada de novos cargos no sistema. Imagine essa classe com 30 cargos diferentes.
 *  - Sempre vai crescer na vertical. Quantos mais cargos, mais metodos novos e mais if e else.
 *  - Se houver a necessidade de reutilizar o metodo "dezOuVintePorCento", vai ter que levar toda a classe junto.
 *  - O mais importante: Se apenas uma regra de calculo mudar, essa classe mudará.
 * */

public class CalculadoraDeSalario {

    public double calcula(Funcionario funcionario){
        if(CargoEnum.DESENVOLVEDOR.equals(funcionario.getCargo())){
            return dezOuVintePorCento(funcionario);
        }
        if(CargoEnum.DBA.equals(funcionario.getCargo())){
            return quinzeOuVinteCincoPorCento(funcionario);
        }
        throw new RuntimeException("funcionario invalido");
    }

    private double dezOuVintePorCento(Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 3000) {
            return funcionario.getSalarioBase() * 0.8;
        } else {
            return funcionario.getSalarioBase() * 0.9;
        }
    }

    private double quinzeOuVinteCincoPorCento(Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 5000) {
            return funcionario.getSalarioBase() * 0.75;
        } else {
            return funcionario.getSalarioBase() * 0.85;
        }
    }
}
