package com.education.ztu.game;

import java.util.Comparator;

public class ParticipantComparators {

    public static Comparator<Participant> byAge() {
        return Comparator.comparingInt(Participant::getAge);
    }


    public static Comparator<Participant> byNameThenAge() {
        return Comparator.comparing(Participant::getName)
                .thenComparingInt(Participant::getAge);
    }
}