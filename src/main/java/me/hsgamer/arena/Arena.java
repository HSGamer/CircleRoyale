package me.hsgamer.arena;

import me.hsgamer.action.Action;
import me.hsgamer.fighter.Fighter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arena {
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
                List<Fighter> enemies = getAliveFighters();
                Action action = fighter.doAction(enemies);
                action.execute();
                System.out.println("============================================");
            }
        }
    }

    protected final List<Fighter> getAliveFighters() {
        List<Fighter> enemies = new ArrayList<>(fighters);
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
