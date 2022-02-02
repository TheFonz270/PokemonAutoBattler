import React, {useState, useEffect} from 'react';
import TrainerArea from './TrainerArea';
import TrainerArea2 from './TrainerArea2';

const Arena = () => {
    const [Pokemon1State, setPokemon1State] = useState("normal");
    const [ActivePokemon1State, setActivePokemon1State] = useState(null);
    const [Pokemon1MAXHP, setPokemon1MAXHP] = useState(100);
    const [Pokemon1HP, setPokemon1HP] = useState(100);
    const [Pokemon2State, setPokemon2State] = useState("normal");
    const [ActivePokemon2State, setActivePokemon2State] = useState(null);
    const [Pokemon2MAXHP, setPokemon2MAXHP] = useState(100);
    const [Pokemon2HP, setPokemon2HP] = useState(100);


    const fire_punch = {
        name : "Fire Punch",
        type : "Fire",
        DamageType : "Physical",
        Damage : 75
    }

    const iron_head = {
        name : "Iron Head",
        type : "Steel",
        DamageType : "Physical",
        Damage : 80
    }

    const quilava = {
        pokemonId : 159,
        name : "quilava",
        AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/156.png",
        ActiveMove : fire_punch,
        level : 17,
        canEvolve : true,
        currentHp : 120,
        types : ["Fire"],
        isFainted : false

    }

    const honedge = {
        pokemonId : 679,
        name : "honedge",
        AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/679.png",
        ActiveMove : iron_head,
        level : 17,
        canEvolve : true,
        currentHp : 100,
        types : ["Ghost", "Steel"],
        isFainted : false

    }

    const trainer1 = {
        team : [quilava, honedge],
        avatar : "/img/PokemonTrainer.png",
        pokeDollars : 10
    }

    const trainer2 = {
        team : [honedge, quilava],
        avatar : "/img/VStrainers/Youngster.png",
        pokeDollars : 10
    }

    const BattleScript = {
        trainers : [trainer1, trainer2],
        script : [{
            playerFirst : 1,
            firstDamageDealt : 23,
            P2CurrentHP: 77,
            didP2Faint : 0,
            secondDamageDealt : 18,
            P1CurrentHP: 102,
            didP1Faint : 0,
            didP2NewMon : 0,
            didP1NewMon : 0,
            P1OutOfMons : 0,
            P2OutOfMons : 0
    }]
}



    
const PokemonAttacks = (attacker, defender) => {
    /* Pokemon 2 flashes*/
    handleDamageAnimation(defender)
}

const Pokemon2Attacks = () => {
    /* Pokemon 1 flashes*/
    /* Pokemon 1's hp decreases */

}

const handleDamage = (defender, remainingHealth) => {
    defender.currentHP = remainingHealth;
}

const Pokemon1Faints = () => {
    /* Pokemon 1 shrinks and hides */
}

const Pokemon2Faints = () => {
    /* Pokemon 2 shrinks and hides */
}

const NewPokemon1 = () => {
    /* New active pokemon is selected */
    /* Pokemon 1 goes from hidden to shown */
}

const NewPokemon2 = () => {
    /* New active pokemon is selected */
    /* Pokemon 1 goes from hidden to shown */
}

const handleDamageAnimation = (int) => {
    if (int == 1) {
    setPokemon1State("damaged")
    setTimeout(() => {
        setPokemon1State("normal")
      }, 1000);
    }
    if (int == 2) {
    setPokemon2State("damaged")
    setTimeout(() => {
        setPokemon2State("normal")
      }, 1000);
    }
    
}

const handleFaintAnimation = () => {
    setPokemon1State("fainting")
    setTimeout(() => {
        setPokemon1State("normal")
      }, 1000);
}

const handleSummonAnimation = () => {
    setPokemon1State("summoned")
    setTimeout(() => {
        setPokemon1State("normal")
      }, 1000);
}

const handlePokemon1HP = (int) => {
    setPokemon1HP(int);
}

const handlePokemon2HP = (int) => {
    setPokemon2HP(int);
}



const RunBattle = (BattleScript) => {
    setPokemon1MAXHP(BattleScript.trainers[0].team[0].currentHP);
    setPokemon2MAXHP(BattleScript.trainers[1].team[0].currentHP);
    // music player
    setActivePokemon1State(BattleScript.trainers[0].team[0])
    setActivePokemon2State(BattleScript.trainers[1].team[0])

    BattleScript.script.forEach(turn => {
        if (turn.playerFirst == 1) {
            const P1 = trainer1;
            const P2 = trainer2;
        } else if (turn.playerFirst == 0) 
        {
            const P1 = trainer2;
            const P2 = trainer1;
        };
    
    })


}

if (!BattleScript) {
    return (
        <>
        </>
    )
    } 



    return (
        <div id="Arena">
            <TrainerArea 
                trainer={BattleScript.trainers[0]}
                PokemonState = {Pokemon1State} 
                PokemonHP={Pokemon1HP}
                PokemonMAXHP={Pokemon1MAXHP}
                />
            <TrainerArea2
                trainer={BattleScript.trainers[1]}
                PokemonState = {Pokemon1State} 
                PokemonHP={Pokemon1HP}
                PokemonMAXHP={Pokemon1MAXHP}
                />
        </div>
    )
}

export default Arena;