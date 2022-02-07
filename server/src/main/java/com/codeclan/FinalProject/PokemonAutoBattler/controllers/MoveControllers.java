package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MoveControllers {

    @Autowired
    MoveRepository moveRepository;

    @GetMapping(value = "/moves")
    public ResponseEntity<List<Move>> getAllMoves(){
        return new ResponseEntity<>(moveRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/moves/{id}")
    public ResponseEntity<Optional<Move>> getMove(@PathVariable Long id){
        return new ResponseEntity<>(moveRepository.findById(id), HttpStatus.OK);
    }
}
