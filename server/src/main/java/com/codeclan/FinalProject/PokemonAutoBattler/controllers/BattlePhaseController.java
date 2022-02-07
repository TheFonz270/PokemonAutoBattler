package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.BattlePhase;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.BattlePhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BattlePhaseController {

    @Autowired
    BattlePhaseRepository battlePhaseRepository;

    @GetMapping(value = "/battles")
    public ResponseEntity<List<BattlePhase>> getAllBattles(){
        return new ResponseEntity<>(battlePhaseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/battles/{id}")
    public ResponseEntity<Optional<BattlePhase>> getBattle(@PathVariable Long id){
        return new ResponseEntity<>(battlePhaseRepository.findById(id), HttpStatus.OK);
    }
}
