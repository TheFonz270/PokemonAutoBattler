package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;
import java.util.List;

public class TurnScript {

    private boolean playerFirst;

    private int firstDamageDealt;

    private int P2CurrentHP;

    private boolean didP2Faint;

    private int secondDamageDealt;

    private int P1CurrentHP;

    private boolean didP1Faint;

    private boolean didP2NewMon;

    private boolean didP1NewMon;

    private boolean P1OutOfMons;

    private boolean P2OutOfMons;

//    private Pokemon p1activePokemon;
//
//    private Pokemon p2activePokemon;
//
//    private Trainer userTrainer;
//
//    private Trainer aiTrainer;
//
//    private Trainer p1;
//
//    private Trainer p2;

    public TurnScript(boolean playerFirst, int firstDamageDealt, int P2CurrentHP, boolean didP2Faint, int secondDamageDealt, int P1CurrentHP, boolean didP1Faint, boolean didP2NewMon, boolean didP1NewMon, boolean p1OutOfMons, boolean p2OutOfMons) {
        this.playerFirst = playerFirst;
        this.firstDamageDealt = 0;
        this.P2CurrentHP = 0;
        this.didP2Faint = false;
        this.secondDamageDealt = 0;
        this.P1CurrentHP = 0;
        this.didP1Faint = false;
        this.didP2NewMon = false;
        this.didP1NewMon = false;
        this.P1OutOfMons = false;
        this.P2OutOfMons = false;
    }

    public boolean getPlayerFirst() {
        return playerFirst;
    }

    public void setPlayerFirst(boolean playerFirst) {
        this.playerFirst = playerFirst;
    }

    public int getFirstDamageDealt() {
        return firstDamageDealt;
    }

    public void setFirstDamageDealt(int firstDamageDealt) {
        this.firstDamageDealt = firstDamageDealt;
    }

    public int getP2CurrentHP() {
        return P2CurrentHP;
    }

    public void setP2CurrentHP(int p2CurrentHP) {
        P2CurrentHP = p2CurrentHP;
    }

    public int getP1CurrentHP() {
        return P1CurrentHP;
    }

    public void setP1CurrentHP(int p1CurrentHP) {
        P1CurrentHP = p1CurrentHP;
    }

    public boolean getDidP2Faint() {
        return didP2Faint;
    }

    public void setDidP2Faint(boolean didP2Faint) {
        this.didP2Faint = didP2Faint;
    }

    public int getSecondDamageDealt() {
        return secondDamageDealt;
    }

    public void setSecondDamageDealt(int secondDamageDealt) {
        this.secondDamageDealt = secondDamageDealt;
    }

    public boolean getDidP1Faint() {
        return didP1Faint;
    }

    public void setDidP1Faint(boolean didP1Faint) {
        this.didP1Faint = didP1Faint;
    }

    public boolean getDidP2NewMon() {
        return didP2NewMon;
    }

    public void setDidP2NewMon(boolean didP2NewMon) {
        this.didP2NewMon = didP2NewMon;
    }

    public boolean getDidP1NewMon() {
        return didP1NewMon;
    }

    public void setDidP1NewMon(boolean didP1NewMon) {
        this.didP1NewMon = didP1NewMon;
    }

    public boolean getP1OutOfMons() {
        return P1OutOfMons;
    }

    public void setP1OutOfMons(boolean p1OutOfMons) {
        P1OutOfMons = p1OutOfMons;
    }

    public boolean getP2OutOfMons() {
        return P2OutOfMons;
    }

    public void setP2OutOfMons(boolean p2OutOfMons) {
        P2OutOfMons = p2OutOfMons;
    }

