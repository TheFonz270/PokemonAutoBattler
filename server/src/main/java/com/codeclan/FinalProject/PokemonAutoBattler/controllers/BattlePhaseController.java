package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.BattlePhaseRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.BattleScriptRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.TrainerRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.TurnScriptRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.services.PokemonService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BattlePhaseController {

    @Autowired
    BattlePhaseRepository battlePhaseRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    TurnScriptRepository turnScriptRepository;

    @Autowired
    BattleScriptRepository battleScriptRepository;

    @GetMapping(value = "/battles")
    public ResponseEntity<List<BattlePhase>> getAllBattles(){
        return new ResponseEntity<>(battlePhaseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/battles/{id}")
    public ResponseEntity<Optional<BattlePhase>> getBattle(@PathVariable Long id){
        return new ResponseEntity<>(battlePhaseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/battles/{idt}")
    public ResponseEntity<BattlePhase> postBattlePhase(@PathVariable Long idt) throws JSONException {
        ArrayList<Trainer> trainers = new ArrayList<>();
        trainers.add(trainerRepository.findById(idt).get());
        trainers.add(trainerRepository.findById(idt + 1).get());
        BattlePhase battlePhase = new BattlePhase("theme", trainers);
        BattleScript battleScript = battlePhase.playWholeBattle(trainers);
        battlePhase.setBattleScript(battleScript);
        ArrayList<TurnScript> script = new ArrayList<>();
        for (TurnScript turnScript : battleScript.getScript()){
            script.add(turnScript);
            turnScriptRepository.save(turnScript);
        }
        battleScript.setScript(script);
        battleScriptRepository.save(battleScript);
        battlePhaseRepository.save(battlePhase);
        battleScript.setBattlePhase(battlePhase);
        battleScriptRepository.save(battleScript);
        for (Trainer trainer : trainers){
            trainer.setBattleScript(battleScript);
            trainer.setBattlePhase(battlePhase);
            trainerRepository.save(trainer);
        }

        for (TurnScript turnScript : battleScript.getScript()){
            turnScript.setBattleScript(battleScript);
            turnScriptRepository.save(turnScript);
        }

        return new ResponseEntity<>(battlePhase, HttpStatus.CREATED);
    }
}
