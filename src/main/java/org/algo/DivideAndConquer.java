package org.algo;

import static java.lang.Math.max;

public class DivideAndConquer {
    public static void main(String[] args) {
        int[] A = { 3, 5, 2, 9, 7 };
        int maxVal = maxValue(A, 0, A.length - 1);
        System.out.println(maxVal);
    }

    // Maior valor de um vetor
    public static int maxValue(int A[], int init, int end) {
        if (end - init <= 1)
            return max(A[init], A[end]);
        else {
            int m = (init + end) / 2;
            int v1 = maxValue(A, init, m);
            int v2 = maxValue(A, m + 1, end);
            return max(v1, v2);
        }
    }
}