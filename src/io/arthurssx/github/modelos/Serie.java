package io.arthurssx.github.modelos;

public class Serie extends Titulo {
    private int episodiosPorTemporada;
    private int temporadas;
    private int minutosPorEpisodio;
    private boolean ativa;

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        if (episodiosPorTemporada < 0) {
            throw new IllegalArgumentException("A quantidade de episódios por temporada não pode ser negativa.");
        }
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        if (temporadas < 0) {
            throw new IllegalArgumentException("A quantidade de temporadas não pode ser negativa.");
        }
        this.temporadas = temporadas;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        if (minutosPorEpisodio < 0) {
            throw new IllegalArgumentException("A duração em minutos por episódio não pode ser negativa.");
        }
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas *  minutosPorEpisodio * episodiosPorTemporada;
    }
}
