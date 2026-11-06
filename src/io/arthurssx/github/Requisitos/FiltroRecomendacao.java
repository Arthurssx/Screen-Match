package io.arthurssx.github.Requisitos;

public class FiltroRecomendacao {
    public void filtra(Classificavel classificavel) {
        int classificacao = classificavel.getClassificacao();

        if (classificacao == -1) {
            System.out.println("Sem avaliações");
        } else if (classificacao >= 4) {
            System.out.println("Está entre os preferidos");
        } else if (classificacao >= 2) {
            System.out.println("Bem avaliado");
        } else {
            System.out.println("Não está entre os mais assistidos");
        }
    }
}
