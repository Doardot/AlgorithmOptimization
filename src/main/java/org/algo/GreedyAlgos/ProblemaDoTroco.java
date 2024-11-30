package org.algo.GreedyAlgos;

public class ProblemaDoTroco {
    public static void main(String[] args) {
        int[] moedas = new int[] { 1, 10, 25, 50, 5, 100 };
        moedas = insertSortReverse(moedas);
        int valor = 123;
        System.out.println("\nValor: " + valor);
        int[] resultado = troco(valor, moedas);
        for (int i = 0; i < resultado.length; i++) {
            System.out.println("Moedas de " + moedas[i] + ": " + resultado[i]);
        }
    }

    public static int[] troco(int valor, int[] moedas) {
        int resultado[] = new int[moedas.length];
        for (int i = 0; i < moedas.length; i++) {
            resultado[i] = valor / moedas[i];
            valor = valor % moedas[i];
        }
        return resultado;
    }

    public static int[] insertSortReverse(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] > array[j - 1]) {
                int aux = array[j];
                array[j] = array[j - 1];
                array[j - 1] = aux;
                j--;
            }
        }
        return array;
    }
}
