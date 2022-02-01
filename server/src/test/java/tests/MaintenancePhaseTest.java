package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.MaintenancePhase;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Move;
import com.codeclan.FinalProject.PokemonAutoBattler.models.Trainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaintenancePhaseTest {
    static MaintenancePhase maintenancePhase;

    static Trainer red;
    static Trainer blue;

  @BeforeAll
  static void beforeAll() {
      red = new Trainer(3000);
      blue = new Trainer(5000);

      maintenancePhase = new MaintenancePhase();
  }

  @Test
    public void hasTrainers(){
      assertEquals(0, maintenancePhase.getTrainersSize());
  }

  @Test
    public void canAddTrainers(){
      assertEquals(0, maintenancePhase.getTrainersSize());
      maintenancePhase.addTrainer(red);
      maintenancePhase.addTrainer(blue);
      assertEquals(2, maintenancePhase.getTrainersSize());

  }

}
