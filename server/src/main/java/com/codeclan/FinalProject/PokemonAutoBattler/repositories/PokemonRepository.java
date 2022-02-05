package com.codeclan.FinalProject.PokemonAutoBattler.repositories;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
