package com.java.oo.solid.openclosed.problema;

/**
 *  Então qual o problema dela ?
 *   - Imagine que o sistema esse sistema começa a crescer.. e começam a entrar novas regras de cálculo de desconto.
 *   - Começa a entrar novas regras de frete.
 * */

public class CalculadoraDePrecos {

    /** problema após novas regras */
    private boolean REGRA_1;
    private boolean REGRA_2;

    public double calcula(Compra produto){
        Frete correios = new Frete();
        double desconto = 0;

        if(REGRA_1){
            TabelaDePrecoPadrao tabela = new TabelaDePrecoPadrao();
            desconto = tabela.descontoPara(produto.getValor());
        }

        if(REGRA_2){
            TabelaDePrecoDiferenciada tabela = new TabelaDePrecoDiferenciada();
            desconto = tabela.descontoPara(produto.getValor());
        }

        double frete = correios.para(produto.getCidade());
        return produto.getValor() * (1-desconto) + frete;
    }
}
