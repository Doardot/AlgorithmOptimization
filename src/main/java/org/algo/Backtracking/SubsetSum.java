package org.algo.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[] conjunto = { -7, -3, -2, 5, 8 };
        List<Integer> resultado = encontrarSubconjuntoSomaZero(conjunto);

        if (!resultado.isEmpty()) {
            System.out.println("Subconjunto encontrado: " + resultado);
        } else {
            System.out.println("Nenhum subconjunto com soma zero encontrado.");
        }
    }

    /**
     * Encontra um subconjunto cuja soma seja zero.
     * 
     * @param conjunto Array de inteiros
     * @return Lista com o subconjunto cuja soma seja zero ou lista vazia se não
     *         existir.
     */
    public static List<Integer> encontrarSubconjuntoSomaZero(int[] conjunto) {
        List<Integer> subconjunto = new ArrayList<>();
        if (backtrack(conjunto, 0, subconjunto, 0)) {
            return subconjunto;
        }
        return new ArrayList<>(); // Nenhum subconjunto encontrado
    }

    /**
     * Método recursivo de backtracking para encontrar um subconjunto com soma zero.
     * 
     * @param conjunto    Array de inteiros
     * @param index       Índice atual no array
     * @param subconjunto Subconjunto sendo construído
     * @param soma        Soma acumulada
     * @return true se encontrou um subconjunto, false caso contrário.
     */
    private static boolean backtrack(int[] conjunto, int index, List<Integer> subconjunto, int soma) {
        if (soma == 0 && !subconjunto.isEmpty()) {
            return true; // Subconjunto com soma zero encontrado
        }
        if (index >= conjunto.length) {
            return false; // Não há mais elementos para processar
        }

        // Inclui o elemento atual no subconjunto
        subconjunto.add(conjunto[index]);
        if (backtrack(conjunto, index + 1, subconjunto, soma + conjunto[index])) {
            return true; // Caminho válido encontrado
        }

        // Exclui o elemento atual e tenta o próximo
        subconjunto.remove(subconjunto.size() - 1);
        return backtrack(conjunto, index + 1, subconjunto, soma);
    }
}
