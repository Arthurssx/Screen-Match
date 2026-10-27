public class Principal {
    public static void main(String[] args) {
        Titulo meuFilme = new Titulo();

        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(
                "Total de avaliações: " + meuFilme.getTotalDeAvaliacoes()
        );
        System.out.println("Média: " + meuFilme.pegaMedia());
    }
}