//package tests;
//
//import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class PokemonTest {
//
//    static Move fire_punch;
//
//    static Move water_pulse;
//
//    static Pokemon quilava;
//
//    static Pokemon honedge;
//
//    @BeforeAll
//    static void beforeAll() {
//        fire_punch = new Move("Fire Punch", Types.FIRE, DamageType.PHYSICAL, 90);
//        water_pulse = new Move("Water Pulse", Types.WATER, DamageType.SPECIAL, 120);
//
//        quilava = new Pokemon("Quilava", "quilava.png", fire_punch, true);
//        honedge = new Pokemon("Honedge", "honedge.png", water_pulse, false);
//    }
//
//    @Test
//    public void pokemonHasName(){
//        assertEquals("Quilava", quilava.getName());
//        assertEquals("Honedge", honedge.getName());
//    }
//
//    @Test
//    public void pokemonHasAvatar(){
//        assertEquals("quilava.png", quilava.getAvatarImage());
//        assertEquals("honedge.png", honedge.getAvatarImage());
//    }
//
//    @Test
//    public void pokemonHasMove(){
//        assertEquals(fire_punch, quilava.getActiveMove());
//        assertEquals(water_pulse, honedge.getActiveMove());
//    }
//
//    @Test
//    public void pokemonHasMovepool(){
//        quilava.addToMovePool(fire_punch);
//        quilava.addToMovePool(water_pulse);
//        assertEquals(2, quilava.getMovePoolSize());
//        honedge.addToMovePool(water_pulse);
//        assertEquals(1, honedge.getMovePoolSize());
//    }
//
//    @Test
//    public void pokemonCanEvolve(){
//        assertEquals(true, quilava.canEvolve());
//        assertEquals(false, honedge.canEvolve());
//    }
//
//    @Test
//    public void pokemonHasCurrentHP(){
//        assertEquals(120, quilava.getCurrentHP());
//        assertEquals(90, honedge.getCurrentHP());
//    }
//
//    @Test
//    public void pokemonCanReduceHP(){
//        quilava.reduceHP(20);
//        assertEquals(100, quilava.getCurrentHP());
//        honedge.reduceHP(10);
//        assertEquals(80, honedge.getCurrentHP());
//    }
//
//    @Test
//    public void pokemonHasIsFainted(){
//        assertEquals(false, quilava.isFainted());
//        assertEquals(false, honedge.isFainted());
//    }
//
//    @Test
//    public void pokemonCanFaint(){
//        quilava.faint();
//        honedge.faint();
//        assertEquals(true, quilava.isFainted());
//        assertEquals(true, honedge.isFainted());
//    }
//
//    @Test
//    public void pokemonCanKnockedOut(){
//        assertEquals(false, quilava.isFainted());
//        assertEquals(false, honedge.isFainted());
//        quilava.takeDamage(110);
//        honedge.takeDamage(80);
//        assertEquals(false, quilava.isFainted());
//        assertEquals(false, honedge.isFainted());
//        quilava.takeDamage(20);
//        honedge.takeDamage(20);
//        assertEquals(true, quilava.isFainted());
//        assertEquals(true, honedge.isFainted());
//    }
//
//    @Test
//    public void pokemonHasStarLevel(){
//        assertEquals(StarLevel.ONE_STAR, quilava.getLevel());
//        assertEquals(StarLevel.ONE_STAR, honedge.getLevel());
//    }
//
//    @Test
//    public void pokemonCanIncreaseStarLevel(){
//        assertEquals(StarLevel.ONE_STAR, quilava.getLevel());
//        assertEquals(StarLevel.ONE_STAR, honedge.getLevel());
//        honedge.increaseLevel();
//        quilava.increaseLevel();
//        assertEquals(StarLevel.TWO_STARS, quilava.getLevel());
//        assertEquals(StarLevel.TWO_STARS, honedge.getLevel());
//        honedge.increaseLevel();
//        quilava.increaseLevel();
//        assertEquals(StarLevel.THREE_STARS, quilava.getLevel());
//        assertEquals(StarLevel.THREE_STARS, honedge.getLevel());
//        honedge.increaseLevel();
//        quilava.increaseLevel();
//        assertEquals(StarLevel.THREE_STARS, quilava.getLevel());
//        assertEquals(StarLevel.THREE_STARS, honedge.getLevel());
//    }
//
//    @Test
//    public void pokemonCanLearnNewMove(){
//        quilava.learnMove(water_pulse);
//        assertEquals(water_pulse, quilava.getActiveMove());
//        honedge.learnMove(fire_punch);
//        assertEquals(fire_punch, honedge.getActiveMove());
//    }
//
//
////        this.baseStats = new HashMap<>();
////        this.effectiveStats = new HashMap<>();
//
//
//}
