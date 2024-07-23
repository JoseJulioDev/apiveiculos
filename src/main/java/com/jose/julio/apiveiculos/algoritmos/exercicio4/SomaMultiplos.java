package com.jose.julio.apiveiculos.algoritmos.exercicio4;

public class SomaMultiplos {

    private static int calcularSoma(int limite) {
        int soma = 0;
        for (int i = 1; i < limite; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                soma += i;
            }
        }
        return soma;
    }

    public static void main(String[] args) {
        int limite = 1000;
        int soma = calcularSoma(limite);
        System.out.println("A soma dos múltiplos de 3 ou 5 abaixo de " + limite + " é: " + soma);
    }
}
