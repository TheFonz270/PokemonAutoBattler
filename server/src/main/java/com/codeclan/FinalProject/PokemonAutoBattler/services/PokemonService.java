package com.codeclan.FinalProject.PokemonAutoBattler.services;

import com.codeclan.FinalProject.PokemonAutoBattler.models.DamageType;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Types;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class PokemonService {


    public static ResponseEntity<String> getPokemon(int id) {
        ResponseEntity<String> responseJson = null;
        try {
            final String resourceUrl = "https://pokeapi.co/api/v2/pokemon/" + id;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("user-agent", "Application");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseJson;
    };

    public static Pokemon getPokemonObject(int pokeId) throws JSONException {
        int id = pokeId;

        ResponseEntity<String> result = getPokemon(id);
        String jsonString = result.getBody();
        JSONObject jsonObject = new JSONObject(jsonString);

        //get pokemon name
        String name = jsonObject.get("name").toString();


        //get avatar image
        JSONObject sprites = new JSONObject(jsonObject.get("sprites").toString());
        JSONObject other = new JSONObject(sprites.get("other").toString());
        JSONObject home = new JSONObject(other.get("home").toString());
        String avatarImg = home.get("front_default").toString();

        // get pokemon types

        ArrayList<String> types = getPokemonTypes(jsonObject);


        //get can evolve
        JSONObject species = new JSONObject(jsonObject.get("species").toString());
        String speciesUrl = species.get("url").toString();
        String evolutionChainUrl = getEvolutionChainUrl(speciesUrl);
        boolean canEvolve = checkEvolutionChain(evolutionChainUrl);

        //get move
        ArrayList<String> movePool = getMovePool(jsonObject);
        Move activeMove = getMoveObject(movePool);

        //get Stats
        ArrayList<Integer> stats = getStats(jsonObject);

        int hp = stats.get(0);
        int atk = stats.get(1);
        int def = stats.get(2);
        int spAtk = stats.get(3);
        int spDef = stats.get(4);
        int speed = stats.get(5);


        Pokemon pokemon = new Pokemon(id, name, avatarImg, activeMove, hp, atk, def, spAtk, spDef, speed);
        pokemon.setMovePool(movePool);
        pokemon.setTypes(types);
        pokemon.setCanEvolve(canEvolve);
        pokemon.setEffectiveStats(pokemon.calculateEffectiveStats());
        return pokemon;
    }

    public static String getEvolutionChainUrl(String  url) throws JSONException {
        ResponseEntity<String> responseJson = null;
        try {
            final String resourceUrl = url;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("user-agent", "Application");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String jsonString = responseJson.getBody();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject evolutionChain = new JSONObject(jsonObject.get("evolution_chain").toString());
        String evolutionChainUrl = evolutionChain.get("url").toString();
        return evolutionChainUrl;
    };

    public static boolean checkEvolutionChain(String  url) throws JSONException {
        ResponseEntity<String> responseJson = null;
        try {
            final String resourceUrl = url;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("user-agent", "Application");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String jsonString = responseJson.getBody();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject chain = new JSONObject(jsonObject.get("chain").toString());
        String evolvesTo = chain.get("evolves_to").toString();
        JSONArray evolvesToArray = new JSONArray(evolvesTo);
        if (evolvesToArray.length() != 0) {
            return true;
        }
        return false;
    };

    public static ArrayList<String> getMovePool(JSONObject jsonObject) throws JSONException {

        String moves = jsonObject.get("moves").toString();
        JSONArray jsonArray = new JSONArray(moves);
        ArrayList movePool = new ArrayList<String>();

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject movesObject = jsonArray.getJSONObject(i);
            JSONObject move = movesObject.getJSONObject("move");
            String moveName = move.get("name").toString();
            movePool.add(moveName);
        }
        return movePool;
    };

    public static ResponseEntity<String> getMove(ArrayList<String> movePool) {
        Random r = new Random();
        int randomItem = r.nextInt(movePool.size());
        String randomMoveName = movePool.get(randomItem);

        ResponseEntity<String> responseJson = null;
        try {
            final String resourceUrl = "https://pokeapi.co/api/v2/move/" + randomMoveName;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("user-agent", "Application");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseJson;
    };

    public static Move getMoveObject(ArrayList<String> movePool) throws JSONException {

        ResponseEntity<String> responseMove = getMove(movePool);

        HashMap<String, DamageType> damageTypeConverter = new HashMap<>();
        damageTypeConverter.put("physical", DamageType.PHYSICAL);
        damageTypeConverter.put("special", DamageType.SPECIAL);

        //turn responseEntity into jsonObject
        String jsonStringMove = responseMove.getBody();
        JSONObject jsonMove = new JSONObject(jsonStringMove);

        // get moveName from JsonObject
        String moveName = jsonMove.get("name").toString();

        //Get move type from jsonObject
        JSONObject jsonType = new JSONObject(jsonMove.get("type").toString());
        String moveType = jsonType.get("name").toString();

        //Get damage type from jsonObject
        JSONObject jsonDamageClass = new JSONObject(jsonMove.get("damage_class").toString());
        String damageClassName = jsonDamageClass.get("name").toString();
        DamageType moveDamageType = damageTypeConverter.get(damageClassName);

        //Get move damage power

        int moveDamage = 0;

        if (jsonMove.get("power").toString() != "null"){
            moveDamage = Integer.parseInt(jsonMove.get("power").toString());
        } else {
            return getMoveObject(movePool);
        }

        Move activeMove = new Move(moveName, moveType, moveDamageType, moveDamage);
        return activeMove;

    }

    public static ArrayList<Integer> getStats(JSONObject jsonObject) throws JSONException {

        String stats = jsonObject.get("stats").toString();
        JSONArray jsonArray = new JSONArray(stats);
        ArrayList<Integer> statsPool = new ArrayList<Integer>();

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject statsObject = jsonArray.getJSONObject(i);
            String statValue = statsObject.getString("base_stat");
            statsPool.add(Integer.valueOf(statValue));
        }
        return statsPool;
    };

    public static ArrayList<String> getPokemonTypes(JSONObject jsonObject) throws JSONException {

        String typesJson = jsonObject.get("types").toString();
        JSONArray jsonArray = new JSONArray(typesJson);
        ArrayList types = new ArrayList<String>();

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject typesObject = jsonArray.getJSONObject(i);
            JSONObject type = typesObject.getJSONObject("type");
            String typeName = type.get("name").toString();
            types.add(typeName);
        }
        return types;
    };

    public static Pokemon getOnePokemon() throws JSONException {

        Random r = new Random();
        ArrayList<Integer> excludedIDs = new ArrayList<>(Arrays.asList(132, 235, 202, 291, 290, 292));
        int randomItem = r.nextInt( 807) + 1;
        if (excludedIDs.contains(randomItem)) {
            return getOnePokemon();
        }
        Pokemon pokemon = getPokemonObject(randomItem);
        return pokemon;
    }

    public static ArrayList<Pokemon> getSixPokemon() throws JSONException {

        Random r = new Random();
		ArrayList<Integer> excludedIDs = new ArrayList<>(Arrays.asList(132, 235, 202, 291, 290, 292));
		ArrayList<Integer> randomIDs = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			int randomItem = r.nextInt( 807) + 1;
			if (excludedIDs.contains(randomItem)){
				i--;
			} else {
				randomIDs.add(randomItem);
				excludedIDs.add(randomItem);
			}
		}

        ArrayList<Pokemon> sixPokemon = new ArrayList<>();
        for (int pokeId : randomIDs){
            Pokemon newPokemon = getPokemonObject(pokeId);
            sixPokemon.add(newPokemon);
        }

        return sixPokemon;
    }










}

