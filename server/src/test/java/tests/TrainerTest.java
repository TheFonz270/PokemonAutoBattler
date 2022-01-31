package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    static Move fire_punch;
    static Move water_pulse;

    static Pokemon quilava;
    static Pokemon honedge;

    static Trainer red;
    static Trainer blue;

    @BeforeAll
    static void beforeAll() {
        fire_punch = new Move("Fire Punch", Types.FIRE, DamageType.PHYSICAL, 90);
        water_pulse = new Move("Water Pulse", Types.WATER, DamageType.SPECIAL, 120);

        quilava = new Pokemon("Quilava", "quilava.png", fire_punch, true, 120);
        honedge = new Pokemon("Honedge", "honedge.png", water_pulse, false, 90);

        red = new Trainer(3000);
        blue = new Trainer(5000);
    }

    @Test
    public void trainerHasPokedollars(){
        assertEquals(3000, red.getPokedollars());
        assertEquals(5000, blue.getPokedollars());
    }

    @Test
    public void canSubtractPokedollars(){
        assertEquals(3000, red.getPokedollars());
        assertEquals(5000, blue.getPokedollars());
        red.minusPokedollars(2000);
        blue.minusPokedollars(3000);
        assertEquals(1000, red.getPokedollars());
        assertEquals(2000, blue.getPokedollars());
    }

    @Test
    public void canAddPokedollars(){
        assertEquals(3000, red.getPokedollars());
        assertEquals(5000, blue.getPokedollars());
        red.addPokedollars(2000);
        blue.addPokedollars(3000);
        assertEquals(5000, red.getPokedollars());
        assertEquals(8000, blue.getPokedollars());
    }

    @Test
    public void hasPokemons(){
        assertEquals(0, red.getPokemonsSize());
        assertEquals(0, blue.getPokemonsSize());
    }

    @Test
    public void canAddPokemon(){
        assertEquals(0, red.getPokemonsSize());
        assertEquals(0, blue.getPokemonsSize());
        red.addPokemon(quilava);
        blue.addPokemon(quilava);
        blue.addPokemon(honedge);
        assertEquals(1, red.getPokemonsSize());
        assertEquals(2, blue.getPokemonsSize());
    }





}


