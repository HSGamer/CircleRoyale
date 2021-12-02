package me.hsgamer;

import me.hsgamer.arena.Arena;
import me.hsgamer.fighter.Bot;
import me.hsgamer.fighter.Fighter;
import me.hsgamer.fighter.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int players = InputUtil.getInputInteger(scanner, "How many players? ", 0, 10);
        int bots = InputUtil.getInputInteger(scanner, "How many bots? ", 0, 10);
        List<Fighter> fighters = new ArrayList<>();
        for (int i = 0; i < players; i++) {
            String name = InputUtil.getInputString(scanner, "Player " + (i + 1) + " name: ");
            fighters.add(new Player(name));
        }
        for (int i = 0; i < bots; i++) {
            String name = InputUtil.getInputString(scanner, "Bot " + (i + 1) + " name: ");
            fighters.add(new Bot(name));
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
