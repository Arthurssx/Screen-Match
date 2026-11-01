package io.arthurssx.github.modelos;

import io.arthurssx.github.Requisitos.Classificavel;

public class Filme extends Titulo implements Classificavel {
   private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        if (getTotalDeAvaliacoes() == 0) {
            return -1;
        }
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + getNome() + " (" + getAnoDeLancamento() + ")";
    }
}
