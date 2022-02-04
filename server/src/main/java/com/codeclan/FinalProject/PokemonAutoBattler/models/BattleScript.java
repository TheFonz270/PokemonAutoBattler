package com.codeclan.FinalProject.PokemonAutoBattler.models;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;

public class BattleScript {

    private Trainer userTrainer;

    private Trainer aiTrainer;

    private TurnScript turnScript;

    private ArrayList<Trainer> trainers;

    private ArrayList<TurnScript> turnScripts;

    private Trainer winningTrainer;

    private Trainer losingTrainer;

    public BattleScript(Trainer userTrainer, Trainer aiTrainer){
        this.userTrainer = userTrainer;
        this.aiTrainer = aiTrainer;
        turnScripts = new ArrayList<TurnScript>();
    }

    public ArrayList<TurnScript> getTurnScripts() {
        return turnScripts;
    }

    public void setScripts(ArrayList<TurnScript> turnScripts) {
        this.turnScripts = turnScripts;
    }

    public int getTurnScriptsSize(){
        return turnScripts.size();
    }

    public void addTurnScript(TurnScript turnScript){
        this.turnScripts.add(turnScript);
    }

    public Trainer getWinningTrainer() {
        return winningTrainer;
    }

    public void setWinningTrainer(Trainer winningTrainer) {
        this.winningTrainer = winningTrainer;
    }

    public Trainer getLosingTrainer() {
        return losingTrainer;
    }

    public void setLosingTrainer(Trainer losingTrainer) {
        this.losingTrainer = losingTrainer;
    }

    public Trainer getUserTrainer() {
        return userTrainer;
    }

    public void setUserTrainer(Trainer userTrainer) {
        this.userTrainer = userTrainer;
    }

    public Trainer getAiTrainer() {
        return aiTrainer;
    }

    public void setAiTrainer(Trainer aiTrainer) {
        this.aiTrainer = aiTrainer;
    }

    public TurnScript getTurnScript() {
        return turnScript;
    }

    public void setTurnScript(TurnScript turnScript) {
        this.turnScript = turnScript;
    }

    public void setTurnScripts(ArrayList<TurnScript> turnScripts) {
        this.turnScripts = turnScripts;
    }

    public Trainer checkWinner(Trainer userTrainer, Trainer aiTrainer, TurnScript turnScript) {
        if (turnScript.setActivePokemon(userTrainer) == null) {
            System.out.println("You lose!");
            setWinningTrainer(aiTrainer);
        } else if (turnScript.setActivePokemon(aiTrainer) == null) {
            System.out.println("You win!");
            setWinningTrainer(userTrainer);
        }
        return winningTrainer;
    }

    public Trainer playWholeBattle(Trainer userTrainer, Trainer aiTrainer, TurnScript turnScript){
        while(checkWinner(userTrainer, aiTrainer, turnScript) == null){
            turnScript.playTurnP1(userTrainer, aiTrainer);
            turnScripts.add(turnScript);
        }

        Trainer winningTrainer = checkWinner(userTrainer, aiTrainer, turnScript);

        System.out.println(winningTrainer);
        return winningTrainer;
    }



}
