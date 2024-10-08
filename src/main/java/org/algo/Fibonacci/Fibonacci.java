package org.algo.Fibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getFibonacci(10));
    }

    public static int getFibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        int aux = 0;
        int n1 = 0;
        int n2 = 1;
        for(int i = 1; i < n; i++) {
            aux = n1 + n2;
            n1 = n2;
            n2 = aux;
        }
        return aux;
    }
}
