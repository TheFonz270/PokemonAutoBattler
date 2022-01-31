package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.BattlePhase;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Trainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattlePhaseTest {

    static BattlePhase battlePhase;

    static Trainer red;
    static Trainer blue;

    @BeforeAll
    static void beforeAll() {
        red = new Trainer(3000);
        blue = new Trainer(5000);

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

}
