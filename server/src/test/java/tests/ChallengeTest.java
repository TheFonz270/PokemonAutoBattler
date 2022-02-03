package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.SqlMergeMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChallengeTest {

    static Pokedex pokedex;
    static Pokedex rundex;
    static PokedexEntry pokedexEntry1;
    static PokedexEntry pokedexEntry2;
    static PokedexEntry pokedexEntry3;
    static Trainer red;
    static RunTracker runTracker;
    static Challenge challenge;
    static BattlePhase battlePhase;
    static MaintenancePhase maintenancePhase;
    static Round round;
    static StatTracker statTracker1;
    static User user;


    @BeforeAll
    static void beforeAll() {
        pokedex = new Pokedex();
        rundex = new Pokedex();
        pokedexEntry3 = new PokedexEntry(4, true);
        pokedexEntry2 = new PokedexEntry(3, true);
        pokedexEntry1 = new PokedexEntry(1, true);
        battlePhase = new BattlePhase("VS Champion Blue");
        maintenancePhase = new MaintenancePhase();
        round = new Round(maintenancePhase, battlePhase);
        statTracker1 = new StatTracker(3,6, pokedex,5);
        user = new User("roger@rogerland.com", "rogertmalg", "pokemon123", "image", statTracker1);
        runTracker = new RunTracker(10, 8, rundex, 50);
        red = new Trainer(3000, "red.png");
        challenge = new Challenge(user, red, runTracker);



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

    @Test
    public void canMergeStattrackerRuntrackerLosses(){
        assertEquals(6, user.getStatTracker().getLosses());
        assertEquals(8, challenge.getRunTracker().getLosses());
        challenge.mergeStattrackerRuntracker(user, runTracker);
        assertEquals(14, user.getStatTracker().getLosses());
    }

    @Test
    public void canMergeStattrackerRuntrackerWins(){
        assertEquals(3, user.getStatTracker().getWins());
        assertEquals(10, challenge.getRunTracker().getWins());
        challenge.mergeStattrackerRuntracker(user, runTracker);
        assertEquals(13, user.getStatTracker().getWins());
    }

    @Test
    public void canMerageStattrackerRuntrackerPokedex(){
        assertEquals(0, pokedex.getPokedexSize());
        assertEquals(0, pokedex.getPokedexSize());
        pokedex.addPokedexEntry(pokedexEntry1);
        pokedex.addPokedexEntry(pokedexEntry2);
        rundex.addPokedexEntry(pokedexEntry1);
        rundex.addPokedexEntry(pokedexEntry3);
        assertEquals(2, pokedex.getPokedexSize());
        assertEquals(2, pokedex.getPokedexSize());
        challenge.mergeStattrackerRuntracker(user, runTracker);
        assertEquals(3, pokedex.getPokedexSize());
    }

    @Test
    public void canMergeStattrackerRuntrackerCaught(){
        assertEquals(5, user.getStatTracker().getPokemonCaught());
        assertEquals(50, challenge.getRunTracker().getPokemonCaught());
        challenge.mergeStattrackerRuntracker(user, runTracker);
        assertEquals(55, user.getStatTracker().getPokemonCaught());
    }
    }

