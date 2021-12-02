package me.hsgamer.fighter;

import java.util.List;

public abstract class Fighter {
    private final String name;
    private int health = 10;

    public Fighter(String name) {
        this.name = name;
    }

    public abstract Fighter choose(List<Fighter> enemies);

    public void damage(int damage) {
        health -= damage;
    }

    public void damage() {
        health--;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}
