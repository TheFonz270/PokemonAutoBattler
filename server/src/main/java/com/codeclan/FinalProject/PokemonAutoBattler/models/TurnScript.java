package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;
import java.util.List;

public class TurnScript {

    private boolean playerFirst;

    private int firstDamageDealt;

    private boolean didP2faint;

    private int secondDamageDealt;

    private boolean didP1Faint;

    private boolean didP2NewMon;

    private boolean didP1NewMon;

    private boolean P1OutOfMons;

    private boolean P2OutOfMons;

    private Pokemon p1activePokemon;

    private Pokemon p2activePokemon;

    private Trainer userTrainer;

    private Trainer aiTrainer;

    private Trainer p1;

    private Trainer p2;

    public TurnScript(Trainer userTrainer, Trainer aiTrainer) {
        this.userTrainer = userTrainer;
        this.aiTrainer = aiTrainer;
    }

    public boolean playerFirst(Trainer userTrainer, Trainer aiTrainer) {
        Pokemon userActivePokemon = setActivePokemon(userTrainer);
        Pokemon aiActivePokemon = setActivePokemon(aiTrainer);
        setActivePokemon(aiTrainer);
        if (userActivePokemon.getEffectiveSpeed() >= aiActivePokemon.getEffectiveSpeed()) {
            return true;
        } else {
            return false;
        }
    }

    public Trainer setP1(Trainer userTrainer, Trainer aiTrainer) {
        if (playerFirst(userTrainer, aiTrainer)) {
            Trainer p1 = userTrainer;
            return p1;
        } else {
            Trainer p1 = aiTrainer;
            return p1;
        }
    }

    public Trainer setP2(Trainer userTrainer, Trainer aiTrainer) {
        if (playerFirst(userTrainer, aiTrainer)) {
            Trainer p2 = aiTrainer;
            return p2;
        } else {
            Trainer p2 = userTrainer;
            return p2;
        }
    }

    public Pokemon setActivePokemon(Trainer trainer){
        Pokemon activePokemon;
        ArrayList<Pokemon> pokemons = trainer.getPokemons();
        activePokemon = pokemons.stream().filter(pokemon -> pokemon.getIsFainted() == false).findFirst().orElse(null);
        return activePokemon;
    }

    public Pokemon setP1ActivePokemon(Trainer trainer){
        Pokemon p1ActivePokemon = setActivePokemon(trainer);
        return p1ActivePokemon;
    }

    public Pokemon setP2ActivePokemon(Trainer trainer){
        Pokemon p2ActivePokemon = setActivePokemon(trainer);
        return p2ActivePokemon;
    }


    public void p1dealDamage(Pokemon p1activePokemon, Pokemon p2activePokemon) {
        int damage = (int) BattlePhase.damageCalculation(p1activePokemon, p2activePokemon);
            p2activePokemon.takeDamage(damage);
    }

    public void p2dealDamage(Pokemon p1activePokemon, Pokemon p2activePokemon) {
        int damage = (int) BattlePhase.damageCalculation(p2activePokemon, p1activePokemon);
        p1activePokemon.takeDamage(damage);
    }

    public boolean checkDidP2Faint(Pokemon p2activePokemon){
        if (p2activePokemon.getIsFainted() == true){
            return true;
        }
        return false;
    }
    public boolean checkDidP1Faint(Pokemon p1activePokemon){
        if (p1activePokemon.getIsFainted() == true){
            return true;
        }
        return false;
    }

    public int getCurrentHPP1(Pokemon p1activePokemon){
        return p1activePokemon.getCurrentHP();
    }

    public int getCurrentHPP2(Pokemon p2activePokemon){
        return p2activePokemon.getCurrentHP();
    }

    public void playTurnP1(Trainer userTrainer, Trainer aiTrainer){
        playerFirst(userTrainer, aiTrainer);
        Trainer player1 = setP1(userTrainer, aiTrainer);
        Trainer player2 = setP2(userTrainer, aiTrainer);

        Pokemon player1ActivePokemon = setP1ActivePokemon(player1);
        Pokemon player2ActivePokemon = setP2ActivePokemon(player2);
        
        p1dealDamage(player1ActivePokemon, player2ActivePokemon);
        getCurrentHPP2(player2ActivePokemon);
        checkDidP2Faint(player2ActivePokemon);
    }

    public void playTurnP2(Trainer userTrainer, Trainer aiTrainer){
        playerFirst(userTrainer, aiTrainer);
        Trainer player1 = setP1(userTrainer, aiTrainer);
        Trainer player2 = setP2(userTrainer, aiTrainer);

        Pokemon player1ActivePokemon = setP1ActivePokemon(player1);
        Pokemon player2ActivePokemon = setP2ActivePokemon(player2);

        p2dealDamage(player2ActivePokemon, player1ActivePokemon);
        getCurrentHPP1(player1ActivePokemon);
        checkDidP1Faint(player1ActivePokemon);
    }
//>>>>>>> 243033d1f754342cf3ec83ad084e2827cb2329a6

    public void playWholeTurn(Trainer userTrainer, Trainer aiTrainer){
        playTurnP1(userTrainer, aiTrainer);
        playTurnP2(userTrainer, aiTrainer);
    }





}
