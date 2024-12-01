package org.algo.Backtracking;

public class NQueens {

    public static void main(String[] args) {
        int n = 6; // Define o tamanho do tabuleiro (6x6)
        int[] solucao = resolverNQueens(n); // Resolve o problema das N-Rainhas

        if (solucao != null) {
            exibirTabuleiro(solucao); // Imprime o tabuleiro com a solução
        } else {
            System.out.println("Não foi possível encontrar uma solução.");
        }
    }

    /**
     * Resolve o problema das N-Rainhas.
     * 
     * @param n Tamanho do tabuleiro (N x N)
     * @return Array com as posições das rainhas ou null se não houver solução.
     */
    public static int[] resolverNQueens(int n) {
        int[] posicoes = new int[n]; // Array para armazenar as posições das rainhas
        if (resolver(0, n, posicoes)) {
            return posicoes; // Retorna a solução encontrada
        }
        return null; // Retorna null se não houver solução
    }

    /**
     * Backtracking recursivo para resolver o problema.
     * 
     * @param coluna   Coluna atual sendo processada
     * @param n        Tamanho do tabuleiro
     * @param posicoes Array com as posições das rainhas
     * @return true se uma solução for encontrada, false caso contrário.
     */
    private static boolean resolver(int coluna, int n, int[] posicoes) {
        if (coluna == n) {
            return true; // Solução encontrada
        }

        for (int linha = 0; linha < n; linha++) {
            if (posicaoValida(linha, coluna, posicoes)) {
                posicoes[coluna] = linha; // Coloca a rainha na posição
                if (resolver(coluna + 1, n, posicoes)) {
                    return true; // Solução válida encontrada
                }
                posicoes[coluna] = 0; // Remove a rainha (backtracking)
            }
        }

        return false; // Nenhuma solução foi encontrada para esta coluna
    }

    /**
     * Verifica se é seguro colocar uma rainha na posição dada.
     * 
     * @param linha    Linha onde a rainha será colocada
     * @param coluna   Coluna onde a rainha será colocada
     * @param posicoes Array com as posições das rainhas já colocadas
     * @return true se a posição for válida, false caso contrário.
     */
    private static boolean posicaoValida(int linha, int coluna, int[] posicoes) {
        for (int c = 0; c < coluna; c++) { // Verifica as colunas anteriores
            int outraLinha = posicoes[c]; // Linha onde a rainha foi colocada
            if (outraLinha == linha || Math.abs(outraLinha - linha) == Math.abs(c - coluna)) {
                return false; // Mesma linha ou mesma diagonal
            }
        }
        return true; // Nenhum conflito encontrado
    }

    /**
     * Exibe o tabuleiro com as rainhas.
     * 
     * @param posicoes Array com as posições das rainhas
     */
    private static void exibirTabuleiro(int[] posicoes) {
        int n = posicoes.length;
        for (int linha = 0; linha < n; linha++) {
            for (int coluna = 0; coluna < n; coluna++) {
                if (posicoes[coluna] == linha) {
                    System.out.print("Q "); // Posição da rainha
                } else {
                    System.out.print(". "); // Espaço vazio
                }
            }
            System.out.println();
        }
    }
}