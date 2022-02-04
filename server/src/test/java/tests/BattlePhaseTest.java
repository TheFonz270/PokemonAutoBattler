package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattlePhaseTest {
    static Move fire_punch;

    static Move water_pulse;

    static Pokemon quilava;

    static Pokemon honedge;


    static BattlePhase battlePhase;

    static Trainer red;
    static Trainer blue;



    @BeforeAll
    static void beforeAll() {
        red = new Trainer(3000, "red.png");
        blue = new Trainer(5000, "blue.png");

        fire_punch = new Move("Fire Punch", Types.FIRE, DamageType.PHYSICAL, 90);
        water_pulse = new Move("Water Pulse", Types.WATER, DamageType.SPECIAL, 120);



        quilava = new Pokemon(159,"Quilava", "quilava.png", fire_punch, 58,64,58,80,65,90);
        honedge = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);

        quilava.calculateEffectiveStats();
        honedge.calculateEffectiveStats();

        quilava.addType(Types.FIRE);
        honedge.addType(Types.GHOST);
        honedge.addType(Types.STEEL);

        battlePhase = new BattlePhase("VS Champion Blue");
    }

    @Test
    public void hasTrainers(){
        assertEquals(0, battlePhase.getTrainersSize());
    }

    @Test
    public void canAddTrainers(){
        assertEquals(0, battlePhase.getTrainersSize());
        battlePhase.addTrainer(red);
        battlePhase.addTrainer(blue);
        assertEquals(2, battlePhase.getTrainersSize());

    }

    @Test
    public void hasTheme(){
        assertEquals("VS Champion Blue", battlePhase.getTheme());
    }

    @Test
    public void canSetTheme(){
        battlePhase.setTheme("VS Champion Lance");
        assertEquals("VS Champion Lance", battlePhase.getTheme());
    }

    @Test
    public void canDamageCalculation(){
        assertEquals(27, battlePhase.damageCalculation(quilava, honedge));
    }

    @Test
    public void canDamageCalculation2(){
        assertEquals(23, battlePhase.damageCalculation(honedge, quilava));
    }

}
