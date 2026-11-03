package io.arthurssx.github.Principal;

import io.arthurssx.github.modelos.Filme;
import io.arthurssx.github.modelos.Serie;
import io.arthurssx.github.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(10);
        Filme filmeJulia = new Filme("Snoppy", 2010);
        filmeJulia.avalia(9);
        Serie serie = new Serie("Dr House", 2002);
        serie.avalia(8);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(filmeJulia);
        lista.add(serie);

        for (Titulo item: lista) {
            System.out.println("Nome: " + item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtistas = new ArrayList<>();
        buscaPorArtistas.add("Arthur");
        buscaPorArtistas.add("Silva");
        buscaPorArtistas.add("Julia");
        Collections.sort(buscaPorArtistas);
        System.out.println("Lista: " + buscaPorArtistas);

        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenado por ano:");
        System.out.println(lista);
    }
}
