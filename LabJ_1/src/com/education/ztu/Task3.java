package com.education.ztu;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Тест :");
        Task3.callMainWithArgs(new String[]{"2", "3", "5", "8"});
    }


    private static void callMainWithArgs(String[] args) {
        if (args.length > 0) {
            String result = String.join(" ", args);

            System.out.println(result);
        } else {
            System.out.println("Аргументів Нуль");
        }
    }
}