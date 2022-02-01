package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokedex;
import com.codeclan.FinalProject.PokemonAutoBattler.models.StatTracker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatTrackerTest {


static Pokedex pokedex;

static StatTracker statTracker;

@BeforeAll
    static void beforeAll(){
    pokedex = new Pokedex(1, true, 20, 5000,1257, 300, 250);
    statTracker = new StatTracker(10, 8, pokedex, 50);
}

@Test
    public void hasWins(){
    assertEquals(10, statTracker.getWins());
}

    @Test
    public void canIncreaseWins(){
    assertEquals(10, statTracker.getWins());
    statTracker.increaseWins();
        assertEquals(11, statTracker.getWins());
    }

    @Test
    public void hasLosses(){
        assertEquals(8, statTracker.getLosses());
    }

    @Test
    public void canIncreaseLosses(){
        assertEquals(8, statTracker.getLosses());
        statTracker.increaseLosses();
        assertEquals(9, statTracker.getLosses());
    }

    @Test
    public void hasPokedex(){
    assertEquals(pokedex, statTracker.getPokedex());
    }

//    @Test
//    public void canCountPokedex(){
//    assertEquals(50, statTracker.getPokedexSize());
//    }






//    private int wins;
//
//    private int losses;
//
//    private Pokedex pokedex;
//
//    private int pokemonCaught;
//
//    public StatTracker(int wins, int losses, Pokedex pokedex, int pokemonCaught) {
//        this.wins = wins;
//        this.losses = losses;
//        this.pokedex = pokedex;
//        this.pokemonCaught = pokemonCaught;
//    }
}
