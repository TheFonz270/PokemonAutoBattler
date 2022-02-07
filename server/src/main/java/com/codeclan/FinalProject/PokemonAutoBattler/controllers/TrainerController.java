package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Trainer;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {

    @Autowired
    TrainerRepository trainerRepository;

    @GetMapping(value = "/trainers")
    public ResponseEntity<List<Trainer>> getAllTrainers(){
        return new ResponseEntity<>(trainerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/trainers/{id}")
    public ResponseEntity<Optional<Trainer>> getTrainer(@PathVariable Long id){
        return new ResponseEntity<>(trainerRepository.findById(id), HttpStatus.OK);
    }

}
