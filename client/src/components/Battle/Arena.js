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
        team : [quilava],
        avatar : "/img/PokemonTrainer.png",
        pokeDollars : 10
    }

    const trainer2 = {
        team : [honedge],
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

const decideP1 = (turn, BattleScript) => {
    if (turn.playerFirst == 1) {
        P1 = ActivePokemon1State;
        P2 = ActivePokemon2State;
    } else if (turn.playerFirst == 0) 
    {
        P1 = ActivePokemon2State;
        P2 = ActivePokemon1State;
    };
}

    
const PokemonAttacks = (attacker, defender) => {
    /* Pokemon 2 flashes*/
    handleDamageAnimation(defender)
}

const handleDamage = (defender, remainingHealth) => {
    defender.currentHp = remainingHealth;
    checkHPs();
}

const checkHPs = () => {
    setPokemon1HP((P1.currentHp/Pokemon1MAXHP) * 100)
    setPokemon2HP((P2.currentHp/Pokemon2MAXHP) * 100)
    
}

const checkIfFaints = () => {
    if (Pokemon1HP == 0) {
        P1.isFainted = true
    }
    if (Pokemon2HP == 0) {
        P2.isFainted = true
    }
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

    let P1 = null;
    let P2 = null;

    useEffect(()=>{
        RunBattle(BattleScript)}, [])


const RunBattle = (BattleScript) => {
    setPokemon1MAXHP(BattleScript.trainers[0].team[0].currentHP);
    setPokemon2MAXHP(BattleScript.trainers[1].team[0].currentHP);
    // music player
    setActivePokemon1State(BattleScript.trainers[0].team[0])
    setActivePokemon2State(BattleScript.trainers[1].team[0])

    BattleScript.script.forEach(turn => {
        console.log("BattleStarted")
        decideP1(turn, BattleScript)
        console.log({P1}, {P2})
        PokemonAttacks(P1, P2)
        handleDamage(P2, turn.P2CurrentHP)
        checkIfFaints()
        if (P2.isFainted == false) {
        PokemonAttacks(P2, P1)
        handleDamage(P1, turn.P1CurrentHP)
        }
        checkIfFaints()
        if (P2.isFainted == true) {
            setActivePokemon2State(BattleScript.trainers[1].team.find(pokemon => pokemon.isFainted == false))
        }
        if (P1.isFainted == true) {
            setActivePokemon1State(BattleScript.trainers[0].team.find(pokemon => pokemon.isFainted == false))
        }

        // 
    
    })


}

if (!BattleScript) {
    return (
        <>
        "Loading..."
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