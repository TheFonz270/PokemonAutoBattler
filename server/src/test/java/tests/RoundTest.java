package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.BattlePhase;
import com.codeclan.FinalProject.PokemonAutoBattler.models.MaintenancePhase;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Round;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.opto.Phase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundTest {
    static BattlePhase battlePhase;
    static MaintenancePhase maintenancePhase;
    static Round round;

    @BeforeAll
    static void beforeAll(){
        battlePhase = new BattlePhase("VS Champion Blue");
        maintenancePhase = new MaintenancePhase();
        round = new Round(maintenancePhase, battlePhase);
    }

    @Test
    public void hasMaintenancePhase(){
        assertEquals(maintenancePhase, round.getMaintenancePhase());
    }

    @Test
    public void hasBattlePhase(){
        assertEquals(battlePhase, round.getBattlePhase());
    }
}
