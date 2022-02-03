package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {

    static Move fire_punch;

    static Move water_pulse;

    static Pokemon quilava;

    static Pokemon honedge;

    @BeforeAll
    static void beforeAll() {
        fire_punch = new Move("Fire Punch", Types.FIRE, DamageType.PHYSICAL, 90);
        water_pulse = new Move("Water Pulse", Types.WATER, DamageType.SPECIAL, 120);



        quilava = new Pokemon(159,"Quilava", "quilava.png", fire_punch, 58,64,58,80,65,90);
        honedge = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);
    }


    @Test
    public void pokemonHasName(){
        assertEquals("Quilava", quilava.getName());
        assertEquals("Honedge", honedge.getName());
    }

    @Test
    public void pokemonHasAvatar(){
        assertEquals("quilava.png", quilava.getAvatarImage());
        assertEquals("honedge.png", honedge.getAvatarImage());
    }

    @Test
    public void pokemonHasMove(){
        assertEquals(fire_punch, quilava.getActiveMove());
        assertEquals(water_pulse, honedge.getActiveMove());
    }

    @Test
    public void pokemonHasMovepool(){
        quilava.addToMovePool(fire_punch);
        quilava.addToMovePool(water_pulse);
        assertEquals(2, quilava.getMovePoolSize());
        honedge.addToMovePool(water_pulse);
        assertEquals(1, honedge.getMovePoolSize());
    }

    @Test
    public void pokemonCanEvolve(){
        assertEquals(false, quilava.canEvolve());
        assertEquals(false, honedge.canEvolve());
    }

    @Test
    public void pokemonHasCurrentHP(){
        quilava.calculateEffectiveStats();
        honedge.calculateEffectiveStats();
        assertEquals(46, quilava.getCurrentHP());
        assertEquals(42, honedge.getCurrentHP());
    }

    @Test
    public void pokemonCanReduceHP(){
        quilava.calculateEffectiveStats();
        honedge.calculateEffectiveStats();
        quilava.reduceHP(20);
        assertEquals(26, quilava.getCurrentHP());
        honedge.reduceHP(10);
        assertEquals(32, honedge.getCurrentHP());
    }

    @Test
    public void pokemonHasIsFainted(){
        assertEquals(false, quilava.getIsFainted());
        assertEquals(false, honedge.getIsFainted());
    }

    @Test
    public void pokemonCanFaint(){
        quilava.faint();
        honedge.faint();
        assertEquals(true, quilava.getIsFainted());
        assertEquals(true, honedge.getIsFainted());
    }

    @Test
    public void pokemonCanKnockedOut(){
        quilava.calculateEffectiveStats();
        honedge.calculateEffectiveStats();
        assertEquals(false, quilava.getIsFainted());
        assertEquals(false, honedge.getIsFainted());
        quilava.takeDamage(20);
        honedge.takeDamage(20);
        assertEquals(false, quilava.getIsFainted());
        assertEquals(false, honedge.getIsFainted());
        quilava.takeDamage(110);
        honedge.takeDamage(110);
        assertEquals(true, quilava.getIsFainted());
        assertEquals(true, honedge.getIsFainted());
    }

    @Test
    public void pokemonHasStarLevel(){
        assertEquals(StarLevel.ONE_STAR, quilava.getLevel());
        assertEquals(StarLevel.ONE_STAR, honedge.getLevel());
    }

    @Test
    public void pokemonHasLevel(){
        assertEquals(17, quilava.getLevelLevel());
        quilava.increaseLevel();
        assertEquals(34, quilava.getLevelLevel());
    }

    @Test
    public void pokemonCanIncreaseStarLevel(){
        assertEquals(StarLevel.ONE_STAR, quilava.getLevel());
        assertEquals(StarLevel.ONE_STAR, honedge.getLevel());
        honedge.increaseLevel();
        quilava.increaseLevel();
        assertEquals(StarLevel.TWO_STARS, quilava.getLevel());
        assertEquals(StarLevel.TWO_STARS, honedge.getLevel());
        honedge.increaseLevel();
        quilava.increaseLevel();
        assertEquals(StarLevel.THREE_STARS, quilava.getLevel());
        assertEquals(StarLevel.THREE_STARS, honedge.getLevel());
        honedge.increaseLevel();
        quilava.increaseLevel();
        assertEquals(StarLevel.THREE_STARS, quilava.getLevel());
        assertEquals(StarLevel.THREE_STARS, honedge.getLevel());
    }

    @Test
    public void pokemonCanLearnNewMove(){
        quilava.learnMove(water_pulse);
        assertEquals(water_pulse, quilava.getActiveMove());
        honedge.learnMove(fire_punch);
        assertEquals(fire_punch, honedge.getActiveMove());
    }


    @Test
    public void canGetBaseStats()
    {
        assertEquals(58, quilava.getHP());
        assertEquals(64, quilava.getAtk());
        assertEquals(58, quilava.getDef());
        assertEquals(80, quilava.getSpAtk());
        assertEquals(65, quilava.getSpDef());
        assertEquals(90, quilava.getSpeed());
    }

    @Test
    public void canCalculateEffectiveStats()
    {
        quilava.calculateEffectiveStats();
        assertEquals(46, quilava.getEffectiveHP());
        assertEquals(26, quilava.getEffectiveAtk());
        assertEquals(24, quilava.getEffectiveDef());
        assertEquals(32, quilava.getEffectiveSpAtk());
        assertEquals(27, quilava.getEffectiveSpDef());
        assertEquals(35, quilava.getEffectiveSpeed());
    }

    @Test
    public void canGetStab(){
        quilava.addType(Types.FIRE);
        assertEquals(1.5, quilava.getStab());
    }


}

