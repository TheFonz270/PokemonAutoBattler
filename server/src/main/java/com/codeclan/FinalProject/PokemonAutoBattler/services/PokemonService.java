//package com.codeclan.FinalProject.PokemonAutoBattler.services;
//
//import com.codeclan.FinalProject.PokemonAutoBattler.models.DamageType;
//import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
//import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
//import com.codeclan.FinalProject.PokemonAutoBattler.models.Types;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//public class PokemonService {
//
//
//    public static ResponseEntity<String> getPokemon(int id) {
//        ResponseEntity<String> responseJson = null;
//        try {
//            final String resourceUrl = "https://pokeapi.co/api/v2/pokemon/" + id;
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("user-agent", "Application");
//            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return responseJson;
//    };
//
//    public static Pokemon getPokemonObject() throws JSONException {
//        int id = 1;
//
//        ResponseEntity<String> result = getPokemon(id);
//        String jsonString = result.getBody();
//        JSONObject jsonObject = new JSONObject(jsonString);
//
//        //get pokemon name
//        String name = jsonObject.get("name").toString();
//
//
//        //get avatar image
//        JSONObject sprites = new JSONObject(jsonObject.get("sprites").toString());
//        JSONObject other = new JSONObject(sprites.get("other").toString());
//        JSONObject home = new JSONObject(other.get("home").toString());
//        String avatarImg = home.get("front_default").toString();
//
//        //get can evolve
//        JSONObject species = new JSONObject(jsonObject.get("species").toString());
//        String speciesUrl = species.get("url").toString();
//        String evolutionChainUrl = getEvolutionChainUrl(speciesUrl);
//        boolean canEvolve = checkEvolutionChain(evolutionChainUrl);
//
//        //get move
//        List movePool = getMovePool(jsonObject);
//        ResponseEntity<String> moveResponse = getMove(movePool);
//        Move activeMove = getMoveObject(moveResponse);
//
//
//        Pokemon pokemon = new Pokemon(name, avatarImg, activeMove, canEvolve);
//        System.out.println(pokemon.getName());
//        System.out.println(pokemon.getAvatarImage());
//        System.out.println(pokemon.getActiveMove());
//        return pokemon;
//    }
//
//    public static String getEvolutionChainUrl(String  url) throws JSONException {
//        ResponseEntity<String> responseJson = null;
//        try {
//            final String resourceUrl = url;
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("user-agent", "Application");
//            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        String jsonString = responseJson.getBody();
//        JSONObject jsonObject = new JSONObject(jsonString);
//        JSONObject evolutionChain = new JSONObject(jsonObject.get("evolution_chain").toString());
//        String evolutionChainUrl = evolutionChain.get("url").toString();
//        return evolutionChainUrl;
//    };
//
//    public static boolean checkEvolutionChain(String  url) throws JSONException {
//        ResponseEntity<String> responseJson = null;
//        try {
//            final String resourceUrl = url;
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("user-agent", "Application");
//            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        String jsonString = responseJson.getBody();
//        JSONObject jsonObject = new JSONObject(jsonString);
//        JSONObject chain = new JSONObject(jsonObject.get("chain").toString());
//        List evolvesTo = Collections.singletonList(chain.get("evolves_to").toString());
//        if (evolvesTo.size() != 0) {
//            return true;
//        }
//        return false;
//    };
//
//    public static List<String> getMovePool(JSONObject jsonObject) throws JSONException {
////        List moves = Collections.singletonList(jsonObject.get("moves").toString());
//        JSONObject moves = jsonObject.getJSONObject("moves");
//        JSONObject move = moves.getJSONObject("move");
//        String moveName = move.get("name").toString();
//        List movePool = new ArrayList();
//
//        movePool.add(moveName);
//
////        for (Object move : moves) {
////            JSONObject jsonMove = new JSONObject(move.toString());
////            JSONObject jsonMoveMove = new JSONObject(jsonMove.get("move").toString());
////            String moveName = jsonMoveMove.get("name").toString();
////            movePool.add(moveName);
////        }
//        return movePool;
//    };
//
//    public static ResponseEntity<String> getMove(List<String> movePool) {
//        Random r = new Random();
//        int randomItem = r.nextInt(movePool.size());
//        String randomMoveName = movePool.get(randomItem);
//
//        ResponseEntity<String> responseJson = null;
//        try {
//            final String resourceUrl = "https://pokeapi.co/api/v2/move/" + randomMoveName;
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("user-agent", "Application");
//            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return responseJson;
//    };
//
//    public static Move getMoveObject(ResponseEntity<String> responseMove) throws JSONException {
//
//        HashMap<String , Types> typesConverter = new HashMap<>();
//        typesConverter.put("normal", Types.NORMAL);
//        typesConverter.put("fire", Types.FIRE);
//        typesConverter.put("water", Types.WATER);
//        typesConverter.put("electric", Types.ELECTRIC);
//        typesConverter.put("grass", Types.GRASS);
//        typesConverter.put("ice", Types.ICE);
//        typesConverter.put("fighting", Types.FIGHTING);
//        typesConverter.put("poison", Types.POISON);
//        typesConverter.put("ground", Types.GROUND);
//        typesConverter.put("flying", Types.FLYING);
//        typesConverter.put("psychic", Types.PSYCHIC);
//        typesConverter.put("bug", Types.BUG);
//        typesConverter.put("rock", Types.ROCK);
//        typesConverter.put("ghost", Types.GHOST);
//        typesConverter.put("dragon", Types.DRAGON);
//        typesConverter.put("dark", Types.DARK);
//        typesConverter.put("steel", Types.STEEL);
//        typesConverter.put("fairy", Types.FAIRY);
//
//        HashMap<String, DamageType> damageTypeConverter = new HashMap<>();
//        damageTypeConverter.put("physical", DamageType.PHYSICAL);
//        damageTypeConverter.put("special", DamageType.SPECIAL);
//
//        //turn responseEntity into jsonObject
//        String jsonStringMove = responseMove.getBody();
//        JSONObject jsonMove = new JSONObject(jsonStringMove);
//
//        // get moveName from JsonObject
//        String moveName = jsonMove.get("name").toString();
//
//        //Get move type from jsonObject
//        JSONObject jsonType = new JSONObject(jsonMove.get("type").toString());
//        String typeName = jsonType.get("name").toString();
//        Types moveType = typesConverter.get(typeName);
//
//        //Get damage type from jsonObject
//        JSONObject jsonDamageClass = new JSONObject(jsonMove.get("damage_class").toString());
//        String damageClassName = jsonDamageClass.get("name").toString();
//        DamageType moveDamageType = damageTypeConverter.get(damageClassName);
//
//        //Get move damage power
//
//        int moveDamage = Integer.parseInt(jsonMove.get("power").toString());
//
//        Move activeMove = new Move(moveName, moveType, moveDamageType, moveDamage);
//        return activeMove;
//
//    }
//
//    public static String printMoveName(JSONObject jsonObject) throws JSONException {
//        JSONObject moves = jsonObject.getJSONObject("moves");
//        JSONObject move = moves.getJSONObject("move");
//        String moveName = move.get("name").toString();
//        System.out.println(moveName);
//        return moveName;
//
//    };
//
//
//
//
//
//
//
//
//}
