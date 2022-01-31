package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;

public class BattlePhase {

    private ArrayList<Trainer> trainers;
    private String theme;

    public BattlePhase(String theme){
        this.theme = theme;
        this.trainers = new ArrayList<>();
    }


    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getTrainersSize() {
        return trainers.size();
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }
}
