package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokedex;
import com.codeclan.FinalProject.PokemonAutoBattler.models.PokedexEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexTest {
    static Pokedex pokedex;
    static PokedexEntry pokedexEntry1;
    static PokedexEntry pokedexEntry2;

    @BeforeAll
    static void beforeAll() {
        pokedexEntry1 = new PokedexEntry(12, false);
        pokedexEntry2 = new PokedexEntry(13, false);
        pokedex = new Pokedex();
    }

    @Test
    public void hasDex(){
        assertEquals(0, pokedex.getPokedexSize());
    }

    @Test
    public void canAddPokemon(){
        assertEquals(0, pokedex.getPokedexSize());
        pokedex.addPokedexEntry(pokedexEntry1);
        assertEquals(1, pokedex.getPokedexSize());
    }

    @Test
    public void canCheckDexDuplicate(){
        assertEquals(0, pokedex.getPokedexSize());
        pokedex.addOrUpdateDex(pokedexEntry2);
        pokedex.addOrUpdateDex(pokedexEntry1);
        pokedex.addOrUpdateDex(pokedexEntry1);
        pokedex.addOrUpdateDex(pokedexEntry1);
        assertEquals(2, pokedex.getPokedexSize());
    }
}
