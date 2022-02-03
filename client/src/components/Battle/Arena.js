import React, {useState, useEffect} from 'react';
import TrainerArea from './TrainerArea';
import TrainerArea2 from './TrainerArea2';

const Arena = () => {
    const [Pokemon1State, setPokemon1State] = useState("normal");
    const [ActivePokemon1State, setActivePokemon1State] = useState(null);
    const [Pokemon1MAXHP, setPokemon1MAXHP] = useState(null);
    const [Pokemon1HP, setPokemon1HP] = useState(100);
    const [Pokemon2State, setPokemon2State] = useState("normal");
    const [ActivePokemon2State, setActivePokemon2State] = useState(null);
    const [Pokemon2MAXHP, setPokemon2MAXHP] = useState(null);
    const [Pokemon2HP, setPokemon2HP] = useState(100);
    const [P1, setP1] = useState(null);
    const [P2, setP2] = useState(null);
    const [TurnCounter, setTurnCounter] = useState(0);

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
        }, {
            playerFirst : 1,
            firstDamageDealt : 20,
            P2CurrentHP: 57,
            didP2Faint : 0,
            secondDamageDealt : 22,
            P1CurrentHP: 80,
            didP1Faint : 0,
            didP2NewMon : 0,
            didP1NewMon : 0,
            P1OutOfMons : 0,
            P2OutOfMons : 0
        }, {
            playerFirst : 1,
            firstDamageDealt : 23,
            P2CurrentHP: 34,
            didP2Faint : 0,
            secondDamageDealt : 20,
            P1CurrentHP: 60,
            didP1Faint : 0,
            didP2NewMon : 0,
            didP1NewMon : 0,
            P1OutOfMons : 0,
            P2OutOfMons : 0
    }
        ]
}

const decideP1 = (turn, BattleScript) => {
    if (turn.playerFirst == 1) {
        ActiveFirst = ActivePokemon1State;
        ActiveSecond = ActivePokemon2State;
        setP1(ActivePokemon1State);
        setP2(ActivePokemon2State);
    } else if (turn.playerFirst == 0) 
    {
        ActiveFirst = ActivePokemon2State;
        ActiveSecond = ActivePokemon1State;
        setP2(ActivePokemon1State);
        setP1(ActivePokemon2State);
    };
    
}

    
const PokemonAttacks = (attacker, defender) => {
    /* Pokemon 2 flashes*/
    handleDamageAnimation(defender)
}

const handleDamage = (defender, remainingHealth) => {
    console.log("HandleDamage runs on defender : " + defender.name)
    defender.currentHp = remainingHealth;
    checkHPs();
}

const checkHPs = () => {
    setPokemon1HP((ActiveFirst.currentHp/Pokemon1MAXHP) * 100)
    setPokemon2HP((ActiveSecond.currentHp/Pokemon2MAXHP) * 100)
    console.log("Check HP has run")
    
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

    useEffect(()=>{
        BattleSetup(BattleScript)}, [])

        let ActiveFirst = null;
        let ActiveSecond = null;

const BattleSetup = (BattleScript) => {
    // music player
    setPokemon1MAXHP(BattleScript.trainers[0].team[0].currentHp);
    setPokemon2MAXHP(BattleScript.trainers[1].team[0].currentHp);
    setActivePokemon1State(BattleScript.trainers[0].team[0])
    setActivePokemon2State(BattleScript.trainers[1].team[0])
    
    setTimeout(() => {
        setTurnCounter(1)
    }, 3000);

    // console.log("1st Pokemon from BattleScript trainer 1:" + BattleScript.trainers[0].team[0])
    // console.log("1st Pokemon from BattleScript trainer 2:" + BattleScript.trainers[1].team[0])
    // console.log("Active Pokemon 1 State: " + ActivePokemon1State)
    // console.log("Active Pokemon 2 State: " + ActivePokemon2State)
}

    useEffect(()=>{
        BattleTurn(BattleScript.script[TurnCounter-1])
    }, [TurnCounter])



const BattleTurn = (turn) => {
    if (TurnCounter > 0) {
            
        decideP1(turn, BattleScript)
        
        
        setTimeout(function () {

                handleDamage(ActiveSecond, turn.P2CurrentHP)
                handleDamageAnimation(2)
            
            setTimeout(function () {

                handleDamage(ActiveFirst, turn.P1CurrentHP)
                handleDamageAnimation(1)
                
                console.log("Script length" + BattleScript.script.length)
            
            if (TurnCounter < BattleScript.script.length) {
                    setTurnCounter(TurnCounter + 1)
                }
            }, 3000);

            
        }, 3000);
        

        // console.log("BattleStarted")
        // decideP1(turn, BattleScript)
        // console.log({P1}, {P2})
        // PokemonAttacks(P1, P2)
        // handleDamage(P2, turn.P2CurrentHP)
        // checkIfFaints()
        // if (P2.isFainted == false) {
        // PokemonAttacks(P2, P1)
        // handleDamage(P1, turn.P1CurrentHP)
        // }
        // checkIfFaints()
        // if (P2.isFainted == true) {
        //     setActivePokemon2State(BattleScript.trainers[1].team.find(pokemon => pokemon.isFainted == false))
        // }
        // if (P1.isFainted == true) {
        //     setActivePokemon1State(BattleScript.trainers[0].team.find(pokemon => pokemon.isFainted == false))
        // }
    }
}




if (TurnCounter < 1) {
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
                />
            <TrainerArea2
                trainer={BattleScript.trainers[1]}
                PokemonState = {Pokemon2State} 
                PokemonHP={Pokemon2HP}
                />
        </div>
    )
}

export default Arena;