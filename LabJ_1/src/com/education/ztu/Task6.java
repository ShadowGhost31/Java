package com.education.ztu;

import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введіть кількість елементів масиву (n): ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Кількість елементів повинна бути додатною!");
                return;
            }

            int[] fibonacciArray = generateFibonacciArray(n);

            int[] reverseFibonacciArray = reverseArray(fibonacciArray);


            System.out.println("Масив чисел Фібоначчі:");
            printArray(fibonacciArray);


            System.out.println("Масив чисел Фібоначчі у зворотному порядку:");
            printArray(reverseFibonacciArray);

        } catch (Exception e) {
            System.out.println("Помилка введення! Будь ласка, введіть ціле додатне число.");
        } finally {
            scanner.close();
        }
    }


    public static int[] generateFibonacciArray(int n) {
        int[] fibonacciArray = new int[n];
        if (n >= 1) fibonacciArray[0] = 1;
        if (n >= 2) fibonacciArray[1] = 1;


        for (int i = 2; i < n; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        return fibonacciArray;
    }


    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }


    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
