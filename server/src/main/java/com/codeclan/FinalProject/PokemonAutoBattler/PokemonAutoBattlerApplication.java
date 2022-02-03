package com.codeclan.FinalProject.PokemonAutoBattler;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.services.PokemonService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@SpringBootApplication
public class PokemonAutoBattlerApplication {

	static PokemonService pokemonService;

	public static void main(String[] args) throws JSONException {
		SpringApplication.run(PokemonAutoBattlerApplication.class, args);

//		pokemonService.getPokemonObject();

//		ResponseEntity<String> response = pokemonService.getPokemon(1);
//		JSONObject JsonResponse = new JSONObject(response.getBody());
//		String moves = JsonResponse.get("moves").toString();
//		System.out.println(moves);

//		pokemonService.printMoveName(JsonResponse);

	}



}
