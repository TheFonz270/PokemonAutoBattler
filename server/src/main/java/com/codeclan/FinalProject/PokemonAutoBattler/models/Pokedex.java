package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;

public class Pokedex {
    private ArrayList<PokedexEntry> pokedex;

    public Pokedex() {
        this.pokedex = new ArrayList<PokedexEntry>();
    }

    public ArrayList<PokedexEntry> getPokedex() {
        return pokedex;
    }

    public void setPokedex(ArrayList<PokedexEntry> pokedex) {
        this.pokedex = pokedex;
    }

    public PokedexEntry findById(int id){
        for (PokedexEntry oldPokedexEntry : pokedex){
            if (oldPokedexEntry.getPokemonId() == id){
                return oldPokedexEntry;
            }
        }
        return null;
    }

    public void addPokedexEntry(PokedexEntry newPokedexEntry) {
            pokedex.add(newPokedexEntry);
    }

    private void updateDexEntry(PokedexEntry oldPokedexEntry, PokedexEntry newPokedexEntry) {
        oldPokedexEntry.addToAttacksRecieved(newPokedexEntry.getAttacksReceived());
        oldPokedexEntry.addToAttacksUsed(newPokedexEntry.getAttacksUsed());
        oldPokedexEntry.addToDamageDealt(newPokedexEntry.getDamageDealt());
        oldPokedexEntry.addToDamageTaken(newPokedexEntry.getDamageTaken());
        oldPokedexEntry.addToOpponentsFainted(newPokedexEntry.getOpponentsFainted());
    }

    public boolean checkDexDuplicate(PokedexEntry newDexEntry) {
        int newId = newDexEntry.getPokemonId();
        for (PokedexEntry oldPokedexEntry : pokedex) {
            if (newId == oldPokedexEntry.getPokemonId()) {
                return true;
            }
        } return false;
    }

    public void addOrUpdateDex(PokedexEntry newDexEntry){

        checkDexDuplicate(newDexEntry);

        if (checkDexDuplicate(newDexEntry) == false){
            addPokedexEntry(newDexEntry);
        } else {
            PokedexEntry oldDexEntry = findById(newDexEntry.getPokemonId());
            updateDexEntry(oldDexEntry, newDexEntry);
        }
    }

    public int getPokedexSize() {
        return pokedex.size();
    }
//
//    public PokedexEntry getPokedexEntryById(int pokedexID){
//        for (PokedexEntry pokedexEntry :pokedex){
//
//        }
//    }
}



