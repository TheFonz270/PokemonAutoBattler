package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.MoveRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping(value = "/pokemons")
    public ResponseEntity<List<Pokemon>> getAllPokemons(){
        return new ResponseEntity<>(pokemonRepository.findAll(), HttpStatus.OK);
    }
}
