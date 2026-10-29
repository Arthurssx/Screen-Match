package io.arthurssx.github.modelos;

public class Titulo {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        if (duracaoEmMinutos < 0) {
            throw new IllegalArgumentException("A duração em minutos não pode ser negativa.");
        }
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica() {
        System.out.println("Titulo: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota) {
        if (!Double.isFinite(nota) || nota < 0 || nota > 10 || nota % 1 != 0) {
            throw new IllegalArgumentException("A nota deve ser um número inteiro entre 0 e 10.");
        }
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        if (totalDeAvaliacoes == 0) {
            throw new IllegalStateException("Sem avaliações");
        }
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String pegaMediaFormatada() {
        if (totalDeAvaliacoes == 0) {
            return "Sem avaliações";
        }
        return String.format("%.2f", pegaMedia());
    }
}
