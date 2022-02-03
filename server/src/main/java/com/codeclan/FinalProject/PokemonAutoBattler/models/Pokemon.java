package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Pokemon {

    private int pokemonId;
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
    private int currentHP;
    int hp;
    int atk;
    int def;
    int spAtk;
    int spDef;
    int speed;


    public Pokemon(int pokemonId, String name, String avatarImage, Move activeMove, int hp, int atk, int def, int spAtk, int spDef, int speed){
        this.pokemonId = pokemonId;
        this.name = name;
        this.avatarImage = avatarImage;
        this.types = new ArrayList<>();
        this.movePool = new ArrayList<>();
        this.activeMove = activeMove;
        this.level = StarLevel.ONE_STAR;
        this.atk = atk;
        this.hp = hp;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.baseStats = new HashMap<String, Integer>();
        baseStats.put("HP", hp);
        baseStats.put("Atk", atk);
        baseStats.put("Def", def);
        baseStats.put("SpAtk", spAtk);
        baseStats.put("SpDef", spDef);
        baseStats.put("Speed", speed);
        this.effectiveStats = new HashMap<String, Integer>();
        this.isFainted = false;
        this.currentHP = 0;


    }

    public int getPokemonId(){
        return pokemonId;
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

    public int getIntLevel(){
        int calcLevel = level.level;
        return calcLevel;
    }

    public HashMap<String, Integer> getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(HashMap<String, Integer> baseStats) {
        this.baseStats = baseStats;
    }

//    public HashMap<String, Integer> addStats(int hp, int atk, int def, int spatk, int spdef, int speed){
//        baseStats.put("HP", hp);
//        baseStats.put("Atk", atk);
//        baseStats.put("Def", def);
//        baseStats.put("SpAtk", spatk);
//        baseStats.put("SpDef", spdef);
//        baseStats.put("Speed", speed);
//        return  baseStats;
//    }

    public HashMap<String, Integer> getEffectiveStats() {
        return effectiveStats;
    }

    public void setEffectiveStats(HashMap<String, Integer> effectiveStats) {
        this.effectiveStats = effectiveStats;
    }

    public HashMap<String, Integer> calculateEffectiveStats(){

        int calcLevel = level.level;

        Integer newHP = ((((baseStats.get("HP")*2) *calcLevel)/100)+calcLevel)+10;
        Integer newAtk = (((baseStats.get("Atk")*2) *calcLevel)/100)+5;
        Integer newDef = (((baseStats.get("Def")*2) *calcLevel)/100)+5;
        Integer newSpAtk = (((baseStats.get("SpAtk")*2) *calcLevel)/100)+5;
        Integer newSpDef = (((baseStats.get("SpDef")*2) *calcLevel)/100)+5;
        Integer newSpeed = (((baseStats.get("Speed")*2) *calcLevel)/100)+5;

        effectiveStats.put("HP", newHP);
        effectiveStats.put("Atk", newAtk);
        effectiveStats.put("Def", newDef);
        effectiveStats.put("SpAtk", newSpAtk);
        effectiveStats.put("SpDef", newSpDef);
        effectiveStats.put("Speed", newSpeed);
        setCurrentHP();

        return effectiveStats;

    }

    public boolean canEvolve() {
        return canEvolve;
    }

    public void setCanEvolve(boolean canEvolve) {
        this.canEvolve = canEvolve;
    }

    public boolean getIsFainted(){
        return isFainted;
    }

    public void setFainted(boolean fainted) {
        isFainted = fainted;
    }

    public int getCurrentHP() {
        return Math.max(0, currentHP);
    }

    public void setCurrentHP() {
        this.currentHP = getEffectiveHP();
    }

    public int getMovePoolSize() {
        return movePool.size();
    }

    public void addToMovePool(Move move) {
        movePool.add(move);
    }

    public void reduceHP(int damage) {
        currentHP -= damage;
    }

    public void checkIfFaint(){
        if (currentHP <=0 ){
            faint();
        }
    }

    public void faint() {
        setFainted(true);
    }

    public void takeDamage(int damage){
        reduceHP(damage);
        checkIfFaint();
    }

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

    public void heal(){

    }


    public int getHP() {
         return baseStats.get("HP");
    }

    public int getAtk() {
        return baseStats.get("Atk");
    }

    public int getDef() {
        return baseStats.get("Def");
    }
    public int getSpAtk() {
        return baseStats.get("SpAtk");
    }
    public int getSpDef() {
        return baseStats.get("SpDef");
    }
    public int getSpeed() {
        return baseStats.get("Speed");
    }
    public int getLevelLevel() {
        return level.level;
    }

    public int getEffectiveHP() {
        return effectiveStats.get("HP");
    }

    public int getEffectiveAtk() {
        return effectiveStats.get("Atk");
    }

    public int getEffectiveDef() {
        return effectiveStats.get("Def");
    }

    public int getEffectiveSpAtk() {
        return effectiveStats.get("SpAtk");
    }

    public int getEffectiveSpDef() {
        return effectiveStats.get("SpDef");
    }

    public int getEffectiveSpeed() {
        return effectiveStats.get("Speed");
    }

    public double getStab(){
        if (getTypes().contains(activeMove.getType())){
            return 1.5;
        } else {
        return 1.0;
        }
    }


    public void addType(Types type) {
        types.add(type);
    }
}
