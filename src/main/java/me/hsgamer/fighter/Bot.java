package me.hsgamer.fighter;

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
        Fighter weakest = enemies.get(0);
        for (Fighter enemy : enemies) {
            if (enemy.getHealth() < weakest.getHealth()) {
                weakest = enemy;
            }
        }
        return weakest;
    }

    private Fighter getStrongest(List<Fighter> enemies) {
        Fighter strongest = enemies.get(0);
        for (Fighter enemy : enemies) {
            if (enemy.getHealth() > strongest.getHealth()) {
                strongest = enemy;
            }
        }
        return strongest;
    }
}
