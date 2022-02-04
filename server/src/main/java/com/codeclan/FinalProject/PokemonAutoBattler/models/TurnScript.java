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


    public int p1dealDamage(Pokemon p1activePokemon, Pokemon p2activePokemon) {
        int damage = (int) BattlePhase.damageCalculation(p1activePokemon, p2activePokemon);
            p2activePokemon.takeDamage(damage);
            return damage;
    }

    public int p2dealDamage(Pokemon p1activePokemon, Pokemon p2activePokemon) {
        int damage = (int) BattlePhase.damageCalculation(p2activePokemon, p1activePokemon);
        p1activePokemon.takeDamage(damage);
        return damage;
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

    public boolean playTurnP1(Trainer userTrainer, Trainer aiTrainer){
        playerFirst(userTrainer, aiTrainer);
        Trainer player1 = setP1(userTrainer, aiTrainer);
        Trainer player2 = setP2(userTrainer, aiTrainer);

        Pokemon player1ActivePokemon = setP1ActivePokemon(player1);
        Pokemon player2ActivePokemon = setP2ActivePokemon(player2);

        System.out.println("First part of turn readout: Player 1's " + player1ActivePokemon.getName()+  "'s currentHP: " + player1ActivePokemon.getCurrentHP()+ ", Player 2's " + player2ActivePokemon.getName() + "'s currentHP: " + player2ActivePokemon.getCurrentHP());

        p1dealDamage(player1ActivePokemon, player2ActivePokemon);
        System.out.println(player1ActivePokemon.getName() + " used " + player1ActivePokemon.getActiveMove().getName() +  " on " + player2ActivePokemon.getName());
        getCurrentHPP2(player2ActivePokemon);
        checkDidP2Faint(player2ActivePokemon);
        if (checkDidP2Faint(player2ActivePokemon)){
            System.out.println("player 1 currentHP " + player1ActivePokemon.getCurrentHP()+ ", player 2 currentHP " + player2ActivePokemon.getCurrentHP());
            System.out.println("Player 2's pokemon fainted!");
            return true;
        } else {
            playTurnP2(player1, player2);
            return false;
        }
    }

    public boolean playTurnP2(Trainer userTrainer, Trainer aiTrainer){
        playerFirst(userTrainer, aiTrainer);
        Trainer player1 = setP1(userTrainer, aiTrainer);
        Trainer player2 = setP2(userTrainer, aiTrainer);

        Pokemon player1ActivePokemon = setP1ActivePokemon(player1);
        Pokemon player2ActivePokemon = setP2ActivePokemon(player2);
        System.out.println("Second part of turn readout: Player 1's " + player1ActivePokemon.getName()+  "'s currentHP: " + player1ActivePokemon.getCurrentHP()+ ", Player 2's " + player2ActivePokemon.getName() + "'s currentHP: " + player2ActivePokemon.getCurrentHP());

        p2dealDamage(player1ActivePokemon, player2ActivePokemon);
        System.out.println(player2ActivePokemon.getName() + " used " + player2ActivePokemon.getActiveMove().getName() +  " on " + player1ActivePokemon.getName());
        getCurrentHPP1(player1ActivePokemon);
        checkDidP1Faint(player1ActivePokemon);
        if (checkDidP1Faint(player1ActivePokemon)){
            System.out.println("player 1 currentHP " + player1ActivePokemon.getCurrentHP()+ ", player 2 currentHP " + player2ActivePokemon.getCurrentHP());
            System.out.println("Player 1's pokemon fainted!");
            return true;
        } else {
            playTurnP1(player1, player2);
            return false;
        }
    }
//>>>>>>> 243033d1f754342cf3ec83ad084e2827cb2329a6

//    public String playWholeTurn(Trainer userTrainer, Trainer aiTrainer) {
//        playTurnP1(userTrainer, aiTrainer);
//        if (playTurnP1(userTrainer, aiTrainer) == false) {
//            playTurnP2(userTrainer, aiTrainer);
//            return "It's player 2's turn now!";
//        } else {
//            return "P2's pokemon has fainted!";
//        }
//    }

    }






