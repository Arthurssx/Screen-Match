public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();

        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.setIncluidoNoPlano(true);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("Média: " + meuFilme.pegaMediaFormatada());

        Serie serie = new Serie();

        serie.setNome ("Dr House");
        serie.setAnoDeLancamento(2002);
        serie.setTemporadas(7);
        serie.setEpisodiosPorTemporada(12);
        serie.setMinutosPorEpisodio(45);
        serie.setAtiva(true);
        serie.setIncluidoNoPlano(true);
        serie.avalia(8);
        serie.avalia(10);
        serie.avalia(8);
        serie.exibeFichaTecnica();

        System.out.println("Total de Avaliações: " + serie.getTotalDeAvaliacoes());
        System.out.println("Média de avaliações: " + serie.pegaMediaFormatada());
        System.out.println("Tempo para maratonar a série: " + serie.getDuracaoEmMinutos() + " minutos");

        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.tempoTotal(meuFilme);
        calculadoraDeTempo.tempoTotal(serie);
        System.out.println("tempo total para maratonar tudo: " + calculadoraDeTempo.getTempoTotal());
    }
}