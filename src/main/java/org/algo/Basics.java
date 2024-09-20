package org.algo;

public class Basics
{
    public static void main( String[] args )
    {
//        System.out.println(multiplicaDoisNum(6, 4));
//        System.out.println(somaDoisNum(6, 4));
        System.out.println(somaFracoes(6));
    }

    // Multiplicação de dois números naturais, através de somas sucessivas (Ex.: 6 ∗ 4 = 4 + 4 + 4 + 4 + 4 + 4).
    public static long multiplicaDoisNum(long vezes, long nro){
        if(vezes<0) {
            throw new IllegalArgumentException("Numero negativo");
        }
        else if (vezes == 0) {
            return 0;
        }
        else if (vezes == 1) {
            return nro;
        }
        else {
            return multiplicaDoisNum(vezes - 1, nro) + nro;
        }
    }

    // Soma de dois números naturais, através de incrementos sucessivos (Ex.: 3 + 2 = + + (+ + + 1)).
    public static long somaDoisNum(long n1, long n2){
        if ((n1<0) || (n2<0)) {
            throw new IllegalArgumentException("Numero negativo");
        }
        else if ((n1==0) && (n2==0)) {
            return (0);
        }
        else if (n1 ==0) {
            return (somaDoisNum(n1, n2-1) + 1);         // simula a soma de n2 por incrementos sucessivos
        }
        else if (n2 ==0) {
            return (somaDoisNum(n1-1, n2) + 1);         // simula a soma de n1 por incrementos sucessivos
        }
        else {
            return (somaDoisNum(n1-1, n2-1) + 1 + 1);   // Isso simula a soma de ambos os números,
                                                        // retirando incrementos sucessivos de ambos.
        }
    }

    // Cálculo de 1 + 1/2 + 1/3 + 1/4 + ... + 1/N.
    public static double somaFracoes(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        else if (n ==1) {
            return (1);
        }
        else {
            return(somaFracoes(n-1) + 1/((double)n));
        }
    }
}
