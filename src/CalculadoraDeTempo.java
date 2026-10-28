public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void tempoTotal(Titulo titulo){
        tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
