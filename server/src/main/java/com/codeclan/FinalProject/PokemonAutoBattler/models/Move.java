package com.codeclan.FinalProject.PokemonAutoBattler.models;

public class Move {

    private String name;
    private Types type;
    private DamageType damageType;
    private int damage;

    public Move(String name, Types type, DamageType damageType, int damage) {
        this.name = name;
        this.type = type;
        this.damageType = damageType;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
