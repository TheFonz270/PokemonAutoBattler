package com.codeclan.FinalProject.PokemonAutoBattler.repositories;

import com.codeclan.FinalProject.PokemonAutoBattler.models.BattlePhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattlePhaseRepository extends JpaRepository<BattlePhase, Long> {
}
