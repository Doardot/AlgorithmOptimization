package org.algo.Knapsack;

public class Knapsack {

  // Função para resolver o problema do knapsack usando programação dinâmica
  public static int knapsack(int capacidade, int[] pesos, int[] valores, int n) {
    // Criação da tabela para armazenar os valores máximos
    int[][] tabela = new int[n + 1][capacidade + 1];

    // Itera sobre todos os itens
    for (int i = 0; i <= n; i++) {
      // Itera sobre todas as capacidades possíveis
      for (int w = 0; w <= capacidade; w++) {
        // Linha 0 e coluna 0 são inicializadas como 0 (não há itens ou capacidade)
        if (i == 0 || w == 0) {
          tabela[i][w] = 0;
        }
        // Se o peso do item atual é menor ou igual à capacidade
        else if (pesos[i - 1] <= w) {
          // Calcula o valor máximo: ou pega o item (adicionando seu valor) ou não pega
          tabela[i][w] = Math.max(valores[i - 1] + tabela[i - 1][w - pesos[i - 1]], tabela[i - 1][w]);
        }
        // Caso contrário, mantém o valor máximo anterior
        else {
          tabela[i][w] = tabela[i - 1][w];
        }
      }
    }

    // Printando os itens selecionados
    printItensSelecionados(tabela, pesos, n, capacidade);

    // Retorna o valor máximo que pode ser obtido com a capacidade dada
    return tabela[n][capacidade];
  }

  // Função para printar os itens selecionados
  public static void printItensSelecionados(int[][] tabela, int[] pesos, int n, int capacidade) {
    int res = tabela[n][capacidade];
    int w = capacidade;

    System.out.println("Itens selecionados:");

    for (int i = n; i > 0 && res > 0; i--) {
      // Verifica se o item foi incluído comparando a tabela atual com a anterior
      if (res != tabela[i - 1][w]) {
        System.out.println("Item " + i + " (Peso: " + pesos[i - 1] + ")");
        // Subtrai o valor do item da solução total
        res -= tabela[i][w] - tabela[i - 1][w - pesos[i - 1]];
        // Atualiza o peso da mochila
        w -= pesos[i - 1];
      }
    }
  }

  public static void main(String[] args) {
    // Teste 1
    int[] pesos1 = { 23, 31, 29, 44, 53, 38, 63, 85, 89, 82 };
    int[] valores1 = { 92, 57, 49, 68, 60, 43, 67, 84, 87, 72 };
    int capacidade1 = 165;
    int n1 = valores1.length;

    System.out.println("Teste 1: ");
    int valorMax1 = knapsack(capacidade1, pesos1, valores1, n1);
    System.out.println("Valor máximo obtido: " + valorMax1);

    // Teste 2
    int[] pesos2 = { 56, 59, 80, 64, 75, 17 };
    int[] valores2 = { 50, 50, 64, 46, 50, 5 };
    int capacidade2 = 190;
    int n2 = valores2.length;

    System.out.println("\nTeste 2: ");
    int valorMax2 = knapsack(capacidade2, pesos2, valores2, n2);
    System.out.println("Valor máximo obtido: " + valorMax2);
  }
}