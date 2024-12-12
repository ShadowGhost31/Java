package com.education.ztu;

import java.util.Scanner;

public class Task5 {

    public static int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введіть ціле позитивне число: ");
            int number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Число має бути додатним!");
                return;
            }

            int sum = calculateSumOfDigits(number);


            System.out.println("Сума цифр числа " + number + ": " + sum);
        } catch (Exception e) {
            System.out.println("Помилка введення! Будь ласка, введіть ціле позитивне число.");
        } finally {

            scanner.close();
        }
    }
}