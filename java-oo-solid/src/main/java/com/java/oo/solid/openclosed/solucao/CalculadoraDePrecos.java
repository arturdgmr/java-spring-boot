package com.java.oo.solid.openclosed.solucao;

/**
 *  Solução:
 *   - A classe agora recebe suas dependencias via construtor.
 *   - Dessa forma o comportamento da classe muda de acordo com as dependencias fornecidas.
 *   - A classe está aberta a extensão, bastando apenas passar diferentes dependencias para ela executar de maneira distinta.
 *   - "Separe o comportamento extensível por trás de uma interface e inverta as dependências."
 * */

public class CalculadoraDePrecos {

    private TabelaDePreco tabelaDePreco;
    private ServicoEntrega entrega;

    public CalculadoraDePrecos(TabelaDePreco tabelaDePreco, ServicoEntrega entrega) {
        this.tabelaDePreco = tabelaDePreco;
        this.entrega = entrega;
    }

    public double calcula(Compra produto){
        double desconto = tabelaDePreco.descontoPara(produto.getValor());
        double frete = entrega.para(produto.getCidade());

        return produto.getValor() * (1-desconto) + frete;
    }
}
