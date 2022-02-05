package com.codeclan.FinalProject.PokemonAutoBattler.repositories;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {
}
