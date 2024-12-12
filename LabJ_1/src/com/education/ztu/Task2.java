package com.education.ztu;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введіть перше число: ");
        int firstNumber = scanner.nextInt();


        System.out.print("Введіть друге число: ");
        int secondNumber = scanner.nextInt();


        int sum = firstNumber + secondNumber;


        System.out.println("Сума чисел: " + sum);

        scanner.close();
    }
}