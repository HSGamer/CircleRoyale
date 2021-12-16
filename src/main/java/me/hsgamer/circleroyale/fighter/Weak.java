package me.hsgamer.circleroyale.fighter;

import me.hsgamer.circleroyale.action.Action;

import java.util.List;

public class Weak extends Fighter {
    public Weak(String name) {
        super(name);
    }

    @Override
    public Action doAction(List<Fighter> fighters) {
        return () -> System.out.println("Too weak to fight");
    }
}
