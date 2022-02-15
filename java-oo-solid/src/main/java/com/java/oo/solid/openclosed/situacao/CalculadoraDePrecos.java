package com.java.oo.solid.openclosed.situacao;

/** Esse código é bastente coeso. Temos classes com responsabilidades bem definidas. A TabelaDePrecoPadrao
 *  calcula o desconto do poroduto, a classe Frete calcula o frete e a classe CalculadoraDePrecos coordena o processo e faz a conta final.
 * */

public class CalculadoraDePrecos {

    public double calcula(Compra produto){
        TabelaDePrecoPadrao tabela = new TabelaDePrecoPadrao();
        Frete correios = new Frete();

        double desconto = tabela.descontoPara(produto.getValor());
        double frete = correios.para(produto.getCidade());

        return produto.getValor() * (1-desconto) + frete;
    }
}
