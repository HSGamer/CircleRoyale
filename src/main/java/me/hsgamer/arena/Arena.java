package me.hsgamer.arena;

import me.hsgamer.action.Action;
import me.hsgamer.fighter.Fighter;
import me.hsgamer.utils.ThreadUtil;

import java.util.*;

public class Arena {
    private final List<Fighter> fighters;
    private final Set<Fighter> deadFighters = new HashSet<>();

    public Arena(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    public void fight() {
        int round = 0;
        while (!isEnded()) {
            System.out.println("Round #" + ++round);
            Collections.shuffle(fighters);
            for (int i = 0; i < fighters.size(); i++) {
                Fighter fighter = fighters.get(i);
                System.out.println((i + 1) + "/ " + fighter.getName() + " " + (fighter.isAlive() ? fighter.displayHealth() : "dead"));
            }
            ThreadUtil.delay(2000);
            for (Fighter fighter : fighters) {
                if (!fighter.isAlive()) continue;
                System.out.println("============================================");
                System.out.println(fighter.getName() + " is fighting");
                System.out.println("Current health: " + fighter.displayHealth());
                List<Fighter> enemies = getAliveFighters();
                Action action = fighter.doAction(enemies);
                action.execute();
                broadcastDead();
                System.out.println("============================================");
                ThreadUtil.delay(500);
            }
        }
    }

    private void broadcastDead() {
        List<Fighter> alive = getAliveFighters();
        for (Fighter fighter : fighters) {
            if (!alive.contains(fighter) && deadFighters.add(fighter)) {
                System.out.println(fighter.getName() + " is dead");
            }
        }
    }

    private List<Fighter> getAliveFighters() {
        List<Fighter> enemies = new ArrayList<>(fighters);
        enemies.removeIf(Fighter::isDead);
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
