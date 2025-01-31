package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final int[] arrayToSort = randomArray(10);
        //System.out.println(Arrays.toString(selectionSortArray(arrayToSort)));
        String sortedArraysAsString = Arrays.toString(selectionSortArray(arrayToSort.clone()));
        String sortedArraysAsString2 = Arrays.toString(insertionSortArray(arrayToSort.clone()));

        System.out.printf("Array sorted by selection sort : %s\n", sortedArraysAsString);
        System.out.printf("Array sorted by insertion sort %s\n", sortedArraysAsString2);
    }

    public static int[] randomArray(int size) {
        int[] randomArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(0, 50);
        }
        return randomArray;
    }

    public static int[] selectionSortArray(int[] unsortedArray) {
        long startingTime = System.currentTimeMillis();
        int size = unsortedArray.length;

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            for (int x = i + 1; x < size; x++) {
                if (unsortedArray[x] < unsortedArray[minIndex]) {
                    minIndex = x;
                }
            }

            int temp = unsortedArray[i];
            unsortedArray[i] = unsortedArray[minIndex];
            unsortedArray[minIndex] = temp;
        }
        long endingTime = System.currentTimeMillis();
        System.out.printf("Time taken to sort: %s milliseconds\n", endingTime - startingTime);

        return unsortedArray;
    }

    public static int[] insertionSortArray(int[] unsortedArray) {
        long startingTime = System.currentTimeMillis();
        int i = 1;
        while (i < unsortedArray.length) {
            int j = i;
            while (j > 0 && unsortedArray[j - 1] > unsortedArray[j]) {
                int temp = unsortedArray[j];
                unsortedArray[j] = unsortedArray[j - 1];
                unsortedArray[j - 1] = temp;
                j--;
            }
            i++;
        }

        long endingTime = System.currentTimeMillis();
        System.out.printf("Time taken to sort: %s milliseconds\n", endingTime - startingTime);

        return unsortedArray;
    }
}