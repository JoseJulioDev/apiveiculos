package com.jose.julio.apiveiculos.algoritmos.exercicio2;

import java.util.Arrays;

public class BubbleSort {

    private static void sort(int[] array) {
        int n = array.length;
        for (int item1 = 0; item1 < n - 1; item1++) {
            for (int item2 = 0; item2 < n - item1 - 1; item2++) {
                if (array[item2] > array[item2 + 1]) {
                    // Troca array[item2] e array[item2 + 1]
                    int temp = array[item2];
                    array[item2] = array[item2 + 1];
                    array[item2 + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }
}
