package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.HashMap;

public class BaseStats {
    HashMap<String, Integer> baseStats = new HashMap<String, Integer>();

    public HashMap addStats(int hp, int atk, int def, int spatk, int spdef, int speed){
        baseStats.put("HP", hp);
        baseStats.put("Atk", atk);
        baseStats.put("Def", def);
        baseStats.put("SpAtk", spatk);
        baseStats.put("SpDef", spdef);
        baseStats.put("Speed", speed);
        return  baseStats;
    }
}
