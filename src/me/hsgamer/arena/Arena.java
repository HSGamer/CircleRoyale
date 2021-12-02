package me.hsgamer.arena;

import me.hsgamer.fighter.Fighter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Arena {
    private final Random random = new Random();
    private final List<Fighter> fighters;

    public Arena(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    public void fight() {
        int round = 0;
        while (!isEnded()) {
            System.out.println("Round #" + ++round);
            Collections.shuffle(fighters);
            for (Fighter fighter : fighters) {
                if (!fighter.isAlive()) continue;
                System.out.println("============================================");
                System.out.println(fighter.getName() + " is fighting");
                System.out.println("Current health: " + fighter.displayHealth());
                List<Fighter> enemies = getEnemies(fighter);
                Fighter theChosenOne = fighter.choose(enemies);

                System.out.println(fighter.getName() + " chose " + theChosenOne.getName() + " as an enemy to attack");
                int damage = 3;
                if (random.nextDouble() <= 0.1) {
                    System.out.println("CRITICAL");
                    theChosenOne.damage(damage);
                } else {
                    damage = random.nextInt(2) + 1;
                    if (random.nextDouble() <= 0.4) {
                        if (random.nextDouble() <= 0.4) {
                            damage = 0;
                            System.out.println("MISS");
                        } else {
                            System.out.println("BLOCKED");
                            theChosenOne.damage(damage /= 2);
                        }
                    } else {
                        System.out.println("HIT");
                        theChosenOne.damage(damage);
                    }
                }
                System.out.println(theChosenOne.getName() + " took " + damage + " damage");
                System.out.println("Current health: " + theChosenOne.displayHealth());
                System.out.println("============================================");
            }
        }
    }

    private List<Fighter> getEnemies(Fighter fighter) {
        List<Fighter> enemies = new ArrayList<>(fighters);
        enemies.remove(fighter);
        enemies.removeIf(enemy -> !enemy.isAlive());
        return enemies;
    }

    private boolean isEnded() {
        int alive = 0;
        for (Fighter fighter : fighters) {
            if (fighter.isAlive()) {
                alive++;
            }
        }
        return alive <= 1;
    }

    public Fighter getWinner() {
        for (Fighter fighter : fighters) {
            if (fighter.isAlive()) {
                return fighter;
            }
        }
        return null;
    }
}
