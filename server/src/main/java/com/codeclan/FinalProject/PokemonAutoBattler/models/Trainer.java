package com.codeclan.FinalProject.PokemonAutoBattler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"trainer"})
//    @JsonBackReference
    @OneToMany(mappedBy = "trainer")
//
    private List<Pokemon> pokemons;

    @Column(name = "pokedollars")
    private int pokedollars;

    @Column(name = "avatar")
    private String avatar;

    public Trainer(int pokedollars, String avatar){
        this.pokedollars = pokedollars;
        this.avatar = avatar;
        this.pokemons = new ArrayList<Pokemon>();
    }

    public Trainer() {
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

    @JsonIgnore
    public int getPokemonsSize(){
        return pokemons.size();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @JsonIgnore
    public Pokemon getFirstPokemon(){
        return pokemons.get(0);
    }


    public void winRound(){
    }

    public void switchPokemon(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
