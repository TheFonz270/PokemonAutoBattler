package com.codeclan.FinalProject.PokemonAutoBattler.models;

public enum StarLevel {
    ONE_STAR(17),
    TWO_STARS(34),
    THREE_STARS(50);

    public final int level;

     StarLevel(int level){
        this.level = level;
    }
}
