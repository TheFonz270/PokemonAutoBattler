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
        fire_punch = new Move("Fire Punch", "fire", DamageType.PHYSICAL, 90);
        water_pulse = new Move("Water Pulse", "water", DamageType.SPECIAL, 120);

        quilava = new Pokemon(159,"Quilava", "quilava.png", fire_punch, 58,64,58,80,65,90);
        honedge = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);

        red = new Trainer(3000, "red.png");
        blue = new Trainer(5000, "blue.png");
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


