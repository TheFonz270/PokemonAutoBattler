package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokedex;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexTest {
    static Pokedex pokedex;

    @BeforeAll
    static void beforeAll() {
        pokedex = new Pokedex(12, false, 4, 700, 200, 27, 12);
    }

    @Test
    public void hasPokemonId(){
        assertEquals(12, pokedex.getPokemonId());
    }

    @Test
    public void canAddPokemonId(){
        pokedex.setPokemonId(443);
        assertEquals(443, pokedex.getPokemonId());
    }

    @Test
    public void hasUsed(){
        assertEquals(false, pokedex.isUsed());
    }

    @Test
    public void canMarkUsed(){
        pokedex.markUsed();
        assertEquals(true, pokedex.isUsed());
    }

    @Test
    public void hasOpponentsFainted(){
        assertEquals(4, pokedex.getOpponentsFainted());
    }

    @Test
    public void canSetOpponentsFainted(){
        pokedex.setOpponentsFainted(6);
        assertEquals(6, pokedex.getOpponentsFainted());
    }

    @Test
    public void canAddToOpponentsFainted(){
        assertEquals(4, pokedex.getOpponentsFainted());
        pokedex.addToOpponentsFainted(10);
        assertEquals(14, pokedex.getOpponentsFainted());
    }

    @Test
    public void hasDamageDealt(){
        assertEquals(700, pokedex.getDamageDealt());
    }

    @Test
    public void canAddToDamageDealt(){
        assertEquals(700, pokedex.getDamageDealt());
        pokedex.addToDamageDealt(400);
        assertEquals(1100, pokedex.getDamageDealt());

    }

    @Test
    public void hasDamageTaken(){
        assertEquals(200, pokedex.getDamageTaken());
    }

    @Test
    public void canAddToDamageTaken(){
        assertEquals(200, pokedex.getDamageTaken());
        pokedex.addToDamageTaken(600);
        assertEquals(800, pokedex.getDamageTaken());
    }

    @Test
    public void hasAttacksUsed(){
        assertEquals(27, pokedex.getAttacksUsed());
    }

    @Test
    public void canAddToAttacksUsed(){
        assertEquals(27, pokedex.getAttacksUsed());
        pokedex.addToAttacksUsed(10);
        assertEquals(37, pokedex.getAttacksUsed());
    }

    @Test
    public void hasAttacksReceived(){
        assertEquals(12, pokedex.getAttacksReceived());
    }

    @Test
    public void canAddToAttacksRecieved(){
        assertEquals(12, pokedex.getAttacksReceived());
        pokedex.addToAttacksRecieved(10);
        assertEquals(22, pokedex.getAttacksReceived());
    }

}


//
//public class Pokedex {
//    private int PokemonId;
//
//    private boolean used;
//
//    private int opponentsFainted;
//
//    private long damageDealt;
//
//    private long damageTaken;
//
//    private int attacksUsed;
//
//    private int attacksReceived;
//
//    public Pokedex(int pokemonId, boolean used, int opponentsFainted, long damageDealt, long damageTaken, int attacksUsed, int attacksReceived) {
//        PokemonId = pokemonId;
//        this.used = used;
//        this.opponentsFainted = opponentsFainted;
//        this.damageDealt = damageDealt;
//        this.damageTaken = damageTaken;
//        this.attacksUsed = attacksUsed;
//        this.attacksReceived = attacksReceived;
//    }