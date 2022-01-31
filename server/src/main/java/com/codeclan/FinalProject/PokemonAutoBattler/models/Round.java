package com.codeclan.FinalProject.PokemonAutoBattler.models;

public class Round {

    private MaintenancePhase maintenancePhase;

    private BattlePhase battlePhase;

    public Round(MaintenancePhase maintenancePhase, BattlePhase battlePhase){
        this.maintenancePhase = maintenancePhase;
        this.battlePhase = battlePhase;

    }

    public MaintenancePhase getMaintenancePhase() {
        return maintenancePhase;
    }

    public void setMaintenancePhase(MaintenancePhase maintenancePhase) {
        this.maintenancePhase = maintenancePhase;
    }

    public BattlePhase getBattlePhase() {
        return battlePhase;
    }

    public void setBattlePhase(BattlePhase battlePhase) {
        this.battlePhase = battlePhase;
    }
}
