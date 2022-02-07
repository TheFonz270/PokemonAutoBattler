package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.BattleScript;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.BattleScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BattleScriptController {

    @Autowired
    BattleScriptRepository battleScriptRepository;

    @GetMapping(value = "/battlescripts")
    public ResponseEntity<List<BattleScript>> getAllBattleScripts(){
        return new ResponseEntity<>(battleScriptRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/battlescripts/{id}")
    public ResponseEntity<Optional<BattleScript>> getBattleScript(@PathVariable Long id){
        return new ResponseEntity<>(battleScriptRepository.findById(id), HttpStatus.OK);
    }
}
