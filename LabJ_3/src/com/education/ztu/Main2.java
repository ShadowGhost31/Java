package com.education.ztu;

import com.education.ztu.game.ParticipantComparators;
import com.education.ztu.game.Schoolar;
import com.education.ztu.game.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        Schoolar schoolar1 = new Schoolar("Марія", 15);
        Schoolar schoolar2 = new Schoolar("Рома", 14);
        Schoolar schoolar3 = new Schoolar("Оля", 16);
        Schoolar schoolar4 = new Schoolar("Андрій", 13);


        List<Schoolar> participants = new ArrayList<>();
        participants.add(schoolar1);
        participants.add(schoolar2);
        participants.add(schoolar3);
        participants.add(schoolar4);

        System.out.println("\n--- Список учасників (оригінальний порядок) ---");
        participants.forEach(System.out::println);


        Collections.sort(participants);
        System.out.println("\n--- Сортування за ім'ям (Comparable) ---");
        participants.forEach(System.out::println);


        participants.sort(ParticipantComparators.byAge());
        System.out.println("\n--- Сортування за віком (Comparator) ---");
        participants.forEach(System.out::println);


        participants.sort(ParticipantComparators.byNameThenAge());
        System.out.println("\n--- Сортування за ім'ям, а потім за віком (PriorityComparator) ---");
        participants.forEach(System.out::println);

        Team<Schoolar> schoolarTeam = new Team<>("Команда школярів");
        schoolarTeam.addPlayer(schoolar1);
        schoolarTeam.addPlayer(schoolar3);

        Team<Schoolar> schoolarTeam2 = new Team<>("Другий шанс");
        schoolarTeam2.addPlayer(schoolar2);
        schoolarTeam2.addPlayer(schoolar4);

        System.out.println("\n--- Гра між командами ---");
        schoolarTeam.playMatchWith(schoolarTeam2);
    }
}
