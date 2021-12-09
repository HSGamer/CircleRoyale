package me.hsgamer.fighter;

import me.hsgamer.action.Action;
import me.hsgamer.action.Fight;
import me.hsgamer.action.Heal;

import java.util.List;
import java.util.Random;

public class Bot extends Fighter {
    private final Random random = new Random();
    private int hpBottles = 3;

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

        if (hpBottles > 0 && getHealth() < 5 && Math.random() < 0.5) {
            hpBottles--;
            return new Heal(this);
        }

        List<Fighter> enemies = getEnemies(fighters);
        int choose = random.nextInt(enemies.size());
        return new Fight(this, enemies.get(choose));
    }
}
