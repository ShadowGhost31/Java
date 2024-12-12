package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Participant> {
    private String name;
    private List<T> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }


    public Team(Team<T> original) {
        this.name = original.name;
        this.players = new ArrayList<>();
        for (T player : original.players) {
            this.players.add((T) player.clone());
        }
    }


    public void addPlayer(T player) {
        players.add(player);
    }


    public void playMatchWith(Team<T> opponent) {
        System.out.println("Матч між командами " + this.name + " та " + opponent.getName() + "!");
        double thisTeamScore = Math.random() * 10;
        double opponentTeamScore = Math.random() * 10;

        if (thisTeamScore > opponentTeamScore) {
            System.out.println("Перемогла команда: " + this.name + " з рахунком " + (int)thisTeamScore + ":" + (int)opponentTeamScore);
        } else if (thisTeamScore < opponentTeamScore) {
            System.out.println("Перемогла команда: " + opponent.getName() + " з рахунком " + (int)opponentTeamScore + ":" + (int)thisTeamScore);
        } else {
            System.out.println("Матч між командами " + this.name + " та " + opponent.getName() + " закінчився нічиєю: " + (int)thisTeamScore + ":" + (int)opponentTeamScore);
        }
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Team{name='" + name + "', players=" + players + '}';
    }
}