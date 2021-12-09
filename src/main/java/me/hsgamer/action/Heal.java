package me.hsgamer.action;

import me.hsgamer.fighter.Fighter;

public class Heal implements Action {
    private final Fighter fighter;

    public Heal(Fighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public void execute() {
        fighter.heal(2);
        System.out.println(fighter.getName() + " heal 2 hearts");
    }

    public Fighter getFighter() {
        return fighter;
    }
}
