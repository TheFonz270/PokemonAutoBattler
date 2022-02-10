package com.codeclan.FinalProject.PokemonAutoBattler.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EffectivenessChart {
private HashMap<String, HashMap> typeChart;
private HashMap<String, Double> typeMap;

    public EffectivenessChart(){
    }

    public HashMap<String, HashMap<String, Double>> constructor(){
        HashMap<String, HashMap<String, Double>> typeChart = new HashMap<String, HashMap<String, Double>>();
        typeChart.put("fire", fire());
        typeChart.put("grass", grass());
        typeChart.put("ground", ground());
        typeChart.put("steel", steel());
        typeChart.put("electric", electric());
        typeChart.put("water", water());
        typeChart.put("rock", rock());
        typeChart.put("ice", ice());
        typeChart.put("normal", normal());
        typeChart.put("bug", bug());
        typeChart.put("ghost", ghost());
        typeChart.put("fighting", fighting());
        typeChart.put("dragon", dragon());
        typeChart.put("dark", dark());
        typeChart.put("fairy", fairy());
        typeChart.put("poison", poison());
        typeChart.put("psychic", psychic());
        typeChart.put("flying", flying());
        return typeChart;
    }

    public HashMap<String, Double> fire(){
        HashMap<String, Double> fire = new HashMap<String, Double>();
        fire.put("grass", 2.0);
        fire.put("fire", 0.5);
        fire.put("ground", 1.0);
        fire.put("steel", 2.0);
        fire.put("electric", 1.0);
        fire.put("water", 0.5);
        fire.put("rock", 0.5);
        fire.put("flying", 1.0);
        fire.put("ice", 2.0);
        fire.put("normal", 1.0);
        fire.put("bug", 2.0);
        fire.put("ghost", 1.0);
        fire.put("fighting", 1.0);
        fire.put("dragon", 0.5);
        fire.put("dark", 1.0);
        fire.put("fairy", 1.0);
        fire.put("poison", 1.0);
        fire.put("psychic", 1.0);

        return fire;
    }

    public HashMap<String, Double> grass(){
        HashMap<String, Double> grass = new HashMap<String, Double>();
        grass.put("grass", 0.5);
        grass.put("fire", 0.5);
        grass.put("ground", 2.0);
        grass.put("steel", 0.5);
        grass.put("electric", 1.0);
        grass.put("water", 2.0);
        grass.put("rock", 2.0);
        grass.put("flying", 0.5);
        grass.put("ice", 1.0);
        grass.put("normal", 1.0);
        grass.put("bug", 0.5);
        grass.put("ghost", 1.0);
        grass.put("fighting", 1.0);
        grass.put("dragon", 0.5);
        grass.put("dark", 1.0);
        grass.put("fairy", 1.0);
        grass.put("poison", 0.5);
        grass.put("psychic", 1.0);

        return grass;
    }

    public HashMap<String, Double> ground(){
        HashMap<String, Double> ground = new HashMap<String, Double>();
        ground.put("grass", 0.5);
        ground.put("fire", 2.0);
        ground.put("ground", 1.0);
        ground.put("steel", 2.0);
        ground.put("electric", 2.0);
        ground.put("water", 1.0);
        ground.put("rock", 2.0);
        ground.put("flying", 0.15);
        ground.put("ice", 1.0);
        ground.put("normal", 1.0);
        ground.put("bug", 0.5);
        ground.put("ghost", 1.0);
        ground.put("fighting", 1.0);
        ground.put("dragon", 1.0);
        ground.put("dark", 1.0);
        ground.put("fairy", 1.0);
        ground.put("poison", 2.0);
        ground.put("psychic", 1.0);

        return ground;
    }

    public HashMap<String, Double> steel(){
        HashMap<String, Double> steel = new HashMap<String, Double>();
        steel.put("grass", 1.0);
        steel.put("fire", 0.5);
        steel.put("ground", 1.0);
        steel.put("steel", 0.5);
        steel.put("electric", 0.5);
        steel.put("water", 0.5);
        steel.put("rock", 2.0);
        steel.put("flying", 1.0);
        steel.put("ice", 2.0);
        steel.put("normal", 1.0);
        steel.put("bug", 1.0);
        steel.put("ghost", 1.0);
        steel.put("fighting", 1.0);
        steel.put("dragon", 1.0);
        steel.put("dark", 1.0);
        steel.put("fairy", 2.0);
        steel.put("poison", 1.0);
        steel.put("psychic", 1.0);

        return steel;
    }

    public HashMap<String, Double> electric(){
        HashMap<String, Double> electric = new HashMap<String, Double>();
        electric.put("grass", 0.5);
        electric.put("fire", 1.0);
        electric.put("ground", 0.15);
        electric.put("steel", 1.0);
        electric.put("electric", 0.5);
        electric.put("water", 2.0);
        electric.put("rock", 1.0);
        electric.put("flying", 2.0);
        electric.put("ice", 1.0);
        electric.put("normal", 1.0);
        electric.put("bug", 1.0);
        electric.put("ghost", 1.0);
        electric.put("fighting", 1.0);
        electric.put("dragon", 0.5);
        electric.put("dark", 1.0);
        electric.put("fairy", 1.0);
        electric.put("poison", 1.0);
        electric.put("psychic", 1.0);

        return electric;
    }
    public HashMap<String, Double> water(){
        HashMap<String, Double> water = new HashMap<String, Double>();
        water.put("grass", 0.5);
        water.put("fire", 2.0);
        water.put("ground", 2.0);
        water.put("steel", 1.0);
        water.put("electric", 1.0);
        water.put("water", 0.5);
        water.put("rock", 2.0);
        water.put("flying", 1.0);
        water.put("ice", 1.0);
        water.put("normal", 1.0);
        water.put("bug", 1.0);
        water.put("ghost", 1.0);
        water.put("fighting", 1.0);
        water.put("dragon", 0.5);
        water.put("dark", 1.0);
        water.put("fairy", 1.0);
        water.put("poison", 1.0);
        water.put("psychic", 1.0);

        return water;
    }
    public HashMap<String, Double> rock(){
        HashMap<String, Double> rock = new HashMap<String, Double>();
        rock.put("grass", 1.0);
        rock.put("fire", 2.0);
        rock.put("ground", 0.5);
        rock.put("steel", 0.5);
        rock.put("electric", 1.0);
        rock.put("water", 1.0);
        rock.put("rock", 1.0);
        rock.put("flying", 2.0);
        rock.put("ice", 2.0);
        rock.put("normal", 1.0);
        rock.put("bug", 2.0);
        rock.put("ghost", 1.0);
        rock.put("fighting", 0.5);
        rock.put("dragon", 1.0);
        rock.put("dark", 1.0);
        rock.put("fairy", 1.0);
        rock.put("poison", 1.0);
        rock.put("psychic", 1.0);

        return rock;
    }
    public HashMap<String, Double> flying(){
        HashMap<String, Double> flying = new HashMap<String, Double>();
        flying.put("grass", 2.0);
        flying.put("fire", 1.0);
        flying.put("ground", 1.0);
        flying.put("steel", 0.5);
        flying.put("electric", 0.5);
        flying.put("water", 1.0);
        flying.put("rock", 0.5);
        flying.put("flying", 1.0);
        flying.put("ice", 1.0);
        flying.put("normal", 1.0);
        flying.put("bug", 2.0);
        flying.put("ghost", 1.0);
        flying.put("fighting", 2.0);
        flying.put("dragon", 1.0);
        flying.put("dark", 1.0);
        flying.put("fairy", 1.0);
        flying.put("poison", 1.0);
        flying.put("psychic", 1.0);

        return flying;
    }
    public HashMap<String, Double> ice(){
        HashMap<String, Double> ice = new HashMap<String, Double>();
        ice.put("grass", 2.0);
        ice.put("fire", 0.5);
        ice.put("ground", 2.0);
        ice.put("steel", 0.5);
        ice.put("electric", 1.0);
        ice.put("water", 0.5);
        ice.put("rock", 1.0);
        ice.put("flying", 2.0);
        ice.put("ice", 0.5);
        ice.put("normal", 1.0);
        ice.put("bug", 1.0);
        ice.put("ghost", 1.0);
        ice.put("fighting", 1.0);
        ice.put("dragon", 2.0);
        ice.put("dark", 1.0);
        ice.put("fairy", 1.0);
        ice.put("poison", 1.0);
        ice.put("psychic", 1.0);

        return ice;
    }
    public HashMap<String, Double> normal(){
        HashMap<String, Double> normal = new HashMap<String, Double>();
        normal.put("grass", 1.0);
        normal.put("fire", 1.0);
        normal.put("ground", 1.0);
        normal.put("steel", 0.5);
        normal.put("electric", 1.0);
        normal.put("water", 1.0);
        normal.put("rock", 0.5);
        normal.put("flying", 1.0);
        normal.put("ice", 1.0);
        normal.put("normal", 1.0);
        normal.put("bug", 1.0);
        normal.put("ghost", 0.15);
        normal.put("fighting", 1.0);
        normal.put("dragon", 1.0);
        normal.put("dark", 1.0);
        normal.put("fairy", 1.0);
        normal.put("poison", 1.0);
        normal.put("psychic", 1.0);

        return normal;
    }
    public HashMap<String, Double> bug(){
        HashMap<String, Double> bug = new HashMap<String, Double>();
        bug.put("grass", 2.0);
        bug.put("fire", 0.5);
        bug.put("ground", 1.0);
        bug.put("steel", 0.5);
        bug.put("electric", 1.0);
        bug.put("water", 1.0);
        bug.put("rock", 1.0);
        bug.put("flying", 0.5);
        bug.put("ice", 1.0);
        bug.put("normal", 1.0);
        bug.put("bug", 1.0);
        bug.put("ghost", 0.5);
        bug.put("fighting", 0.5);
        bug.put("dragon", 1.0);
        bug.put("dark", 2.0);
        bug.put("fairy", 0.5);
        bug.put("poison", 0.5);
        bug.put("psychic", 2.0);

        return bug;
    }
    public HashMap<String, Double> ghost(){
        HashMap<String, Double> ghost = new HashMap<String, Double>();
        ghost.put("grass", 1.0);
        ghost.put("fire", 1.0);
        ghost.put("ground", 1.0);
        ghost.put("steel", 1.0);
        ghost.put("electric", 1.0);
        ghost.put("water", 1.0);
        ghost.put("rock", 1.0);
        ghost.put("flying", 1.0);
        ghost.put("ice", 1.0);
        ghost.put("normal", 0.15);
        ghost.put("bug", 1.0);
        ghost.put("ghost", 2.0);
        ghost.put("fighting", 1.0);
        ghost.put("dragon", 1.0);
        ghost.put("dark", 0.5);
        ghost.put("fairy", 1.0);
        ghost.put("poison", 1.0);
        ghost.put("psychic", 2.0);

        return ghost;
    }
    public HashMap<String, Double> fighting(){
        HashMap<String, Double> fighting = new HashMap<String, Double>();
        fighting.put("grass", 1.0);
        fighting.put("fire", 1.0);
        fighting.put("ground", 1.0);
        fighting.put("steel", 2.0);
        fighting.put("electric", 1.0);
        fighting.put("water", 1.0);
        fighting.put("rock", 2.0);
        fighting.put("flying", 0.5);
        fighting.put("ice", 2.0);
        fighting.put("normal", 2.0);
        fighting.put("bug", 0.5);
        fighting.put("ghost", 0.15);
        fighting.put("fighting", 1.0);
        fighting.put("dragon", 1.0);
        fighting.put("dark", 2.0);
        fighting.put("fairy", 0.5);
        fighting.put("poison", 0.5);
        fighting.put("psychic", 0.5);

        return fighting;
    }
    public HashMap<String, Double> dragon(){
        HashMap<String, Double> dragon = new HashMap<String, Double>();
        dragon.put("grass", 1.0);
        dragon.put("fire", 1.0);
        dragon.put("ground", 1.0);
        dragon.put("steel", 0.5);
        dragon.put("electric", 1.0);
        dragon.put("water", 1.0);
        dragon.put("rock", 1.0);
        dragon.put("flying", 1.0);
        dragon.put("ice", 1.0);
        dragon.put("normal", 1.0);
        dragon.put("bug", 1.0);
        dragon.put("ghost", 1.0);
        dragon.put("fighting", 1.0);
        dragon.put("dragon", 2.0);
        dragon.put("dark", 1.0);
        dragon.put("fairy", 0.15);
        dragon.put("poison", 1.0);
        dragon.put("psychic", 1.0);

        return dragon;
    }
    public HashMap<String, Double> dark(){
        HashMap<String, Double> dark = new HashMap<String, Double>();
        dark.put("grass", 1.0);
        dark.put("fire", 1.0);
        dark.put("ground", 1.0);
        dark.put("steel", 1.0);
        dark.put("electric", 1.0);
        dark.put("water", 1.0);
        dark.put("rock", 1.0);
        dark.put("flying", 1.0);
        dark.put("ice", 1.0);
        dark.put("normal", 1.0);
        dark.put("bug", 1.0);
        dark.put("ghost", 2.0);
        dark.put("fighting", 0.5);
        dark.put("dragon", 1.0);
        dark.put("dark", 0.15);
        dark.put("fairy", 0.5);
        dark.put("poison", 1.0);
        dark.put("psychic", 2.0);

        return dark;
    }
    public HashMap<String, Double> fairy(){
        HashMap<String, Double> fairy = new HashMap<String, Double>();
        fairy.put("grass", 1.0);
        fairy.put("fire", 0.5);
        fairy.put("ground", 1.0);
        fairy.put("steel", 0.5);
        fairy.put("electric", 1.0);
        fairy.put("water", 1.0);
        fairy.put("rock", 1.0);
        fairy.put("flying", 1.0);
        fairy.put("ice", 1.0);
        fairy.put("normal", 1.0);
        fairy.put("bug", 1.0);
        fairy.put("ghost", 1.0);
        fairy.put("fighting", 2.0);
        fairy.put("dragon", 2.0);
        fairy.put("dark", 2.0);
        fairy.put("fairy", 1.0);
        fairy.put("poison", 0.5);
        fairy.put("psychic", 1.0);

        return fairy;
    }
    public HashMap<String, Double> poison(){
        HashMap<String, Double> poison = new HashMap<String, Double>();
        poison.put("grass", 2.0);
        poison.put("fire", 1.0);
        poison.put("ground", 0.5);
        poison.put("steel", 0.15);
        poison.put("electric", 1.0);
        poison.put("water", 1.0);
        poison.put("rock", 0.5);
        poison.put("flying", 1.0);
        poison.put("ice", 1.0);
        poison.put("normal", 1.0);
        poison.put("bug", 1.0);
        poison.put("ghost", 0.5);
        poison.put("fighting", 1.0);
        poison.put("dragon", 1.0);
        poison.put("dark", 1.0);
        poison.put("fairy", 2.0);
        poison.put("poison", 0.5);
        poison.put("psychic", 1.0);

        return poison;
    }
    public HashMap<String, Double> psychic(){
        HashMap<String, Double> psychic = new HashMap<String, Double>();
        psychic.put("grass", 1.0);
        psychic.put("fire", 1.0);
        psychic.put("ground", 1.0);
        psychic.put("steel", 0.5);
        psychic.put("electric", 1.0);
        psychic.put("water", 1.0);
        psychic.put("rock", 1.0);
        psychic.put("flying", 1.0);
        psychic.put("ice", 1.0);
        psychic.put("normal", 1.0);
        psychic.put("bug", 1.0);
        psychic.put("ghost", 1.0);
        psychic.put("fighting", 2.0);
        psychic.put("dragon", 1.0);
        psychic.put("dark", 0.15);
        psychic.put("fairy", 1.0);
        psychic.put("poison", 2.0);
        psychic.put("psychic", 0.5);

        return psychic;
    }

    public HashMap<String, HashMap> getTypeMap(String attackingType) {
        HashMap attackingTypeMap = constructor().get(attackingType);

        return attackingTypeMap;
    }

    public Double getEffectivenessValue(String attackingType, String defendingType) {
        HashMap attackingTypeMap = constructor().get(attackingType);
        Double effectiveness = (Double) attackingTypeMap.get(defendingType);
        return effectiveness;
    }

    public Double effectivenessMultiplier(Pokemon attackingPokemon, Pokemon defendingPokemon) {
        Move attackingMove = attackingPokemon.getActiveMove();
        String attackingMoveType = attackingMove.getType();
        ArrayList<String> defendingTypes = defendingPokemon.getTypes();


        //Double originalEffectivness = 1.0;
        double effectiveMultiplier = 1;

        for (String pokemonType : defendingTypes) {

            Double i = getEffectivenessValue(attackingMoveType, pokemonType);

            effectiveMultiplier = i * effectiveMultiplier;

        }

        return effectiveMultiplier;
    }
}


