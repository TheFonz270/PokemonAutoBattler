package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Trainer;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.MoveRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.PokemonRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.TrainerRepository;
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
public class TrainerController {

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    MoveRepository moveRepository;

    static PokemonService pokemonService;

    @GetMapping(value = "/trainers")
    public ResponseEntity<List<Trainer>> getAllTrainers(){
        return new ResponseEntity<>(trainerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/trainers/{id}")
    public ResponseEntity<Optional<Trainer>> getTrainer(@PathVariable Long id){
        return new ResponseEntity<>(trainerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/trainers")
    public ResponseEntity<ArrayList<Trainer>> postTrainers() throws JSONException {
        ArrayList<Trainer> trainers = new ArrayList<>();
        Trainer playerTrainer = pokemonService.makePlayerTrainer();
        Trainer aiTrainer = pokemonService.makeAITrainer();
        List<Pokemon> playerPokemons = playerTrainer.getPokemons();
        List<Pokemon> aiPokemons = aiTrainer.getPokemons();
        for (Pokemon pokemon : playerPokemons){
            Move move = pokemon.getActiveMove();
            moveRepository.save(move);
            pokemonRepository.save(pokemon);
        }
        for (Pokemon pokemon : aiPokemons){
            Move move = pokemon.getActiveMove();
            moveRepository.save(move);
            pokemonRepository.save(pokemon);
        }
        trainerRepository.save(playerTrainer);
        trainerRepository.save(aiTrainer);
        for (Pokemon pokemon : playerPokemons){
            pokemon.setTrainer(playerTrainer);
            pokemonRepository.save(pokemon);
        }
        for (Pokemon pokemon : aiPokemons){
            pokemon.setTrainer(aiTrainer);
            pokemonRepository.save(pokemon);
        }
        trainers.add(playerTrainer);
        trainers.add(aiTrainer);
        return new ResponseEntity<>(trainers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/trainers/{id}")
    public ResponseEntity<Trainer> updateTrainerPokemon(@PathVariable Long id, @RequestBody List<Long> Ids) throws JSONException {
        Trainer trainer = trainerRepository.findById(id).get();
        List<Pokemon> pokemons = trainer.getPokemons();
        for (Pokemon pokemon : pokemons){
            if (!Ids.contains(pokemon.getId())){
                pokemonRepository.delete(pokemon);
                moveRepository.delete(pokemon.getActiveMove());
            }
        }
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

}
