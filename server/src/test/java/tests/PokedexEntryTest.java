package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.PokedexEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexEntryTest {
    static PokedexEntry pokedexEntry;

    @BeforeAll
    static void beforeAll() {
        pokedexEntry = new PokedexEntry(12, false);
    }

    @Test
    public void hasPokemonId(){
        assertEquals(12, pokedexEntry.getPokemonId());
    }

    @Test
    public void canAddPokemonId(){
        pokedexEntry.setPokemonId(443);
        assertEquals(443, pokedexEntry.getPokemonId());
    }

    @Test
    public void hasUsed(){
        assertEquals(false, pokedexEntry.isUsed());
    }

    @Test
    public void canMarkUsed(){
        pokedexEntry.markUsed();
        assertEquals(true, pokedexEntry.isUsed());
    }

    @Test
    public void hasOpponentsFainted(){
        pokedexEntry.addToOpponentsFainted(4);
        assertEquals(4, pokedexEntry.getOpponentsFainted());
    }

    @Test
    public void canSetOpponentsFainted(){
        pokedexEntry.setOpponentsFainted(6);
        assertEquals(6, pokedexEntry.getOpponentsFainted());
    }

    @Test
    public void canAddToOpponentsFainted(){
        assertEquals(0, pokedexEntry.getOpponentsFainted());
        pokedexEntry.addToOpponentsFainted(14);
        assertEquals(14, pokedexEntry.getOpponentsFainted());
    }

    @Test
    public void hasDamageDealt(){
        assertEquals(0, pokedexEntry.getDamageDealt());
    }

    @Test
    public void canAddToDamageDealt(){
        assertEquals(0, pokedexEntry.getDamageDealt());
        pokedexEntry.addToDamageDealt(400);
        assertEquals(400, pokedexEntry.getDamageDealt());

    }

    @Test
    public void hasDamageTaken(){
        assertEquals(0, pokedexEntry.getDamageTaken());
    }

    @Test
    public void canAddToDamageTaken(){
        assertEquals(0, pokedexEntry.getDamageTaken());
        pokedexEntry.addToDamageTaken(600);
        assertEquals(600, pokedexEntry.getDamageTaken());
    }

    @Test
    public void hasAttacksUsed(){
        assertEquals(0, pokedexEntry.getAttacksUsed());
    }

    @Test
    public void canAddToAttacksUsed(){
        assertEquals(0, pokedexEntry.getAttacksUsed());
        pokedexEntry.addToAttacksUsed(10);
        assertEquals(10, pokedexEntry.getAttacksUsed());
    }

    @Test
    public void hasAttacksReceived(){
        assertEquals(0, pokedexEntry.getAttacksReceived());
    }

    @Test
    public void canAddToAttacksRecieved(){
        assertEquals(0, pokedexEntry.getAttacksReceived());
        pokedexEntry.addToAttacksRecieved(22);
        assertEquals(22, pokedexEntry.getAttacksReceived());
    }

}
