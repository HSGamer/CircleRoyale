package me.hsgamer.fighter;

import me.hsgamer.action.Action;
import me.hsgamer.action.Fight;
import me.hsgamer.action.HealPool;
import me.hsgamer.utils.ThreadUtil;

import java.util.List;
import java.util.Random;

public class Bot extends Fighter {
    private final Random random = new Random();
    private final HealPool healPool = new HealPool(this);

    public Bot(String name) {
        super(name);
    }

    @Override
    public Action doAction(List<Fighter> fighters) {
        ThreadUtil.delay(3000);

        if (healPool.isAvailable() && getHealth() < 5 && Math.random() < 0.5) {
            return healPool;
        }
        List<Fighter> enemies = getEnemies(fighters);
        int choose = random.nextInt(enemies.size());
        return new Fight(this, enemies.get(choose));
    }
}
