package com.codeclan.FinalProject.PokemonAutoBattler.components;

import com.codeclan.FinalProject.PokemonAutoBattler.models.DamageType;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.MoveRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.repositories.PokemonRepository;
import com.codeclan.FinalProject.PokemonAutoBattler.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class dataLoader implements ApplicationRunner {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    MoveRepository moveRepository;

//    @Autowired
//    PokemonService pokemonService;

    public dataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) {

       Move fire_punch = new Move("Fire Punch", "fire", DamageType.PHYSICAL, 90);
       moveRepository.save(fire_punch);
       Move water_pulse = new Move("Water Pulse", "water", DamageType.SPECIAL, 120);
       moveRepository.save(water_pulse);

       Pokemon quilava = new Pokemon(159,"Quilava", "quilava.png", fire_punch, 58,64,58,80,65,90);
       pokemonRepository.save(quilava);
       Pokemon honedge = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);
       pokemonRepository.save(honedge);
    }
}
