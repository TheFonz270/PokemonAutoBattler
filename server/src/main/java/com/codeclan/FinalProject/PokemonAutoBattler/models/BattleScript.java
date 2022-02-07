package com.codeclan.FinalProject.PokemonAutoBattler.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.converter.json.GsonBuilderUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "battle_scripts")
public class BattleScript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"battleScript"})
    @OneToMany(mappedBy = "battleScript")
    private List<Trainer> trainers;

    @JsonIgnoreProperties({"battleScript"})
    @OneToMany(mappedBy = "battleScript")
    private List<TurnScript> script;

    @OneToOne(mappedBy = "battleScript")
    @JsonBackReference
    private BattlePhase battlePhase;

    public BattleScript(ArrayList<Trainer> trainers){
        this.trainers = trainers;
        this.script = new ArrayList<TurnScript>();
        this.battlePhase = null;
    }

    public BattleScript() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BattlePhase getBattlePhase() {
        return battlePhase;
    }

    public void setBattlePhase(BattlePhase battlePhase) {
        this.battlePhase = battlePhase;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void addTurnScript(TurnScript turnScript){
        script.add(turnScript);
    }
    public List<TurnScript> getScript() {
        return script;
    }

    public int getScriptSize(){
        return script.size();
    }

    public void setScript(ArrayList<TurnScript> script) {
        this.script = script;
    }
}
