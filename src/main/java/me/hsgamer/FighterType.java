package me.hsgamer;

import me.hsgamer.fighter.Bot;
import me.hsgamer.fighter.Fighter;
import me.hsgamer.fighter.Player;
import me.hsgamer.fighter.Weak;

import java.util.function.Function;

public enum FighterType {
    PLAYER(Player::new), BOT(Bot::new), WEAK(Weak::new);

    private final Function<String, Fighter> fighterFunction;

    FighterType(Function<String, Fighter> fighterFunction) {
        this.fighterFunction = fighterFunction;
    }

    public Fighter getFighter(String name) {
        return fighterFunction.apply(name);
    }
}
