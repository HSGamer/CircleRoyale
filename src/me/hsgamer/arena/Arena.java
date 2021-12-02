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
        while (!isEnded()) {
            Collections.shuffle(fighters);
            for (Fighter fighter : fighters) {
                if (!fighter.isAlive()) continue;
                System.out.println("============================================");
                System.out.println(fighter.getName() + " is fighting");

                List<Fighter> enemies = getEnemies(fighter);
                Fighter enemy = fighter.choose(enemies);

                System.out.println(fighter.getName() + " chose " + enemy.getName() + " as an enemy to attack");
                enemy.damage(random.nextInt(3) + 1);
                System.out.println(enemy.getName() + " took damage. Current Health: " + enemy.getHealth());
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
