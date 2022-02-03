package com.codeclan.FinalProject.PokemonAutoBattler;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.services.PokemonService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class PokemonAutoBattlerApplication {

	static PokemonService pokemonService;

	public static void main(String[] args) throws JSONException {
		SpringApplication.run(PokemonAutoBattlerApplication.class, args);

//		Pokemon pokemon = pokemonService.getOnePokemon();
//		System.out.println("id - " + pokemon.getPokemonId());
//		System.out.println("name - " + pokemon.getName());
//		System.out.println("avatar - " + pokemon.getAvatarImage());
//		System.out.println("move pool - " +pokemon.getMovePool());
//		System.out.println("activeMove - " + pokemon.getActiveMove());
//		System.out.println("hp - " + pokemon.getHP());
//		System.out.println("atk - " + pokemon.getAtk());
//		System.out.println("def - " + pokemon.getDef());
//		System.out.println("spAtk - " + pokemon.getSpAtk());
//		System.out.println("spDef - " + pokemon.getSpDef());
//		System.out.println("Speed - " + pokemon.getSpeed());

//		ResponseEntity<String> result = pokemonService.getPokemon(1);
//		String jsonString = result.getBody();
//		JSONObject jsonObject = new JSONObject(jsonString);
//
//		ArrayList<String> types = pokemonService.getPokemonTypes(jsonObject);
//		System.out.println(types);

		ArrayList<Pokemon> sixPokemon = pokemonService.getSixPokemon();
		for (Pokemon pokemon : sixPokemon) {
			System.out.println(pokemon.getName());
		}

	}

}
