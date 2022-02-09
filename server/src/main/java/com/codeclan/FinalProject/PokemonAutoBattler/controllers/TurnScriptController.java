package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.TurnScript;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.TurnScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TurnScriptController {

    @Autowired
    TurnScriptRepository turnScriptRepository;

    @GetMapping(value = "/scripts")
    public ResponseEntity<List<TurnScript>> getAllTurnScripts(){
        return new ResponseEntity<>(turnScriptRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/scripts/{id}")
    public ResponseEntity<Optional<TurnScript>> getScript(@PathVariable Long id){
        return new ResponseEntity<>(turnScriptRepository.findById(id), HttpStatus.OK);
    }
}
