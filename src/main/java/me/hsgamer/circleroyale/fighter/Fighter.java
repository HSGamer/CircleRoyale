package me.hsgamer.circleroyale.fighter;

import me.hsgamer.circleroyale.action.Action;

import java.util.ArrayList;
import java.util.List;

public abstract class Fighter {
    private final String name;
    private int health = 10;

    public Fighter(String name) {
        this.name = name;
    }

    public abstract Action doAction(List<Fighter> fighters);

    protected final List<Fighter> getEnemies(List<Fighter> fighters) {
        List<Fighter> enemies = new ArrayList<>(fighters);
        enemies.remove(this);
        return enemies;
    }

    public void damage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public void heal(int heal) {
        health += heal;
        if (health > 10) health = 10;
    }

    public int getHealth() {
        return health;
    }

    public String displayHealth() {
        return health + (health > 0 ? " " + "♥".repeat(health) : "");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isDead() {
        return health == 0;
    }

    public String getName() {
        return name;
    }
}
