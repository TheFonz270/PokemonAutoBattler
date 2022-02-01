package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChallengeTest {
    static User user;
    static Pokedex pokedex;
    static Trainer red;
    static StatTracker runTracker;
    static Challenge challenge;
    static BattlePhase battlePhase;
    static MaintenancePhase maintenancePhase;
    static Round round;


    @BeforeAll
    static void beforeAll() {
        red = new Trainer(3000);
        pokedex = new Pokedex(1, true, 20, 5000, 1257, 300, 250);
        runTracker = new StatTracker(10, 8, pokedex, 50);
        user = new User("roger@rogerland.com", "rogertmalg", "pokemon123", "image", runTracker);
        challenge = new Challenge(user, red, runTracker);
        battlePhase = new BattlePhase("VS Champion Blue");
        maintenancePhase = new MaintenancePhase();
        round = new Round(maintenancePhase, battlePhase);
    }

    @Test
    public void hasUser(){
        assertEquals(user, challenge.getUser());
    }

    @Test
    public void hasTrainer(){
        assertEquals(red, challenge.getPlayerTrainer());
    }

    @Test
    public void hasTracker(){
        assertEquals(runTracker, challenge.getRunTracker());
    }

    @Test
    public void hasRounds(){
        assertEquals(0, challenge.getRoundsSize());
    }

    @Test
    public void canAddRound(){
        assertEquals(0, challenge.getRoundsSize());
        challenge.addRound(round);
        assertEquals(1, challenge.getRoundsSize());
    }
    }

