package com.java.oo.solid.dependencyinversion.problema;

public class GeradorDeNotaFiscal {
    private final EnviadorDeEmail email;
    private final NotaFiscalDao dao;

    public GeradorDeNotaFiscal(EnviadorDeEmail email, NotaFiscalDao dao) {
        this.email = email;
        this.dao = dao;
    }

    public NotaFiscal gera(Fatura fatura){
        double valor = fatura.getValodMensal();

        NotaFiscal nf = new NotaFiscal(
                valor,
                importoSimplesSobreO(valor)
        );
        email.enviaEmail(nf);
        dao.persiste(nf);

        return nf;
    }

    private double importoSimplesSobreO(double valor) {
        return valor * 0.06;
    }
}
