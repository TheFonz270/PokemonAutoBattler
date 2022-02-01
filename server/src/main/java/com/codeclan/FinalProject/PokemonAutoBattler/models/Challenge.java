package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;
import java.util.List;

public class Challenge {

    private User user;

    private Trainer playerTrainer;

    private List<Round> rounds;

    private StatTracker runTracker;

    public Challenge(User user, Trainer playerTrainer, StatTracker runTracker) {
        this.user = user;
        this.playerTrainer = playerTrainer;
        this.rounds = new ArrayList<>();
        this.runTracker = runTracker;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trainer getPlayerTrainer() {
        return playerTrainer;
    }

    public void setPlayerTrainer(Trainer playerTrainer) {
        this.playerTrainer = playerTrainer;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public StatTracker getRunTracker() {
        return runTracker;
    }

    public void setRunTracker(StatTracker runTracker) {
        this.runTracker = runTracker;
    }

    public int getRoundsSize() {
        return rounds.size();
    }

    public void addRound(Round round) {
        rounds.add(round);
    }

    public void createPlayerTrainer(){
    }

    public void teamSelection(){
    }
}
