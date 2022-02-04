package tests;

import com.codeclan.FinalProject.PokemonAutoBattler.models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.font.Script;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleScriptTest {

    static TurnScript turnScript;
    static Move fire_punch;
    static Move water_pulse;

    static Pokemon quilava;
    static Pokemon swinub;
    static Pokemon gyarados;
    static Pokemon honedge;
    static Pokemon raichu;
    static Pokemon kangaskhan;

    static Trainer red;
    static Trainer blue;

    static BattleScript battleScript;

    @BeforeAll
    static void beforeAll(){
        fire_punch = new Move("Fire Punch", Types.FIRE, DamageType.PHYSICAL, 75);
        water_pulse = new Move("Water Pulse", Types.WATER, DamageType.SPECIAL, 60);

        quilava = new Pokemon(159,"Quilava", "quilava.png", fire_punch, 58,64,58,80,65,90);
        honedge = new Pokemon(657, "Honedge", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);
        swinub = new Pokemon(159,"Swinub", "quilava.png", fire_punch, 58,64,58,80,65,90);
        raichu = new Pokemon(657, "Raichu", "honedge.png", water_pulse, 45, 80, 100,35, 37,28);
        gyarados = new Pokemon(159,"Gyarados", "quilava.png", fire_punch, 58,64,58,80,65,90);
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
        turnScript = new TurnScript(red, blue);
        battleScript = new BattleScript(red, blue);
    }


    @Test
    public void canGetTurnScriptsSize(){
        battleScript.addTurnScript(turnScript);
    assertEquals(1, battleScript.getTurnScriptsSize());
    }

    @Test
    public void canPlayGame(){
        quilava.faint();
        quilava.faint();
        quilava.faint();
        System.out.println(battleScript.checkWinner(red, blue, turnScript));
        assertEquals(blue, battleScript.checkWinner(red, blue, turnScript));
    }

    @Test
    public void canPlayGame2(){
        honedge.faint();
        honedge.faint();
        honedge.faint();
        System.out.println(battleScript.checkWinner(red, blue, turnScript));
        assertEquals(red, battleScript.checkWinner(red, blue, turnScript));
    }



    @Test
    public void canPlayWholeBattle(){

        assertEquals(red, battleScript.playWholeBattle(red,blue, turnScript));
//        assertEquals(4, battleScript.getTurnScriptsSize());
    }

}
