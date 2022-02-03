package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;

public class RunTracker {

    private int wins;

    private int losses;

    private Pokedex rundex;

    private int pokemonCaught;


    public RunTracker(int wins, int losses, Pokedex rundex, int pokemonCaught) {
        this.wins = wins;
        this.losses = losses;
        this.rundex = rundex;
        this.pokemonCaught = pokemonCaught;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void addWin(int win){
        this.wins +=1;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void addLoss(){
        this.losses += 1;
    }

    public Pokedex getRundex() {
        return rundex;
    }

    public void setRundex(Pokedex rundex) {
        this.rundex = rundex;
    }

    public void catchPokemon(Pokemon pokemon){
        PokedexEntry newRundexEntry = new PokedexEntry(pokemon.getPokemonId(), true);
        this.rundex.addPokedexEntry(newRundexEntry);
        increasePokemonCaught();
    }

    private void increasePokemonCaught() {
        pokemonCaught += 1;
    }

    public int getPokemonCaught() {
        return pokemonCaught;
    }

    public void setPokemonCaught(int pokemonCaught) {
        this.pokemonCaught = pokemonCaught;
    }

    public ArrayList<PokedexEntry> getRundexArray() {
        return rundex.getPokedex();
    }
}
