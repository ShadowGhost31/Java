package com.education.ztu;

import java.util.Scanner;

public class Task4 {

    public static int calculateCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Введіть перше ціле додатне число: ");
            int number1 = scanner.nextInt();
            if (number1 <= 0) {
                System.out.println("Число має бути додатним!");
                return;
            }


            System.out.print("Введіть друге ціле додатне число: ");
            int number2 = scanner.nextInt();
            if (number2 <= 0) {
                System.out.println("Число має бути додатним!");
                return;
            }


            int cd = calculateCD(number1, number2);


            System.out.println("Найбільший спільний дільник (НСД) чисел " + number1 + " і " + number2 + ": " + cd);
        } catch (Exception e) {
            System.out.println("Помилка введення! Будь ласка, введіть цілі додатні числа.");
        } finally {

            scanner.close();
        }
    }
}