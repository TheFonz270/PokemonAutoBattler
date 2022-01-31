package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private List<Pokemon> pokemons;

    private int pokedollars;

    public Trainer(int pokedollars){
        this.pokedollars = pokedollars;
        this.pokemons = new ArrayList<Pokemon>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
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
}
