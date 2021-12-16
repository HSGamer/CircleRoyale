package me.hsgamer;

import me.hsgamer.arena.Arena;
import me.hsgamer.fighter.Fighter;
import me.hsgamer.utils.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Fighter> fighters = new ArrayList<>();

        int fighterCount = InputUtil.getInputInteger(scanner, "How many fighters do you want to play with? ", 0, 10);
        for (int i = 0; i < fighterCount; i++) {
            // Get the name of the fighter
            String name = InputUtil.getInputString(scanner, "Name for fighter " + (i + 1) + ": ");

            // Print the available fighters
            System.out.println("Available Fighters:");
            FighterType[] fighterTypes = FighterType.values();
            for (int j = 0; j < fighterTypes.length; j++) {
                System.out.println((j + 1) + ": " + fighterTypes[j].name());
            }

            // Choose the fighter type
            int fighterType = InputUtil.getInputInteger(scanner, "Fighter type for " + name + ": ", 1, fighterTypes.length);
            FighterType type = fighterTypes[fighterType - 1];
            Fighter fighter = type.getFighter(name);

            // Add the fighter to the list
            fighters.add(fighter);
        }

        Arena arena = new Arena(fighters);
        arena.fight();

        Fighter winner = arena.getWinner();
        if (winner != null) {
            System.out.println("Winner: " + winner.getName());
        } else {
            System.out.println("Draw");
        }
    }
}
