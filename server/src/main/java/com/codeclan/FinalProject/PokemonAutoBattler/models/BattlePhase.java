package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;
import java.util.HashMap;

public class BattlePhase {

    private ArrayList<Trainer> trainers;
    private String theme;

    public BattlePhase(String theme) {
        this.theme = theme;
        this.trainers = new ArrayList<>();
    }


    public ArrayList<Trainer> getTrainers() {
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

//    public double effectivenessLookup(Pokemon attackingPokemon, Pokemon defendingPokemon){
//        int effectiveness = 0;
//
//        Types attackingType = attackingPokemon.getActiveMove().getType();
//        ArrayList<Types> defendingTypes = defendingPokemon.getTypes();
//
//
//        return effectiveness;
//    }

//    public HashMap<Types, ArrayList<ArrayList<Types>>> effectivness() {
//
//        HashMap<Types, ArrayList<ArrayList<Types>>> effectivnessChart = new HashMap<>();
//
//        ArrayList<ArrayList<Types>> SeffResImm = new ArrayList<>();
//        ArrayList<Types> seff = new ArrayList<>();
//        ArrayList<Types> res = new ArrayList<>();
//        res.add(Types.STEEL);
//        res.add(Types.ROCK);
//        ArrayList<Types> imm = new ArrayList<>();
//        imm.add(Types.GHOST);
//        SeffResImm.add(seff);
//        SeffResImm.add(res);
//        SeffResImm.add(imm);
//        effectivnessChart.put(Types.NORMAL, SeffResImm);
//
//        ArrayList<ArrayList<Types>> SeffResImm = new ArrayList<>();
//        ArrayList<Types> seff = new ArrayList<>();
//        seff.add(Types.GRASS);
//        seff.add(Types.STEEL);
//        seff.add(Types.ICE);
//        seff.add(Types.BUG);
//        ArrayList<Types> res = new ArrayList<>();
//        res.add(Types.FIRE);
//        res.add(Types.WATER);
//        res.add(Types.ROCK);
//        res.add(Types.DRAGON);
//        ArrayList<Types> imm = new ArrayList<>();
//        SeffResImm.add(seff);
//        SeffResImm.add(res);
//        SeffResImm.add(imm);
//        effectivnessChart.put(Types.FIRE, SeffResImm);
//
//        ArrayList<ArrayList<Types>> WaterSeffResImm = new ArrayList<>();
//        ArrayList<Types> WaterSeff = new ArrayList<>();
//        WaterSeff.add(Types.FIRE);
//        WaterSeff.add(Types.GROUND);
//        WaterSeff.add(Types.ROCK);
//        ArrayList<Types> WaterRes = new ArrayList<>();
//        WaterRes.add(Types.GRASS);
//        WaterRes.add(Types.WATER);
//        WaterRes.add(Types.DRAGON);
//        ArrayList<Types> WaterImm = new ArrayList<>();
//        WaterSeffResImm.add(WaterSeff);
//        WaterSeffResImm.add(WaterRes);
//        WaterSeffResImm.add(WaterImm);
//        effectivnessChart.put(Types.WATER, WaterSeffResImm);
//
//        ArrayList<ArrayList<Types>> ElectricSeffResImm = new ArrayList<>();
//        ArrayList<Types> ElectricSeff = new ArrayList<>();
//        ElectricSeff.add(Types.WATER);
//        ElectricSeff.add(Types.FLYING);
//        ArrayList<Types> ElectricRes = new ArrayList<>();
//        ElectricRes.add(Types.ELECTRIC);
//        ElectricRes.add(Types.GRASS);
//        ElectricRes.add(Types.DRAGON);
//        ArrayList<Types> ElectricImm = new ArrayList<>();
//        ElectricImm.add(Types.GROUND);
//        ElectricSeffResImm.add(ElectricSeff);
//        ElectricSeffResImm.add(ElectricRes);
//        ElectricSeffResImm.add(ElectricImm);
//        effectivnessChart.put(Types.ELECTRIC, ElectricSeffResImm);
//
//
////
//        ArrayList<ArrayList<Types>> GrassSeffResImm = new ArrayList<>();
//        ArrayList<Types> GrassSeff = new ArrayList<>();
//        GrassSeff.add(Types.WATER);
//        GrassSeff.add(Types.GROUND);
//        GrassSeff.add(Types.ROCK);
//        ArrayList<Types> GrassRes = new ArrayList<>();
//        GrassRes.add(Types.FIRE);
//        GrassRes.add(Types.GRASS);
//        GrassRes.add(Types.DRAGON);
//        GrassRes.add(Types.POISON);
//        GrassRes.add(Types.BUG);
//        GrassRes.add(Types.STEEL);
//        GrassRes.add(Types.FLYING);
//        ArrayList<Types> GrassImm = new ArrayList<>();
//        GrassSeffResImm.add(GrassSeff);
//        GrassSeffResImm.add(GrassRes);
//        GrassSeffResImm.add(GrassImm);
//        effectivnessChart.put(Types.GRASS, GrassSeffResImm);
//
//
//        ArrayList<ArrayList<Types>> IceSeffResImm = new ArrayList<>();
//        ArrayList<Types> IceSeff = new ArrayList<>();
//        IceSeff.add(Types.GRASS);
//        IceSeff.add(Types.GROUND);
//        IceSeff.add(Types.FLYING);
//        IceSeff.add(Types.DRAGON);
//        ArrayList<Types> IceRes = new ArrayList<>();
//        IceRes.add(Types.FIRE);
//        IceRes.add(Types.WATER);
//        IceRes.add(Types.ICE);
//        IceRes.add(Types.STEEL);
//        ArrayList<Types> IceImm = new ArrayList<>();
//        IceSeffResImm.add(IceSeff);
//        IceSeffResImm.add(IceRes);
//        IceSeffResImm.add(IceImm);
//        effectivnessChart.put(Types.ICE, IceSeffResImm);
//
//
//        ArrayList<ArrayList<Types>> FightingSeffResImm = new ArrayList<>();
//        ArrayList<Types> FightingSeff = new ArrayList<>();
//        FightingSeff.add(Types.NORMAL);
//        FightingSeff.add(Types.ICE);
//        FightingSeff.add(Types.ROCK);
//        FightingSeff.add(Types.DARK);
//        FightingSeff.add(Types.STEEL);
//        ArrayList<Types> FightingRes = new ArrayList<>();
//        FightingRes.add(Types.POISON);
//        FightingRes.add(Types.PSYCHIC);
//        FightingRes.add(Types.FLYING);
//        FightingRes.add(Types.FAIRY);
//        FightingRes.add(Types.BUG);
//        ArrayList<Types> FightingImm = new ArrayList<>();
//        FightingImm.add(Types.GHOST);
//        FightingSeffResImm.add(FightingSeff);
//        FightingSeffResImm.add(FightingRes);
//        FightingSeffResImm.add(FightingImm);
//        effectivnessChart.put(Types.FIGHTING, FightingSeffResImm);
//
//        ArrayList<ArrayList<Types>> PoisonSeffResImm = new ArrayList<>();
//        ArrayList<Types> PoisonSeff = new ArrayList<>();
//        PoisonSeff.add(Types.GRASS);
//        PoisonSeff.add(Types.FAIRY);
//        ArrayList<Types> PoisonRes = new ArrayList<>();
//        PoisonRes.add(Types.POISON);
//        PoisonRes.add(Types.GROUND);
//        PoisonRes.add(Types.ROCK);
//        PoisonRes.add(Types.GHOST);
//        ArrayList<Types> PoisonImm = new ArrayList<>();
//        PoisonImm.add(Types.STEEL);
//        FightingSeffResImm.add(PoisonSeff);
//        FightingSeffResImm.add(PoisonRes);
//        FightingSeffResImm.add(PoisonImm);
//        effectivnessChart.put(Types.POISON, PoisonSeffResImm);
//
//        ArrayList<ArrayList<Types>> GroundSeffResImm = new ArrayList<>();
//        ArrayList<Types> GroundSeff = new ArrayList<>();
//        GroundSeff.add(Types.FIRE);
//        GroundSeff.add(Types.ELECTRIC);
//        GroundSeff.add(Types.POISON);
//        GroundSeff.add(Types.ROCK);
//        GroundSeff.add(Types.STEEL);
//        ArrayList<Types> GroundRes = new ArrayList<>();
//        GroundRes.add(Types.GRASS);
//        GroundRes.add(Types.BUG);
//        ArrayList<Types> GroundImm = new ArrayList<>();
//        GroundImm.add(Types.FLYING);
//        GroundSeffResImm.add(GroundSeff);
//        GroundSeffResImm.add(GroundRes);
//        GroundSeffResImm.add(GroundImm);
//        effectivnessChart.put(Types.GROUND, GroundSeffResImm);
//
//        ArrayList<ArrayList<Types>> FlyingSeffResImm = new ArrayList<>();
//        ArrayList<Types> FlyingSeff = new ArrayList<>();
//        FlyingSeff.add(Types.GRASS);
//        FlyingSeff.add(Types.FIGHTING);
//        FlyingSeff.add(Types.BUG);
//        ArrayList<Types> FLyingRes = new ArrayList<>();
//        FLyingRes.add(Types.ELECTRIC);
//        FLyingRes.add(Types.ROCK);
//        FLyingRes.add(Types.STEEL);
//        ArrayList<Types> FlyingImm = new ArrayList<>();
//        FlyingSeffResImm.add(FlyingSeff);
//        FlyingSeffResImm.add(FLyingRes);
//        FlyingSeffResImm.add(FlyingImm);
//        effectivnessChart.put(Types.FLYING, FlyingSeffResImm);
//
//
//        return effectivnessChart;
//    }

    public void pokemonFaints(Pokemon pokemon){
        pokemon.faint();
    }

    public void battleEnd(){

    }

    public void makeBattleScript(){

    }
}
