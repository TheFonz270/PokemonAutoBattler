package com.codeclan.FinalProject.PokemonAutoBattler.models;

public class StatTracker {

    private int wins;

    private int losses;

    private Pokedex pokedex;

    private int pokemonCaught;

    public StatTracker(int wins, int losses, Pokedex pokedex, int pokemonCaught) {
        this.wins = wins;
        this.losses = losses;
        this.pokedex = pokedex;
        this.pokemonCaught = pokemonCaught;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    public int getPokemonCaught() {
        return pokemonCaught;
    }

    public void setPokemonCaught(int pokemonCaught) {
        this.pokemonCaught = pokemonCaught;
    }

    public int increaseWins() {
        wins += 1;
        return wins;
    }

    public int increaseLosses() {
        losses += 1;
        return losses;
    }

//    public int getPokedexSize() {
//        return pokedex.size();
//    }
}
