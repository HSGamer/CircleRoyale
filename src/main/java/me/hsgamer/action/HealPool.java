package me.hsgamer.action;

import me.hsgamer.fighter.Fighter;

public class HealPool extends Heal {
    private int hpBottles = 3;

    public HealPool(Fighter fighter) {
        super(fighter);
    }

    @Override
    public void execute() {
        hpBottles--;
        super.execute();
        System.out.println(getFighter().getName() + " has " + hpBottles + " hp bottles left");
    }

    public int getHpBottles() {
        return hpBottles;
    }

    public boolean isAvailable() {
        return hpBottles != 0;
    }
}
