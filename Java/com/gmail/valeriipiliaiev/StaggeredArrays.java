package com.gmail.valeriipiliaiev;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StaggeredArrays {
    public static void main(String[] args) {
        int[][] array = createStaggeredArray();
        System.out.println("Двовимірний ступінчатий масив:");
        printArray(array);

        sortRows(array);
        System.out.println("Парні рядки за зростанням, непарні за спаданням:");
        printArray(array);

        int sum = calculateSum(array);
        System.out.println("Сума всіх елементів масиву: " + sum);

        int[] minElements = findMinElements(array);
        System.out.println("Мінімальні елементи для кожного рядка:");
        printRow(minElements);

        int absoluteMin = findAbsoluteMin(array);
        System.out.println("Мінімальний елемент серед усіх елементів: " + absoluteMin);

        divideByAbsoluteMin(array, absoluteMin);
        System.out.println("Масив після поділу націло на абсолютний мінімум:");
        printArray(array);
    }

    public static int[][] createStaggeredArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість рядків: ");
        int rowCount = scanner.nextInt();
        System.out.print("Введіть максимальну кількість елементів в рядку: ");
        int maxElements = scanner.nextInt();

        Random random = new Random();
        int[][] array = new int[rowCount][];

        for (int i = 0; i < rowCount; i++) {
            int rowLength = random.nextInt(maxElements);
            array[i] = new int[rowLength];
            for (int j = 0; j < rowLength; j++) {
                System.out.print("Введіть значення елементу [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextInt();
            }
        }

        return array;
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            printRow(row);
        }
    }

    public static void printRow(int[] row) {
        for (int element : row) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void sortRows(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                Arrays.sort(array[i]);
            } else {
                bubbleSortDescending(array[i]);
            }
        }
    }

    public static void bubbleSortDescending(int[] row) {
        for (int i = 0; i < row.length - 1; i++) {
            for (int j = 0; j < row.length - 1 - i; j++) {
                if (row[j] < row[j + 1]) {
                    int temp = row[j];
                    row[j] = row[j + 1];
                    row[j + 1] = temp;
                }
            }
        }
    }

    public static int calculateSum(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;
    }

    public static int[] findMinElements(int[][] array) {
        int[] minElements = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int min = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
            minElements[i] = min;
        }
        return minElements;
    }

    public static int findAbsoluteMin(int[][] array) {
        int absoluteMin = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < absoluteMin) {
                    absoluteMin = array[i][j];
                }
            }
        }
        return absoluteMin;
    }

    public static void divideByAbsoluteMin(int[][] array, int absoluteMin) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] /= absoluteMin;
            }
        }
    }
}