    //Moved to BattlePhase

//    public boolean playerFirst(Trainer userTrainer, Trainer aiTrainer) {
//        Pokemon userActivePokemon = setActivePokemon(userTrainer);
//        Pokemon aiActivePokemon = setActivePokemon(aiTrainer);
//        setActivePokemon(aiTrainer);
//        if (userActivePokemon.getEffectiveSpeed() >= aiActivePokemon.getEffectiveSpeed()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

//    moved to battlephase
//    public Trainer setP1(Trainer userTrainer, Trainer aiTrainer) {
//        if (playerFirst(userTrainer, aiTrainer)) {
//            Trainer p1 = userTrainer;
//            return p1;
//        } else {
//            Trainer p1 = aiTrainer;
//            return p1;
//        }
//    }

//    moved to battle phase
//    public Trainer setP2(Trainer userTrainer, Trainer aiTrainer) {
//        if (playerFirst(userTrainer, aiTrainer)) {
//            Trainer p2 = aiTrainer;
//            return p2;
//        } else {
//            Trainer p2 = userTrainer;
//            return p2;
//        }
//    }

//    moved to battlephase
//    public Pokemon setActivePokemon(Trainer trainer){
//        Pokemon activePokemon;
//        List<Pokemon> pokemons = trainer.getPokemons();
//        activePokemon = pokemons.stream().filter(pokemon -> pokemon.getIsFainted() == false).findFirst().orElse(null);
//        return activePokemon;
//    }

//    moved to battlephase
//    public Pokemon setP1ActivePokemon(Trainer trainer){
//        Pokemon p1ActivePokemon = setActivePokemon(trainer);
//        return p1ActivePokemon;
//    }

//    moved to battlephase
//    public Pokemon setP2ActivePokemon(Trainer trainer){
//        Pokemon p2ActivePokemon = setActivePokemon(trainer);
//        return p2ActivePokemon;
//    }

// moved to battlephase
//    public int p1dealDamage(Pokemon p1activePokemon, Pokemon p2activePokemon) {
//        int damage = (int) BattlePhase.damageCalculation(p1activePokemon, p2activePokemon);
//            p2activePokemon.takeDamage(damage);
//            return damage;
//    }

//    public int p2dealDamage(Pokemon p1activePokemon, Pokemon p2activePokemon) {
//        int damage = (int) BattlePhase.damageCalculation(p2activePokemon, p1activePokemon);
//        p1activePokemon.takeDamage(damage);
//        return damage;
//    }

//    moved to battlephase
//    public boolean checkDidP2Faint(Pokemon p2activePokemon){
//        if (p2activePokemon.getIsFainted() == true){
//            return true;
//        }
//        return false;
//    }

//    move to battlephase
//    public boolean checkDidP1Faint(Pokemon p1activePokemon){
//        if (p1activePokemon.getIsFainted() == true){
//            return true;
//        }
//        return false;
//    }

//    moved to battlephase
//    public int getCurrentHPP1(Pokemon p1activePokemon){
//        return p1activePokemon.getCurrentHP();
//    }

//    moved to battlephase
//    public int getCurrentHPP2(Pokemon p2activePokemon){
//        return p2activePokemon.getCurrentHP();
//    }

//    moved to battlephase
//    public boolean playTurnP1(Trainer userTrainer, Trainer aiTrainer){
//        playerFirst(userTrainer, aiTrainer);
//        Trainer player1 = setP1(userTrainer, aiTrainer);
//        Trainer player2 = setP2(userTrainer, aiTrainer);
//
//        Pokemon player1ActivePokemon = setP1ActivePokemon(player1);
//        Pokemon player2ActivePokemon = setP2ActivePokemon(player2);
//
//        System.out.println("First part of turn readout: Player 1's " + player1ActivePokemon.getName()+  "'s currentHP: " + player1ActivePokemon.getCurrentHP()+ ", Player 2's " + player2ActivePokemon.getName() + "'s currentHP: " + player2ActivePokemon.getCurrentHP());
//
//        p1dealDamage(player1ActivePokemon, player2ActivePokemon);
//        System.out.println(player1ActivePokemon.getName() + " used " + player1ActivePokemon.getActiveMove().getName() +  " on " + player2ActivePokemon.getName());
//        getCurrentHPP2(player2ActivePokemon);
//        checkDidP2Faint(player2ActivePokemon);
//        if (checkDidP2Faint(player2ActivePokemon)){
//            System.out.println("player 1 currentHP " + player1ActivePokemon.getCurrentHP()+ ", player 2 currentHP " + player2ActivePokemon.getCurrentHP());
//            System.out.println("Player 2's pokemon fainted!");
//            return true;
//        } else {
//            playTurnP2(player1, player2);
//            return false;
//        }
//    }

//    public boolean playTurnP2(Trainer userTrainer, Trainer aiTrainer){
//        playerFirst(userTrainer, aiTrainer);
//        Trainer player1 = setP1(userTrainer, aiTrainer);
//        Trainer player2 = setP2(userTrainer, aiTrainer);
//
//        Pokemon player1ActivePokemon = setP1ActivePokemon(player1);
//        Pokemon player2ActivePokemon = setP2ActivePokemon(player2);
//        System.out.println("Second part of turn readout: Player 1's " + player1ActivePokemon.getName()+  "'s currentHP: " + player1ActivePokemon.getCurrentHP()+ ", Player 2's " + player2ActivePokemon.getName() + "'s currentHP: " + player2ActivePokemon.getCurrentHP());
//
//        p2dealDamage(player1ActivePokemon, player2ActivePokemon);
//        System.out.println(player2ActivePokemon.getName() + " used " + player2ActivePokemon.getActiveMove().getName() +  " on " + player1ActivePokemon.getName());
//        getCurrentHPP1(player1ActivePokemon);
//        checkDidP1Faint(player1ActivePokemon);
//        if (checkDidP1Faint(player1ActivePokemon)){
//            System.out.println("player 1 currentHP " + player1ActivePokemon.getCurrentHP()+ ", player 2 currentHP " + player2ActivePokemon.getCurrentHP());
//            System.out.println("Player 1's pokemon fainted!");
//            return true;
//        } else {
//            playTurnP1(player1, player2);
//            return false;
//        }
//    }




    }






