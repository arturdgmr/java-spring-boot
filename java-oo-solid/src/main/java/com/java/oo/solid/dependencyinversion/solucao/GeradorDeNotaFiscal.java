package com.java.oo.solid.dependencyinversion.solucao;

import java.util.List;

public class GeradorDeNotaFiscal {
    private final List<AcaoAposGerarNota> acaoAposGerarNotaList;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acaoAposGerarNotaList) {
        this.acaoAposGerarNotaList = acaoAposGerarNotaList;
    }

    public NotaFiscal gera(Fatura fatura){
        double valor = fatura.getValodMensal();

        NotaFiscal nf = new NotaFiscal(
                valor,
                importoSimplesSobreO(valor)
        );
        for(int i=0;i<acaoAposGerarNotaList.size();i++){
            acaoAposGerarNotaList.get(i).executa(nf);
        }
        return nf;
    }

    private double importoSimplesSobreO(double valor) {
        return valor * 0.06;
    }
}
