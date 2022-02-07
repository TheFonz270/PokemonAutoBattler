package com.codeclan.FinalProject.PokemonAutoBattler.repositories;

import com.codeclan.FinalProject.PokemonAutoBattler.models.TurnScript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnScriptRepository extends JpaRepository<TurnScript, Long> {
}
