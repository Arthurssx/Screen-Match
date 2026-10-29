package io.arthurssx.github.Requisitos;

public class FiltroRecomendacao {
    private String recomendacao;

    public void filtra(Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Bem avaliado");
        }
        else {
            System.out.println("Não está entre os mais assistidos");
        }
    }
}
