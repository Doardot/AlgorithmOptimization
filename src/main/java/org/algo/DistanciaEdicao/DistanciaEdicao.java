package org.algo.DistanciaEdicao;

public class DistanciaEdicao {

    // Função para calcular a distância de edição entre duas strings
    public static int calcularDistancia(String A, String B) {
        int m = A.length(); // Tamanho da string A
        int n = B.length(); // Tamanho da string B

        // Matriz para armazenar os custos das operações
        int[][] matriz = new int[m + 1][n + 1];

        // Inicializa a primeira coluna (inserções necessárias)
        for (int i = 1; i <= m; i++) {
            matriz[i][0] = i; // Custo de inserção
        }

        // Inicializa a primeira linha (remoções necessárias)
        for (int j = 1; j <= n; j++) {
            matriz[0][j] = j; // Custo de remoção
        }

        // Preenche a matriz com os custos das operações
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int custoExtra;

                // Se os caracteres forem iguais, custo de match é 0
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    custoExtra = 0;
                } else {
                    // Caso contrário, há um custo de substituição
                    custoExtra = 1;
                }

                // Calcula o valor mínimo entre as operações: remoção, inserção e substituição
                matriz[i][j] = Math.min(
                        matriz[i - 1][j] + 1, // Remoção
                        Math.min(
                                matriz[i][j - 1] + 1, // Inserção
                                matriz[i - 1][j - 1] + custoExtra // Substituição
                        ));
            }
        }

        // Retorna a distância de edição (último valor da matriz)
        return matriz[m][n];
    }

    public static void main(String[] args) {
        String A = "casa";
        String B = "caso";

        int distancia = calcularDistancia(A, B);
        System.out.println("A distância de edição entre '" + A + "' e '" + B + "' é: " + distancia);
    }
}
