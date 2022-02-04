package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.DamageType;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Types;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {

    static Move fire_punch;

    static Move water_pulse;


    @BeforeAll
    static void beforeAll() {

        fire_punch = new Move("Fire Punch", "fire", DamageType.PHYSICAL, 90);
        water_pulse= new Move("Water Pulse", "water", DamageType.SPECIAL, 120);
    }

    @Test
    public void moveHasName(){
        assertEquals(fire_punch.getName(), "Fire Punch");
        assertEquals(water_pulse.getName(), "Water Pulse");
    }

    @Test
    public void moveHasType(){
        assertEquals(fire_punch.getType(), Types.FIRE);
        assertEquals(water_pulse.getType(), Types.WATER);
    }

    @Test
    public void moveHasDamageType(){
        assertEquals(fire_punch.getDamageType(), DamageType.PHYSICAL);
        assertEquals(water_pulse.getDamageType(), DamageType.SPECIAL);
    }

    @Test
    public void moveHasDamage(){
        assertEquals(fire_punch.getDamage(), 90);
        assertEquals(water_pulse.getDamage(), 120);
    }


}
