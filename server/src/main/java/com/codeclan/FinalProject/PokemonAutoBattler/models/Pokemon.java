package com.codeclan.FinalProject.PokemonAutoBattler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    private String name;
    private String avatarImage;
    private ArrayList<Types> types;
    private ArrayList<Move> movePool;
    private Move activeMove;
    private StarLevel level;
    private HashMap<String, Integer> baseStats;
    private HashMap<String, Integer> effectiveStats;
    private boolean canEvolve;
    private boolean isFainted;
//    private int currentHP;

    public Pokemon(String name){
        this.name = name;
    }


    public Pokemon(String name, String avatarImage, Move activeMove, boolean canEvolve){
        this.name = name;
        this.avatarImage = avatarImage;
        this.activeMove = activeMove;
        this.canEvolve = canEvolve;
//        this.currentHP = currentHP;
        this.types = new ArrayList<>();
        this.movePool = new ArrayList<>();
        this.baseStats = new HashMap<>();
        this.effectiveStats = new HashMap<>();
        this.level = StarLevel.ONE_STAR;
        this.isFainted = false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public ArrayList<Types> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Types> types) {
        this.types = types;
    }

    public ArrayList<Move> getMovePool() {
        return movePool;
    }

    public void setMovePool(ArrayList<Move> movePool) {
        this.movePool = movePool;
    }

    public Move getActiveMove() {
        return activeMove;
    }

    public void setActiveMove(Move activeMove) {
        this.activeMove = activeMove;
    }

    public StarLevel getLevel() {
        return level;
    }

    public void setLevel(StarLevel level) {
        this.level = level;
    }

    public HashMap<String, Integer> getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(HashMap<String, Integer> baseStats) {
        this.baseStats = baseStats;
    }

    public HashMap<String, Integer> getEffectiveStats() {
        return effectiveStats;
    }

    public void setEffectiveStats(HashMap<String, Integer> effectiveStats) {
        this.effectiveStats = effectiveStats;
    }

    public boolean canEvolve() {
        return canEvolve;
    }

    public void setCanEvolve(boolean canEvolve) {
        this.canEvolve = canEvolve;
    }

    public boolean isFainted() {
        return isFainted;
    }

    public void setFainted(boolean fainted) {
        isFainted = fainted;
    }

//    public int getCurrentHP() {
//        return currentHP;
//    }
//
//    public void setCurrentHP(int currentHP) {
//        this.currentHP = currentHP;
//    }

    public int getMovePoolSize() {
        return movePool.size();
    }

    public void addToMovePool(Move move) {
        movePool.add(move);
    }

//    public int reduceHP(int damage) {
//        setCurrentHP(currentHP - damage);
//        return currentHP;
//    }
//
//    public void checkIfFaint(){
//        if (currentHP <=0 ){
//            faint();
//        }
//    }

    public void faint() {
        setFainted(true);
    }

//    public void takeDamage(int damage){
//        reduceHP(damage);
//        checkIfFaint();
//    }

    public void increaseLevel() {
        if (getLevel() == StarLevel.ONE_STAR){
            setLevel(StarLevel.TWO_STARS);
        }
        else if (getLevel() == StarLevel.TWO_STARS){
            setLevel(StarLevel.THREE_STARS);
        }
        else {
            System.out.println(name + " is already at max Level!!");
        }
    }

    public void learnMove(Move move) {
        setActiveMove(move);
    }

    public void calculateStats(){
    }

    public void randomiseNewMove(){
    }

    public void attack(Move move){
    }

    public void heal(){

    }


}
