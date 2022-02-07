package com.codeclan.FinalProject.PokemonAutoBattler.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "battle_phases")
public class BattlePhase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"battlePhase"})
    @OneToMany(mappedBy = "battlePhase")
    private List<Trainer> trainers;

    @Column(name = "theme")
    private String theme;

    @OneToOne
    @JoinColumn(name = "battle_script_id")
    private BattleScript battleScript;


    public BattlePhase(String theme, ArrayList<Trainer> trainers) {
        this.theme = theme;
        this.trainers = trainers;
        this.battleScript = new BattleScript(trainers);
    }

    public BattlePhase() {
    }

    public Long getId() {
        return id;
    }

    public BattleScript getBattleScript() {
        return battleScript;
    }

    public void setBattleScript(BattleScript battleScript) {
        this.battleScript = battleScript;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Trainer> getTrainers() {
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

    @JsonIgnore
    public int getTrainersSize() {
        return trainers.size();
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void startBattle() {
    }

    public void simulateTurn() {
    }

//    public double effectivenessLookup(Pokemon attackingPokemon, Pokemon defendingPokemon){
//        if attackingPokemon.getActiveMove().getType()
//    }

    public static double damageCalculation(Pokemon attackingPokemon, Pokemon defendingPokemon) {


        Move attackingMove = attackingPokemon.getActiveMove();


        int attackingMoveDamage = attackingMove.getDamage();


        double attackingPokemonAtk = attackingPokemon.getEffectiveAtk();

        double attackingPokemonSpAtk = attackingPokemon.getEffectiveSpAtk();


        double defendingPokemonDef = defendingPokemon.getEffectiveDef();

        double defendingPokemonSpDef = defendingPokemon.getEffectiveSpDef();

        int calcLevel = attackingPokemon.getIntLevel();

        double stab = attackingPokemon.getStab();

//        double effectiveness = 1.0;


        if (attackingMove.getDamageType() == DamageType.PHYSICAL) {
            double step1 = 2*calcLevel;
            double step2 = step1/5;
            double step3 = step2+2;
            double step4 = Math.round(step3*attackingMoveDamage);
            double atkOverDef = Math.ceil(attackingPokemonAtk/defendingPokemonDef);
            double step5 = step4*atkOverDef;
            double step6 = step5/50;
            double step7 = step6 + 2;
            double damage = step7 * stab;
            double damageRound = Math.round(damage);
            return damageRound;
    } else if (attackingMove.getDamageType() == DamageType.SPECIAL) {
            double step1 = 2*calcLevel;
            double step2 = step1/5;
            double step3 = step2+2;
            double step4 = Math.round(step3*attackingMoveDamage);
            double atkOverDef = Math.ceil(attackingPokemonSpAtk/defendingPokemonSpDef);
            double step5 = step4*atkOverDef;
            double step6 = step5/50;
            double step7 = step6 + 2;
            double damage = step7 * stab;
            double damageRound = Math.round(damage);
            return damageRound;
        }
        return 1;
    }

    public boolean playerFirst(Trainer userTrainer, Trainer aiTrainer, TurnScript turnScript) {
        Pokemon userActivePokemon = setActivePokemon(userTrainer);
        Pokemon aiActivePokemon = setActivePokemon(aiTrainer);
        setActivePokemon(aiTrainer);
        if (userActivePokemon.getEffectiveSpeed() >= aiActivePokemon.getEffectiveSpeed()) {
            turnScript.setPlayerFirst(true);
            return true;
        } else {
            turnScript.setPlayerFirst(false);
            return false;
        }
    }

    public Trainer setP1(Trainer userTrainer, Trainer aiTrainer, TurnScript turnScript) {
        if (playerFirst(userTrainer, aiTrainer, turnScript)) {
            Trainer p1 = userTrainer;
            return p1;
        } else {
            Trainer p1 = aiTrainer;
            return p1;
        }
    }

    public Trainer setP2(Trainer userTrainer, Trainer aiTrainer, TurnScript turnScript) {
        if (playerFirst(userTrainer, aiTrainer, turnScript)) {
            Trainer p2 = aiTrainer;
            return p2;
        } else {
            Trainer p2 = userTrainer;
            return p2;
        }
    }

    public Pokemon setActivePokemon(Trainer trainer){
        Pokemon activePokemon;
        List<Pokemon> pokemons = trainer.getPokemons();
        activePokemon = pokemons.stream().filter(pokemon -> pokemon.getIsFainted() == false).findFirst().orElse(null);
        return activePokemon;
    }

    public Pokemon setP1ActivePokemon(Trainer trainer){
        Pokemon p1ActivePokemon = setActivePokemon(trainer);
        System.out.println("Player 1, new active pokemon: " + p1ActivePokemon.getName() + "'s currentHP: " + p1ActivePokemon.getCurrentHP() + "/" + p1ActivePokemon.getEffectiveHP()) ;

        return p1ActivePokemon;
    }

    public Pokemon setP2ActivePokemon(Trainer trainer){
        Pokemon p2ActivePokemon = setActivePokemon(trainer);
        System.out.println("Player 2, new active pokemon: " + p2ActivePokemon.getName() + "'s currentHP: " + p2ActivePokemon.getCurrentHP() + "/" + p2ActivePokemon.getEffectiveHP()) ;


        return p2ActivePokemon;
    }

    public void pokemonFaints(Pokemon pokemon){
        pokemon.faint();
    }

    public int p1dealDamage(Pokemon p1activePokemon, Pokemon p2activePokemon, TurnScript turnScript) {
        int damage = (int) BattlePhase.damageCalculation(p1activePokemon, p2activePokemon);
        p2activePokemon.takeDamage(damage);
        turnScript.setFirstDamageDealt(damage);
        if (p2activePokemon.getIsFainted()){
            turnScript.setDidP2Faint(true);
        };
        return damage;
    }

    public int p2dealDamage(Pokemon p1activePokemon, Pokemon p2activePokemon, TurnScript turnScript) {
        int damage = (int) BattlePhase.damageCalculation(p2activePokemon, p1activePokemon);
        p1activePokemon.takeDamage(damage);
        turnScript.setSecondDamageDealt(damage);
        if (p1activePokemon.getIsFainted()){
            turnScript.setDidP1Faint(true);
        };
        return damage;
    }

    public int p1FindDamage(Pokemon p1activePokemon, Pokemon p2activePokemon){
        int damage = (int) BattlePhase.damageCalculation(p1activePokemon, p2activePokemon);
        return damage;
    }

    public int p2FindDamage(Pokemon p1activePokemon, Pokemon p2activePokemon){
        int damage = (int) BattlePhase.damageCalculation(p2activePokemon, p1activePokemon);
        return damage;
    }

    public boolean checkDidP1Faint(Pokemon p1activePokemon){
        if (p1activePokemon.getIsFainted() == true){
            return true;
        }
        return false;
    }

    public int getCurrentHPP1(Pokemon p1activePokemon, TurnScript turnScript){
        int p1CurrentHP = p1activePokemon.getCurrentHP();
        turnScript.setP1CurrentHP(p1CurrentHP);
        return p1CurrentHP;
    }

    public int getCurrentHPP2(Pokemon p2activePokemon, TurnScript turnScript){
        int p2CurrentHP = p2activePokemon.getCurrentHP();
        turnScript.setP2CurrentHP(p2CurrentHP);
        return p2CurrentHP;
    }

    public boolean checkDidP2Faint(Pokemon p2activePokemon){
        if (p2activePokemon.getIsFainted() == true){
            return true;
        }
        return false;
    }

    public Trainer setWinningTrainer(Trainer winningTrainer) {
        Trainer winner = winningTrainer;
        return winningTrainer;
    }





    public BattleScript playWholeBattle(ArrayList<Trainer> trainers){
        Trainer userTrainer = trainers.get(0);
        Trainer aiTrainer = trainers.get(1);
        TurnScript turnScript = new TurnScript(true, 0, 0, false, 0, 0, false, false, false, false, false);
        BattleScript battleScript = new BattleScript(trainers);
        while(checkWinner(userTrainer, aiTrainer, battleScript, turnScript) == null){
            playWholeTurn(userTrainer, aiTrainer, battleScript, turnScript);
        }

        return battleScript;
    }

    public void playWholeTurn(Trainer userTrainer, Trainer aiTrainer, BattleScript battleScript,TurnScript turnScript) {
        Trainer player1 = setP1(userTrainer, aiTrainer, turnScript);
        Trainer player2 = setP2(userTrainer, aiTrainer, turnScript);

        Pokemon player1ActivePokemon = setP1ActivePokemon(player1);
        Pokemon player2ActivePokemon = setP2ActivePokemon(player2);

        System.out.println("Turn Set up - Player 1 active pokemon: " + player1ActivePokemon.getName() + "'s currentHP: " + player1ActivePokemon.getCurrentHP() + "/" + player1ActivePokemon.getEffectiveHP() + ", Player 2's " + player2ActivePokemon.getName() + "'s currentHP: " + player2ActivePokemon.getCurrentHP() + "/" + player2ActivePokemon.getEffectiveHP()) ;

        playTurnP1(player1, player2, player1ActivePokemon, player2ActivePokemon, battleScript, turnScript);
        }


    public boolean playTurnP1(Trainer player1, Trainer player2, Pokemon player1ActivePokemon, Pokemon player2ActivePokemon, BattleScript battleScript, TurnScript turnScript2){
        TurnScript turnScript1 = new TurnScript(true, 0, 0, false, 0, 0, false, false, false, false, false);
        getCurrentHPP1(player1ActivePokemon, turnScript1);
        getCurrentHPP1(player1ActivePokemon, turnScript1);
        System.out.println("playturnP1 "+ "player 1's " + player1ActivePokemon.getName() + " current HP: " + player1ActivePokemon.getCurrentHP() + ", player 2's " + player2ActivePokemon.getName() + " Current HP:" + player2ActivePokemon.getCurrentHP());
        p1dealDamage(player1ActivePokemon, player2ActivePokemon, turnScript1);
        System.out.println("playturnP1 "+ player1ActivePokemon.getName() + " used " + player1ActivePokemon.getActiveMove().getName() +  " on " + player2ActivePokemon.getName() + "it did " + p1FindDamage(player1ActivePokemon, player2ActivePokemon) + "damage");
        System.out.println("playturnP1 "+ "player 1's " + player1ActivePokemon.getName() + " current HP: " + player1ActivePokemon.getCurrentHP() + ", player 2's " + player2ActivePokemon.getName() + " Current HP:" + player2ActivePokemon.getCurrentHP());
        getCurrentHPP2(player2ActivePokemon, turnScript1);
        checkDidP2Faint(player2ActivePokemon);
        if (checkDidP2Faint(player2ActivePokemon)){
            System.out.println("playturnP1 "+ "player 1's " + player1ActivePokemon.getName() + " current HP: " + player1ActivePokemon.getCurrentHP() + ", player 2's " + player2ActivePokemon.getName() + " Current HP:" + player2ActivePokemon.getCurrentHP());
            System.out.println("playturnP1 "+ "Player 2's pokemon fainted!");
            if (checkWinner(player1, player2, battleScript, turnScript1) == null){
                turnScript1.setDidP2NewMon(true);
                battleScript.addTurnScript(turnScript1);
                playWholeTurn(player1, player2, battleScript, turnScript2);
            } else {
                turnScript1.setDidP2NewMon(false);
            }
            System.out.println("----------------------");
            battleScript.addTurnScript(turnScript1);
            return true;
        } else {
            System.out.println("playturnP1 "+ "player 1's " + player1ActivePokemon.getName() + " current HP: " + player1ActivePokemon.getCurrentHP() + ", player 2's " + player2ActivePokemon.getName() + " Current HP:" + player2ActivePokemon.getCurrentHP());
            System.out.println("end of playturnp1!");
            playTurnP2(player1, player2, player1ActivePokemon, player2ActivePokemon, battleScript, turnScript1);
            return false;
        }
    }

    public boolean playTurnP2(Trainer player1, Trainer player2, Pokemon player1ActivePokemon, Pokemon player2ActivePokemon, BattleScript battleScript, TurnScript turnScript){
        System.out.println("playturnP1 "+ "player 1's " + player1ActivePokemon.getName() + " current HP: " + player1ActivePokemon.getCurrentHP() + ", player 2's " + player2ActivePokemon.getName() + " Current HP:" + player2ActivePokemon.getCurrentHP());
        p2dealDamage(player1ActivePokemon, player2ActivePokemon, turnScript);
        System.out.println("playturnP1 "+ player2ActivePokemon.getName() + " used " + player2ActivePokemon.getActiveMove().getName() +  " on " + player1ActivePokemon.getName() + "it did " + p2FindDamage(player1ActivePokemon, player2ActivePokemon) + " damage");
        System.out.println("playturnP1 "+ "player 1's " + player1ActivePokemon.getName() + " current HP: " + player1ActivePokemon.getCurrentHP() + ", player 2's " + player2ActivePokemon.getName() + " Current HP:" + player2ActivePokemon.getCurrentHP());
        getCurrentHPP1(player1ActivePokemon, turnScript);
        checkDidP1Faint(player1ActivePokemon);
        if (checkDidP1Faint(player1ActivePokemon)){
            System.out.println("playturnP1 "+ "player 1's " + player1ActivePokemon.getName() + " current HP: " + player1ActivePokemon.getCurrentHP() + ", player 2's " + player2ActivePokemon.getName() + " Current HP:" + player2ActivePokemon.getCurrentHP());
            System.out.println("playturnP2 "+"Player 1's pokemon fainted!");
            if (checkWinner(player1, player2, battleScript, turnScript) == null){
                turnScript.setDidP1NewMon(true);
            } else {
                turnScript.setDidP1NewMon(false);
            }
            System.out.println(turnScript + "-----------------------------");
            battleScript.addTurnScript(turnScript);
            return true;
        } else {
            System.out.println("playturnP1 "+ "player 1's " + player1ActivePokemon.getName() + "current HP: " + player1ActivePokemon.getCurrentHP() + ", player 2's " + player2ActivePokemon.getName() + " Current HP:" + player2ActivePokemon.getCurrentHP());
            System.out.println("End of playturnp2------------------!");

            playTurnP1(player1, player2, player1ActivePokemon, player2ActivePokemon, battleScript, turnScript);
            battleScript.addTurnScript(turnScript);
            return false;
        }
    }

    public Boolean checkWinner(Trainer player1, Trainer player2, BattleScript battleScript, TurnScript turnScript) {

        if (setActivePokemon(player1) == null) {
            System.out.println("Player 2 wins!");
            turnScript.setP1OutOfMons(true);
            battleEnd(battleScript);
            return true;
        } else if (setActivePokemon(player2) == null) {
            System.out.println("Player 1 wins!");
            turnScript.setP2OutOfMons(true);
            battleEnd(battleScript);
            return false;
        }
        return null;
    }


    public void battleEnd(BattleScript battleScript){
        List<TurnScript> script = battleScript.getScript();
        for (TurnScript turnScript : script){
            System.out.println(
                    "turnScript " +
                    "playerFirst " + turnScript.getPlayerFirst() +
                    ", firstDamageDealt " + turnScript.getFirstDamageDealt() +
                            ", P2CurrentHP " + turnScript.getP2CurrentHP() +
                            ", secondDamageDealt " + turnScript.getSecondDamageDealt() +
                            ", P1CurrentHP " + turnScript.getP1CurrentHP() +
                            ", didP2NewMon " + turnScript.getDidP2NewMon() +
                            ", didP1NewMon " + turnScript.getDidP1NewMon() +
                            ", P1OutOfMons " + turnScript.getP1OutOfMons() +
                            ", didP2Faint " + turnScript.getDidP2Faint()+
                            ", P2OutOfMons " + turnScript.getP2OutOfMons()+
                            ", P1OutOfMons " + turnScript.getP1OutOfMons()

            );

        }





    }

    public void makeBattleScript(){

    }
}
