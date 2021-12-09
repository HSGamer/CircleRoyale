package me.hsgamer.fighter;

import me.hsgamer.action.Action;
import me.hsgamer.action.Fight;

import java.util.Comparator;
import java.util.List;

public class Bot extends Fighter {
    public Bot(String name) {
        super(name);
    }

    @Override
    public Action doAction(List<Fighter> fighters) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        Fighter choose;
        if (Math.random() < 0.8) {
            choose = getWeakest(fighters);
            if (choose == this) {
                return () -> this.heal(2);
            }
        } else {
            choose = getStrongest(getEnemies(fighters));
        }

        return new Fight(this, choose);
    }

    private Fighter getWeakest(List<Fighter> enemies) {
        return enemies.stream().min(Comparator.comparingInt(Fighter::getHealth)).orElse(null);
    }

    private Fighter getStrongest(List<Fighter> enemies) {
        return enemies.stream().max(Comparator.comparingInt(Fighter::getHealth)).orElse(null);
    }
}
