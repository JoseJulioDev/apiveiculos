package com.jose.julio.apiveiculos.algoritmos.exercicio3;

import java.util.Scanner;

public class Fatorial {

    private static long calcular(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * calcular(num - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int num = scanner.nextInt();
        scanner.close();

        long result = calcular(num);
        System.out.println("O fatorial de " + num + " é: " + result);
    }
}
