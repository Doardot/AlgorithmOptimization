package org.algo.GreedyAlgos;

import java.util.ArrayList;
import java.util.List;

class Intervalo implements Comparable<Intervalo> {
    int inicio;
    int fim;

    public Intervalo(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public int compareTo(Intervalo outro) {
        // Ordenar pelo término (fim) em ordem crescente
        return Integer.compare(this.fim, outro.fim);
    }

    @Override
    public String toString() {
        return "(" + inicio + ", " + fim + ")";
    }
}

public class EscalonamentoDeIntervalos {

    public static List<Intervalo> sdmGuloso(List<Intervalo> intervalos) {
        // Ordenar intervalos pelo término (fim) usando Timsort (Java
        // Collections.sort())
        intervalos.sort(null);

        List<Intervalo> sdm = new ArrayList<>();
        int ultimoFim = Integer.MIN_VALUE; // Inicializar como menor valor possível
        int iteracoes = 0;

        for (Intervalo intervalo : intervalos) {
            iteracoes++;
            // Se o início do intervalo atual é maior que o fim do último selecionado
            if (intervalo.inicio > ultimoFim) {
                sdm.add(intervalo); // Adicionar intervalo à solução
                ultimoFim = intervalo.fim; // Atualizar o último fim
            }
        }

        System.out.println("Número de Iterações: " + iteracoes);
        return sdm;
    }

    public static void main(String[] args) {
        // Lista de intervalos
        List<Intervalo> intervalos = new ArrayList<>();
        intervalos.add(new Intervalo(4, 8));
        intervalos.add(new Intervalo(6, 7));
        intervalos.add(new Intervalo(13, 14));
        intervalos.add(new Intervalo(4, 5));
        intervalos.add(new Intervalo(2, 4));
        intervalos.add(new Intervalo(6, 9));
        intervalos.add(new Intervalo(7, 10));
        intervalos.add(new Intervalo(9, 11));
        intervalos.add(new Intervalo(1, 6));
        intervalos.add(new Intervalo(3, 13));
        intervalos.add(new Intervalo(9, 12));

        // Chamar o algoritmo guloso
        List<Intervalo> sdm = sdmGuloso(intervalos);

        // Exibir a SDM
        System.out.println("Subcoleção Disjunta Máxima: " + sdm);
    }
}
