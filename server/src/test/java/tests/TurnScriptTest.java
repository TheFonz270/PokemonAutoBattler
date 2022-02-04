package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnScriptTest {

    static TurnScript turnScript;
    static Move fire_punch;
    static Move water_pulse;

    static Pokemon quilava1;
    static Pokemon quilava2;
    static Pokemon quilava3;
    static Pokemon honedge1;
    static Pokemon honedge2;
    static Pokemon honedge3;

    static Trainer red;
    static Trainer blue;

    @BeforeAll
    static void beforeAll(){
        fire_punch = new Move("Fire Punch", Types.FIRE, DamageType.PHYSICAL, 75);
        water_pulse = new Move("Water Pulse", Types.WATER, DamageType.SPECIAL, 60);

        quilava1 = new Pokemon(159,"Quilava", "quilava.png", fire_punch, 58,64,58,80,65,90);
        honedge1 = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);
        quilava2 = new Pokemon(159,"Quilava", "quilava.png", fire_punch, 58,64,58,80,65,90);
        honedge2 = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);
        quilava3 = new Pokemon(159,"Quilava", "quilava.png", fire_punch, 58,64,58,80,65,90);
        honedge3 = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);

        red = new Trainer(3000, "red.png");
        blue = new Trainer(5000, "blue.png");

        blue.addPokemon(honedge1);
        blue.addPokemon(honedge2);
        blue.addPokemon(honedge3);
        red.addPokemon(quilava1);
        red.addPokemon(quilava2);
        red.addPokemon(quilava3);
        quilava1.calculateEffectiveStats();
        quilava2.calculateEffectiveStats();
        quilava3.calculateEffectiveStats();
        honedge1.calculateEffectiveStats();
        honedge2.calculateEffectiveStats();
        honedge3.calculateEffectiveStats();
        turnScript = new TurnScript(red, blue);
    }

    @Test
    public void canPlayerFirst(){
        assertEquals(true, turnScript.playerFirst(red, blue));
        assertEquals(false, turnScript.playerFirst(blue, red));
    }

    @Test
    public void canSetP1(){
        assertEquals(red, turnScript.setP1(red, blue));
        assertEquals(red, turnScript.setP1(blue, red));
    }

    @Test
    public void canSetP2(){
        assertEquals(blue, turnScript.setP2(red, blue));
        assertEquals(blue, turnScript.setP2(blue, red));
    }

    @Test
    public void canSetActivePokemon(){
        assertEquals(quilava1, turnScript.setActivePokemon(red));
        assertEquals(honedge1, turnScript.setActivePokemon(blue));
        quilava1.faint();
        assertEquals(quilava2, turnScript.setActivePokemon(red));
        quilava2.faint();
        assertEquals(quilava3, turnScript.setActivePokemon(red));
    }

    @Test
    public void canSetP1ActivePokemon(){
        assertEquals(quilava1, turnScript.setP1ActivePokemon(red));
        assertEquals(honedge1, turnScript.setP1ActivePokemon(blue));
        quilava1.faint();
        assertEquals(quilava2, turnScript.setP1ActivePokemon(red));
        quilava2.faint();
        assertEquals(quilava3, turnScript.setP1ActivePokemon(red));
        quilava3.faint();
        assertEquals(null, turnScript.setP1ActivePokemon(red));
    }

    @Test
    public void canSetP2ActivePokemon(){
        assertEquals(quilava1, turnScript.setP2ActivePokemon(red));
        assertEquals(honedge1, turnScript.setP2ActivePokemon(blue));
        quilava1.faint();
        assertEquals(quilava2, turnScript.setP2ActivePokemon(red));
        quilava2.faint();
        assertEquals(quilava3, turnScript.setP2ActivePokemon(red));
    }

    @Test
    public void p1CanDealDamage(){
        Pokemon p1 = turnScript.setP1ActivePokemon(red);
        Pokemon p2 = turnScript.setP2ActivePokemon(blue);
        assertEquals(42, p2.getCurrentHP());
        turnScript.p1dealDamage(p1, p2);
        assertEquals(27, p2.getCurrentHP());
    }

    @Test
    public void p2CanDealDamage(){
        Pokemon p1 = turnScript.setP1ActivePokemon(red);
        Pokemon p2 = turnScript.setP2ActivePokemon(blue);
        assertEquals(46, p1.getCurrentHP());
        turnScript.p2dealDamage(p1, p2);
        assertEquals(33, p1.getCurrentHP());
    }

    @Test
    public void p1CanFaint(){
        Pokemon p1ActivePokemon = turnScript.setP1ActivePokemon(red);
        Pokemon p2ActivePokemon = turnScript.setP2ActivePokemon(blue);
        assertEquals(46, turnScript.getCurrentHPP1(p1ActivePokemon));
        turnScript.p2dealDamage(p1ActivePokemon, p2ActivePokemon);
        turnScript.p2dealDamage(p1ActivePokemon, p2ActivePokemon);
        turnScript.p2dealDamage(p1ActivePokemon, p2ActivePokemon);
        turnScript.p2dealDamage(p1ActivePokemon, p2ActivePokemon);
        assertEquals(0, p1ActivePokemon.getCurrentHP());
        assertEquals(true, turnScript.checkDidP1Faint(p1ActivePokemon));
    }

    @Test
    public void p2CanFaint(){
        Pokemon p1ActivePokemon = turnScript.setP1ActivePokemon(red);
        Pokemon p2ActivePokemon = turnScript.setP2ActivePokemon(blue);
        assertEquals(42, turnScript.getCurrentHPP2(p2ActivePokemon));
        turnScript.p1dealDamage(p1ActivePokemon, p2ActivePokemon);
        turnScript.p1dealDamage(p1ActivePokemon, p2ActivePokemon);
        turnScript.p1dealDamage(p1ActivePokemon, p2ActivePokemon);
        turnScript.p1dealDamage(p1ActivePokemon, p2ActivePokemon);
        assertEquals(0, turnScript.getCurrentHPP2(p2ActivePokemon));
        assertEquals(true, turnScript.checkDidP2Faint(p2ActivePokemon));
    }

    @Test
    public void canPlayTurnP1(){
//        turnScript.playTurnP1(red, blue);
        assertEquals(false,turnScript.playTurnP1(red, blue));
    }

    @Test
    public void canPlayTurnP2(){
        assertEquals(false,turnScript.playTurnP2(red, blue));
    }

//    @Test
//    public void canPlayWholeTurn(){
//        assertEquals("It's player 2's turn now!", turnScript.playWholeTurn(red, blue));
//    }


}
