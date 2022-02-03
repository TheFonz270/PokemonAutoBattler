package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokedex;
import com.codeclan.FinalProject.PokemonAutoBattler.models.PokedexEntry;
import com.codeclan.FinalProject.PokemonAutoBattler.models.StatTracker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatTrackerTest {


    static Pokedex pokedex;

    static StatTracker statTracker;

    static PokedexEntry pokedexEntry;

    @BeforeAll
    static void beforeAll() {
        pokedex = new Pokedex();
        pokedexEntry = new PokedexEntry(1, true);
        statTracker = new StatTracker(10, 8, pokedex, 50);
    }

    @Test
    public void hasWins() {
        assertEquals(10, statTracker.getWins());
    }

    @Test
    public void canIncreaseWins() {
        assertEquals(10, statTracker.getWins());
        statTracker.increaseWins(1);
        assertEquals(11, statTracker.getWins());
    }

    @Test
    public void hasLosses() {
        assertEquals(8, statTracker.getLosses());
    }

    @Test
    public void canIncreaseLosses() {
        assertEquals(8, statTracker.getLosses());
        statTracker.increaseLosses(1);
        assertEquals(9, statTracker.getLosses());
    }

    @Test
    public void hasPokedex() {
        assertEquals(pokedex, statTracker.getPokedex());
    }
}