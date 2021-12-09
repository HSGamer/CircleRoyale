package me.hsgamer.action;

import me.hsgamer.fighter.Fighter;

import java.util.Random;

public class Fight implements Action {
    private static final Random random = new Random();
    private final Fighter fighter;
    private final Fighter target;

    public Fight(Fighter fighter, Fighter target) {
        this.fighter = fighter;
        this.target = target;
    }

    @Override
    public void execute() {
        System.out.println(fighter.getName() + " chose " + target.getName() + " as an enemy to attack");
        int damage = 3;
        if (random.nextDouble() <= 0.1) {
            System.out.println("CRITICAL");
            target.damage(damage);
        } else {
            damage = random.nextInt(2) + 1;
            if (random.nextDouble() <= 0.4) {
                if (random.nextDouble() <= 0.4) {
                    damage = 0;
                    System.out.println("MISS");
                } else {
                    System.out.println("BLOCKED");
                    damage /= 2;
                    target.damage(damage);
                }
            } else {
                System.out.println("HIT");
                target.damage(damage);
            }
        }
        System.out.println(target.getName() + " took " + damage + " damage");
        System.out.println(target.getName() + " has " + target.displayHealth() + " health left");
    }
}
