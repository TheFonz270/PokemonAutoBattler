package com.codeclan.FinalProject.PokemonAutoBattler.models;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;

public class BattleScript {


    private ArrayList<Trainer> trainers;

    private ArrayList<TurnScript> script;

    public BattleScript(ArrayList<Trainer> trainers){
        this.trainers = new ArrayList<Trainer>();
        this.script = new ArrayList<TurnScript>();
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void addTurnScript(TurnScript turnScript){
        script.add(turnScript);
    }
    public ArrayList<TurnScript> getScript() {
        return script;
    }

    public int getScriptSize(){
        return script.size();
    }

    public void setScript(ArrayList<TurnScript> script) {
        this.script = script;
    }
}
