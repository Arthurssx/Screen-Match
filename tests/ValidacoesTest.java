import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class ValidacoesTest {
    private static int verificacoes;
    private static int falhas;

    public static void main(String[] args) {
        executa("sem avaliacoes", ValidacoesTest::testaSemAvaliacoes);
        executa("notas validas", ValidacoesTest::testaNotasValidas);
        double[] invalidas = {-1, 11, 8.5, Double.NaN,
                Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        for (double nota : invalidas) {
            executa("nota " + nota, () -> testaNotaInvalida(nota));
        }
        for (Titulo titulo : new Titulo[]{new Titulo(), new Filme()}) {
            executa("duracao de " + titulo.getClass().getSimpleName(), () ->
                    testaNaoNegativo(titulo::setDuracaoEmMinutos, titulo::getDuracaoEmMinutos, 180));
        }
        Serie serie = novaSerie();
        executa("temporadas", () -> testaNaoNegativo(serie::setTemporadas, serie::getTemporadas, 7));
        executa("episodios", () -> testaNaoNegativo(
                serie::setEpisodiosPorTemporada, serie::getEpisodiosPorTemporada, 12));
        executa("minutos por episodio", () -> testaNaoNegativo(
                serie::setMinutosPorEpisodio, serie::getMinutosPorEpisodio, 45));
        executa("duracao herdada de Serie", ValidacoesTest::testaDuracaoHerdadaDeSerie);
        executa("maratona", ValidacoesTest::testaMaratona);
        System.out.println(verificacoes + " verificacoes, " + falhas + " falhas.");
        if (falhas > 0) {
            throw new AssertionError("Falharam " + falhas + " verificacoes.");
        }
    }

    private static void testaSemAvaliacoes() {
        Titulo titulo = new Titulo();
        verifica("Sem avaliações".equals(titulo.pegaMediaFormatada()), "mensagem sem avaliacoes");
        esperaExcecao(IllegalStateException.class, () -> titulo.pegaMedia());
        igual(0, titulo.getTotalDeAvaliacoes(), "consulta nao cria avaliacoes");
    }

    private static void testaNotasValidas() {
        Titulo titulo = new Titulo();
        titulo.avalia(0);
        titulo.avalia(10);
        titulo.avalia(8.0);
        igual(3, titulo.getTotalDeAvaliacoes(), "aceita 0, 10 e 8.0");
        igual(6.0, titulo.pegaMedia(), "media das notas validas");
        Titulo fracionaria = new Titulo();
        fracionaria.avalia(8);
        fracionaria.avalia(5);
        fracionaria.avalia(10);
        igual(7.666666666666667, fracionaria.pegaMedia(), "media preserva parte fracionaria");
    }

    private static void testaNotaInvalida(double nota) {
        Titulo titulo = new Titulo();
        titulo.avalia(8);
        titulo.avalia(6);
        esperaExcecao(IllegalArgumentException.class, () -> titulo.avalia(nota));
        igual(2, titulo.getTotalDeAvaliacoes(), "nota " + nota + " preserva contador");
        igual(7.0, titulo.pegaMedia(), "nota " + nota + " preserva soma");
        titulo.avalia(10);
        igual(3, titulo.getTotalDeAvaliacoes(), "aceita nota depois da rejeicao");
        igual(8.0, titulo.pegaMedia(), "media correta depois da rejeicao");
    }

    private static void testaNaoNegativo(IntConsumer setter, IntSupplier getter, int anterior) {
        setter.accept(anterior);
        esperaExcecao(IllegalArgumentException.class, () -> setter.accept(-1));
        igual(anterior, getter.getAsInt(), "negativo preserva valor anterior");
        setter.accept(0);
        igual(0, getter.getAsInt(), "aceita zero");
    }

    private static void testaDuracaoHerdadaDeSerie() {
        Serie serie = novaSerie();
        serie.setDuracaoEmMinutos(180);
        esperaExcecao(IllegalArgumentException.class, () -> serie.setDuracaoEmMinutos(-1));
        igual(3780, serie.getDuracaoEmMinutos(), "serie preserva duracao calculada");
        serie.setDuracaoEmMinutos(0);
        igual(3780, serie.getDuracaoEmMinutos(), "setter herdado aceita zero");
    }

    private static void testaMaratona() {
        Serie serie = novaSerie();
        Filme filme = new Filme();
        filme.setDuracaoEmMinutos(180);
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        igual(3780, serie.getDuracaoEmMinutos(), "serie 7 x 12 x 45");
        calculadora.tempoTotal(filme);
        igual(180, calculadora.getTempoTotal(), "adiciona filme");
        calculadora.tempoTotal(serie);
        igual(3960, calculadora.getTempoTotal(), "soma filme e serie por polimorfismo");
    }

    private static Serie novaSerie() {
        Serie serie = new Serie();
        serie.setTemporadas(7);
        serie.setEpisodiosPorTemporada(12);
        serie.setMinutosPorEpisodio(45);
        return serie;
    }

    private static void executa(String nome, Runnable teste) {
        try { teste.run(); }
        catch (RuntimeException | AssertionError erro) { verifica(false, nome + ": " + erro); }
    }

    private static void esperaExcecao(Class<? extends RuntimeException> tipo, Runnable acao) {
        try { acao.run(); verifica(false, "esperava " + tipo.getSimpleName()); }
        catch (RuntimeException erro) { verifica(tipo.isInstance(erro), "excecao recebida: " + erro); }
    }

    private static void igual(double esperado, double atual, String mensagem) {
        verifica(Double.compare(esperado, atual) == 0,
                mensagem + ": esperado " + esperado + ", recebido " + atual);
    }

    private static void verifica(boolean condicao, String mensagem) {
        verificacoes++;
        if (!condicao) { falhas++; System.err.println("FALHA: " + mensagem); }
    }
}
