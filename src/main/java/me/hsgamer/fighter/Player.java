package me.hsgamer.fighter;

import me.hsgamer.InputUtil;
import me.hsgamer.action.Action;
import me.hsgamer.action.Fight;

import java.util.List;
import java.util.Scanner;

public class Player extends Fighter {
    private final Scanner scanner;

    public Player(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public Action doAction(List<Fighter> fighters) {
        List<Fighter> enemies = getEnemies(fighters);
        System.out.println("Enemies: ");
        for (int i = 0; i < enemies.size(); i++) {
            Fighter enemy = enemies.get(i);
            System.out.println(i + ": " + enemy.getName() + " - " + enemy.displayHealth());
        }
        int choose = InputUtil.getInputInteger(scanner, "Choose an enemy: ", 0, enemies.size() - 1);
        Fighter enemy = enemies.get(choose);
        return new Fight(this, enemy);
    }
}
