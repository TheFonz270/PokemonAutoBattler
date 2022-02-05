package com.codeclan.FinalProject.PokemonAutoBattler.repositories;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
