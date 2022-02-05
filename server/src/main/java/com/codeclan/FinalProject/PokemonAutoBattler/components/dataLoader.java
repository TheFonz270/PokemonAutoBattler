package com.codeclan.FinalProject.PokemonAutoBattler.components;

import com.codeclan.FinalProject.PokemonAutoBattler.models.DamageType;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Trainer;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.MoveRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.PokemonRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.TrainerRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.services.PokemonService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class dataLoader implements ApplicationRunner {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    MoveRepository moveRepository;

    @Autowired
    TrainerRepository trainerRepository;


    static PokemonService pokemonService;

    public dataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws JSONException {


       Pokemon pokemon1 = pokemonService.getOnePokemon();
       moveRepository.save(pokemon1.getActiveMove());
       pokemonRepository.save(pokemon1);

        Pokemon pokemon2 = pokemonService.getOnePokemon();
        moveRepository.save(pokemon2.getActiveMove());
        pokemonRepository.save(pokemon2);

        Pokemon pokemon3 = pokemonService.getOnePokemon();
        moveRepository.save(pokemon3.getActiveMove());
        pokemonRepository.save(pokemon3);

        Trainer trainer1 = new Trainer(0, "avatar.png");
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        pokemons.add(pokemon3);
        trainer1.setPokemons(pokemons);
        trainerRepository.save(trainer1);
        pokemon1.setTrainer(trainer1);
        pokemon2.setTrainer(trainer1);
        pokemon3.setTrainer(trainer1);
        pokemonRepository.save(pokemon1);
        pokemonRepository.save(pokemon2);
        pokemonRepository.save(pokemon3);
    }
}
