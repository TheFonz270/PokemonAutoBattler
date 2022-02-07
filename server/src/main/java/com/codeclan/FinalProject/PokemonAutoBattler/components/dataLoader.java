package com.codeclan.FinalProject.PokemonAutoBattler.components;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.*;
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

    @Autowired
    BattlePhaseRepository battlePhaseRepository;

    @Autowired
    BattleScriptRepository battleScriptRepository;

    @Autowired
    TurnScriptRepository turnScriptRepository;


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

        Pokemon pokemon4 = pokemonService.getOnePokemon();
        moveRepository.save(pokemon4.getActiveMove());
        pokemonRepository.save(pokemon4);

        Pokemon pokemon5 = pokemonService.getOnePokemon();
        moveRepository.save(pokemon5.getActiveMove());
        pokemonRepository.save(pokemon5);

        Pokemon pokemon6 = pokemonService.getOnePokemon();
        moveRepository.save(pokemon6.getActiveMove());
        pokemonRepository.save(pokemon6);

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

        Trainer trainer2 = new Trainer(0, "avatar.png");
        ArrayList<Pokemon> pokemonsPC = new ArrayList<>();
        pokemonsPC.add(pokemon4);
        pokemonsPC.add(pokemon5);
        pokemonsPC.add(pokemon6);
        trainer2.setPokemons(pokemonsPC);
        trainerRepository.save(trainer2);
        pokemon4.setTrainer(trainer2);
        pokemon5.setTrainer(trainer2);
        pokemon6.setTrainer(trainer2);
        pokemonRepository.save(pokemon4);
        pokemonRepository.save(pokemon5);
        pokemonRepository.save(pokemon6);

        ArrayList<Trainer> trainers = new ArrayList<>();
        trainers.add(trainer1);
        trainers.add(trainer2);

        BattlePhase battlePhase = new BattlePhase("theme", trainers);
        BattleScript battleScript = battlePhase.getBattleScript();
        ArrayList<TurnScript> scripts = new ArrayList<>();
        TurnScript turn1 = new TurnScript(true, 1, 10, false,
                0, 15, false, false, false,
                false, false);
        turnScriptRepository.save(turn1);
        TurnScript turn2 = new TurnScript(true, 1, 10, false,
                0, 15, false, false, false,
                false, false);
        turnScriptRepository.save(turn2);
        TurnScript turn3 = new TurnScript(true, 1, 10, false,
                0, 15, false, false, false,
                false, false);
        turnScriptRepository.save(turn3);
        scripts.add(turn1);
        scripts.add(turn2);
        scripts.add(turn3);
        battleScript.setScript(scripts);
        battleScriptRepository.save(battleScript);
        battlePhaseRepository.save(battlePhase);
        battleScript.setBattlePhase(battlePhase);
        battleScriptRepository.save(battleScript);
        trainer1.setBattlePhase(battlePhase);
        trainer2.setBattlePhase(battlePhase);
        trainer1.setBattleScript(battleScript);
        trainer2.setBattleScript(battleScript);
        trainerRepository.save(trainer1);
        trainerRepository.save(trainer2);
        turn1.setBattleScript(battleScript);
        turn2.setBattleScript(battleScript);
        turn3.setBattleScript(battleScript);
        turnScriptRepository.save(turn1);
        turnScriptRepository.save(turn2);
        turnScriptRepository.save(turn3);




     }
}
