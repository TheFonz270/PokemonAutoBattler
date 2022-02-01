package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;

public class MaintenancePhase {

    private ArrayList<Trainer> trainers;

    public MaintenancePhase(){
        this.trainers = new ArrayList<>();
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public int getTrainersSize() {
        return trainers.size();
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void replacePokemon(Pokemon pokemon){
    }

    public void levelUpPokemon(Pokemon pokemon){
        pokemon.increaseLevel();
    }

    public void randomiseMove(Pokemon pokemon){
    }

    public void setNewMove(Pokemon pokemon, Move move){
        pokemon.setActiveMove(move);
    }
}
