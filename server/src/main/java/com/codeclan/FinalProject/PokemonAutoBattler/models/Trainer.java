package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private ArrayList<Pokemon> pokemons;

    private int pokedollars;

    private String avatar;

    public Trainer(int pokedollars, String avatar){
        this.pokedollars = pokedollars;
        this.avatar = avatar;
        this.pokemons = new ArrayList<Pokemon>();
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getPokedollars() {
        return pokedollars;
    }

    public void setPokedollars(int pokedollars) {
        this.pokedollars = pokedollars;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public int minusPokedollars(int dollars) {
        setPokedollars(pokedollars - dollars);
        return pokedollars;
    }

    public int addPokedollars(int dollars) {
        setPokedollars(pokedollars + dollars);
        return pokedollars;
    }

    public int getPokemonsSize(){
        return pokemons.size();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Pokemon getFirstPokemon(){
        return pokemons.get(0);
    }


    public void winRound(){
    }

    public void switchPokemon(){
    }
}
