package me.hsgamer.fighter;

import java.util.Comparator;
import java.util.List;

public class Bot extends Fighter {
    public Bot(String name) {
        super(name);
    }

    @Override
    public Fighter choose(List<Fighter> enemies) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        if (Math.random() < 0.8) {
            return getWeakest(enemies);
        } else {
            return getStrongest(enemies);
        }
    }

    private Fighter getWeakest(List<Fighter> enemies) {
        return enemies.stream().min(Comparator.comparingInt(Fighter::getHealth)).orElse(null);
    }

    private Fighter getStrongest(List<Fighter> enemies) {
        return enemies.stream().max(Comparator.comparingInt(Fighter::getHealth)).orElse(null);
    }
}
