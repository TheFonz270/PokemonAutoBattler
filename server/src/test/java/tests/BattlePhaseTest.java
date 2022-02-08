package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattlePhaseTest {
    static EffectivenessChart effectivenessChart;
    static Move fire_punch;

    static Move water_pulse;

    static Pokemon quilava;
    static Pokemon honedge;
    static Pokemon swinub;
    static Pokemon gyarados;
    static Pokemon raichu;
    static Pokemon kangaskhan;

    static ArrayList<Trainer> trainers;


    static BattlePhase battlePhase;

    static Trainer red;
    static Trainer blue;
    static TurnScript turnScript;
    static BattleScript battleScript;



    @BeforeAll
    static void beforeAll() {
        fire_punch = new Move("Fire Punch", "fire", DamageType.PHYSICAL, 75);
        water_pulse = new Move("Water Pulse", "water", DamageType.SPECIAL, 60);

        quilava = new Pokemon(159,"QuilavaAI", "quilava.png", fire_punch, 58,64,58,80,65,90);
        honedge = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);
        swinub = new Pokemon(159,"Swinub", "quilava.png", fire_punch, 58,64,58,80,65,90);
        raichu = new Pokemon(657, "RaichuAI", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);
        gyarados = new Pokemon(159,"GyaradosAI", "quilava.png", fire_punch, 58,64,58,80,65,90);
        kangaskhan = new Pokemon(657, "Kangaskhan", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);

        red = new Trainer(3000, "red.png");
        blue = new Trainer(5000, "blue.png");

        blue.addPokemon(quilava);
        red.addPokemon(swinub);
        blue.addPokemon(gyarados);
        red.addPokemon(honedge);
        blue.addPokemon(raichu);
        red.addPokemon(kangaskhan);
        quilava.calculateEffectiveStats();
        honedge.calculateEffectiveStats();
        swinub.calculateEffectiveStats();
        raichu.calculateEffectiveStats();
        gyarados.calculateEffectiveStats();
        kangaskhan.calculateEffectiveStats();
        quilava.addType("fire");
        swinub.addType("ground");
        swinub.addType("ice");
        gyarados.addType("water");
        gyarados.addType("flying");
        honedge.addType("steel");
        honedge.addType("ghost");
        raichu.addType("electric");
        kangaskhan.addType("normal");
        trainers = new ArrayList<Trainer>();
        trainers.add(red);
        trainers.add(blue);
        battleScript = new BattleScript(trainers);
        battlePhase = new BattlePhase("VS Champion Blue", trainers);
        effectivenessChart = new EffectivenessChart();


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
        assertEquals(13, battlePhase.damageCalculation(honedge, quilava));
    }

    @Test
    public void canPlayWholeBattle(){
        assertEquals(10, battlePhase.playWholeBattle(trainers).getScriptSize());
    }

//    @Test
//    public void canGetTypeEffectiveness(){
//        assertEquals(2, battlePhase.getTypeEffectiveness(quilava, honedge));
//    }

    @Test
    public void canGetChart(){
        System.out.println(effectivenessChart.constructor());

    }

    @Test
    public void canGetTypeMap(){
//        assertEquals("steel", effectivenessChart.getTypeMap("steel"));
    }

    @Test public void canGetEffectivenessValue(){
        assertEquals(2.0, effectivenessChart.getEffectivenessValue("steel", "fairy"));
        assertEquals(0.5, effectivenessChart.getEffectivenessValue("dragon", "steel"));
    }

    @Test
    public void geteffectivenessMultiplier(){
        assertEquals(2.0, effectivenessChart.effectivenessMultiplier(quilava, honedge) );
    }





}
