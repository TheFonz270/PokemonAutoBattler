package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.MoveRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.PokemonRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.services.PokemonService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    MoveRepository moveRepository;

    PokemonService pokemonService;

    @GetMapping(value = "/pokemons")
    public ResponseEntity<List<Pokemon>> getAllPokemons(){
        return new ResponseEntity<>(pokemonRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/pokemons/{id}")
    public ResponseEntity<Optional<Pokemon>> getPokemon(@PathVariable Long id){
        return new ResponseEntity<>(pokemonRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/pokemons")
    public ResponseEntity<Pokemon> postPokemon() throws JSONException {

        Pokemon newPoke = pokemonService.getOnePokemon();
        moveRepository.save(newPoke.getActiveMove());
        pokemonRepository.save(newPoke);
        return new ResponseEntity<>(newPoke, HttpStatus.CREATED);
    }

    @PutMapping(value = "/pokemons/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable Long id) throws JSONException {
        Pokemon oldPokemon = pokemonRepository.findById(id).get();
        Pokemon newPokemon = pokemonService.getOnePokemon();
        Move activeMove = newPokemon.getActiveMove();
        moveRepository.save(activeMove);
        pokemonService.updatePokemon(oldPokemon, newPokemon);
        pokemonRepository.save(oldPokemon);
        return new ResponseEntity<>(oldPokemon, HttpStatus.OK);
    }

    @PutMapping(value = "/pokemons/{id}/move")
    public ResponseEntity<Pokemon> updatePokemonMove(@PathVariable Long id) throws JSONException {
        Pokemon pokemon = pokemonRepository.findById(id).get();
        ArrayList<String> movePool = pokemon.getMovePool();
        Move activeMove = pokemonService.getMoveObject(movePool);
        moveRepository.save(activeMove);
        pokemon.setActiveMove(activeMove);
        pokemonRepository.save(pokemon);
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @PutMapping(value = "/pokemons/{id}/levelup")
    public ResponseEntity<Pokemon> levelUpPokemon(@PathVariable Long id) throws JSONException {
        Pokemon pokemon = pokemonRepository.findById(id).get();
        pokemon.increaseLevel();
        pokemonRepository.save(pokemon);
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @DeleteMapping(value = "/pokemons/{id}")
    public ResponseEntity<Long> deletePokemon(@PathVariable Long id){
        pokemonRepository.delete(pokemonRepository.findById(id).get());
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
