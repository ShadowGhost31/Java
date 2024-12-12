package com.education.ztu;

import com.education.ztu.game.Schoolar;
import com.education.ztu.game.Team;

public class Main {
    public static void main(String[] args) {

        Schoolar schoolar1 = new Schoolar("Іван", 14);
        Schoolar schoolar2 = new Schoolar("Оля", 13);


        Team<Schoolar> schoolarTeam = new Team<>("Команда школярів");
        schoolarTeam.addPlayer(schoolar1);
        schoolarTeam.addPlayer(schoolar2);

        System.out.println("\n--- Оригінальна команда ---");
        System.out.println(schoolarTeam);


        Team<Schoolar> clonedTeam = new Team<>(schoolarTeam);


        System.out.println("\n--- Перевірка hashCode та equals ---");
        System.out.println("schoolar1.equals(schoolar2): " + schoolar1.equals(schoolar2)); // має бути false
        System.out.println("schoolar1.hashCode(): " + schoolar1.hashCode());
        System.out.println("schoolar2.hashCode(): " + schoolar2.hashCode());


        schoolar1.setName("Тарас");
        schoolar1.setAge(15);

        System.out.println("\n--- Оригінальна команда після змін ---");
        System.out.println(schoolarTeam);

        System.out.println("\n--- Клонована команда (глибоке копіювання) ---");
        System.out.println(clonedTeam);
    }
}