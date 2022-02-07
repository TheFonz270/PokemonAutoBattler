import React, {useState, useEffect} from 'react';
import TrainerArea from './TrainerArea';
import TrainerArea2 from './TrainerArea2';

const Arena = () => {
    const [Pokemon1State, setPokemon1State] = useState("normal");           //CSS class for sprite
    const [ActivePokemon1State, setActivePokemon1State] = useState(null);   //Left Active Pokemon
    const [Pokemon1MAXHP, setPokemon1MAXHP] = useState(100);               //Left Pokemon Max Hp
    const [Pokemon1HP, setPokemon1HP] = useState(100);                      //Left Pokemon current HP percentage
    const [Pokemon2State, setPokemon2State] = useState("normal");
    const [ActivePokemon2State, setActivePokemon2State] = useState(null);
    const [Pokemon2MAXHP, setPokemon2MAXHP] = useState(100);
    const [Pokemon2HP, setPokemon2HP] = useState(100);
    const [TurnCounter, setTurnCounter] = useState(0);                      //Turn Counter
    const [T1FaintedCount, setT1FaintedCount] = useState(0);
    const [T2FaintedCount, setT2FaintedCount] = useState(0);

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

    const thunderbolt = {
        name : "Thunderbolt",
        type : "Electric",
        DamageType : "Special",
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

    const pikachu = {
        pokemonId : 25,
        name : "pikachu",
        AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/25.png",
        ActiveMove : thunderbolt,
        level : 17,
        canEvolve : true,
        currentHp : 120,
        types : ["Electric"],
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

    const eevee = {
        pokemonId : 133,
        name : "eevee",
        AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/133.png",
        ActiveMove : iron_head,
        level : 17,
        canEvolve : true,
        currentHp : 90,
        types : ["Normal"],
        isFainted : false

    }



    const trainer1 = {
        team : [quilava, pikachu],
        avatar : "/img/PokemonTrainer.png",
        pokeDollars : 10
    }

    const trainer2 = {
        team : [honedge, eevee],
        avatar : "/img/VStrainers/Youngster.png",
        pokeDollars : 10
    }

    const BattleScript = {
        trainers : [trainer1, trainer2],
        script : [{
            playerFirst :true,
            firstDamageDealt : 23,
            P2CurrentHP: 77,
            didP2Faint : false,
            secondDamageDealt : 18,
            P1CurrentHP: 102,
            didP1Faint : false,
            didP2NewMon : false,
            didP1NewMon : false,
            P1OutOfMons : false,
            P2OutOfMons : 0
        }, {
            playerFirst :true,
            firstDamageDealt : 20,
            P2CurrentHP: 57,
            didP2Faint :false,
            secondDamageDealt : 102,
            P1CurrentHP: 0,
            didP1Faint : true,
            didP2NewMon : false,
            didP1NewMon : true,
            P1OutOfMons : false,
            P2OutOfMons : 0
        }, {
            playerFirst :true,
            firstDamageDealt : 23,
            P2CurrentHP: 64,
            didP2Faint : false,
            secondDamageDealt : 20,
            P1CurrentHP: 82,
            didP1Faint : false,
            didP2NewMon : false,
            didP1NewMon : false,
            P1OutOfMons : false,
            P2OutOfMons : 0
    }
        ]
}








// const decideP1 = (turn, trainers) => {
//     if (turn.playerFirst == 1) {
//         ActiveFirst = ActivePokemon1State;
//         ActiveSecond = ActivePokemon2State;
//     } else if (turn.playerFirst == 0) 
//     {
//         ActiveFirst = ActivePokemon2State;
//         ActiveSecond = ActivePokemon1State;
//     };
    
// }

    
const PokemonAttacks = (attacker, defender) => {
    /* Pokemon 2 flashes*/
    handleDamageAnimation(defender)
}

const handleDamage1 = (trainers, turn) => {
    if (turn.playerFirst == true) {
        findActive(trainers[1], T2FaintedCount).currentHp = turn.P2CurrentHP
        setActivePokemon2State(findActive(trainers[1], T2FaintedCount))
    }
    if (turn.playerFirst == false) {
        findActive(trainers[0], T1FaintedCount).currentHp = turn.P2CurrentHP
        setActivePokemon1State(findActive(trainers[0], T1FaintedCount))
    }
    checkHPs(trainers, turn);
}

const handleDamage2 = (trainers, turn) => {
    if (turn.playerFirst == true) {
        findActive(trainers[0], T1FaintedCount).currentHp = turn.P1CurrentHP
        setActivePokemon1State(findActive(trainers[0], T1FaintedCount))
        
    }
    if (turn.playerFirst == false) {
        findActive(trainers[1], T2FaintedCount).currentHp = turn.P1CurrentHP
        setActivePokemon2State(findActive(trainers[1], T2FaintedCount))
    }
    checkHPs(trainers, turn);
}



const checkHPs = (trainers, turn) => {
        setPokemon1HP((findActive(trainers[0], T1FaintedCount).currentHp/Pokemon1MAXHP) * 100)
        setPokemon2HP((findActive(trainers[1], T2FaintedCount).currentHp/Pokemon2MAXHP) * 100)
    console.log("Check HP has run")
    
}

const checkIfFaints = (trainers, turn) => {
    if (findActive(trainers[0], T1FaintedCount).currentHp == 0) {
        console.log(`${ActivePokemon1State.name} has no HP!`)
        findActive(trainers[0], T1FaintedCount).isFainted = true
        setT1FaintedCount(+1)
        
    }
    if (findActive(trainers[1], T2FaintedCount).currentHp == 0) {
        console.log(`${ActivePokemon2State.name} has no HP!`)
        findActive(trainers[1], T2FaintedCount).isFainted = true
        setT2FaintedCount(+1)
        setActivePokemon2State(findActive(trainers[1], T2FaintedCount))
    }
    console.log("CheckIfFaints has run")
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

// const handlePokemon1HP = (int) => {
//     setPokemon1HP(int);
// }

// const handlePokemon2HP = (int) => {
//     setPokemon2HP(int);
// }

    useEffect(()=>{
        BattleSetup(BattleScript.trainers)}, [])
    
        

        let ActiveFirst = null;
        let ActiveSecond = null;

const BattleSetup = (trainers) => {
    // music player
    setPokemon1MAXHP(findActive(trainers[0], T1FaintedCount).currentHp);
    setPokemon2MAXHP(findActive(trainers[0], T1FaintedCount).currentHp);
    setActivePokemon1State(findActive(trainers[0], T1FaintedCount))
    setActivePokemon2State(findActive(trainers[1], T2FaintedCount))
    
    setTimeout(() => {
        setTurnCounter(1)
    }, 3000);
}

const findActive = (trainer, FaintedCount) => {
    return trainer.team[FaintedCount]
}

    useEffect(()=>{
        BattleTurn(BattleScript.trainers, BattleScript.script[TurnCounter-1])
    }, [TurnCounter])


    // useEffect(()=>{
        
    // }, [ActivePokemon1State])

    // useEffect(()=>{
        
    // }, [ActivePokemon2State])


const BattleTurn = (trainers, turn) => {
    if (TurnCounter > 0) {
            
        // decideP1(turn, trainers)
        console.log("Turn : " + TurnCounter + "begins")
        
        
        setTimeout(function () {

                handleDamage1(trainers, turn)
                handleDamageAnimation(2)

                setTimeout(function () {

                    checkIfFaints(trainers, turn)
                
                    setTimeout(function () {

                        if (turn.playerFirst==true && findActive(trainers[1], T2FaintedCount).isFainted == false || turn.playerFirst==false && findActive(trainers[0], T1FaintedCount).isFainted == false) {

                            handleDamage2(trainers, turn)
                            handleDamageAnimation(1)

                        }

                            setTimeout(function () {
                            checkIfFaints(trainers, turn)
                            

                            setTimeout(function () {

                                if (turn.didP2Faint == true) {
                                    if (turn.playerFirst == true) {
                                        setActivePokemon2State(findActive(trainers[1], T2FaintedCount))
                                        console.log("Go " + findActive(trainers[1], T2FaintedCount).name + "!")
                                        setPokemon2HP(100)
                                        setPokemon2MAXHP(findActive(trainers[1], T2FaintedCount).currentHp);
                                        
                                    }
                                    if (turn.playerFirst == false) {
                                        setActivePokemon1State(findActive(trainers[0], T1FaintedCount))
                                        setPokemon1MAXHP(findActive(trainers[0], T1FaintedCount).currentHp);
                                        setPokemon1HP(100)
                                    }
                                    
                                }
    
                                if (turn.didP1Faint == true) {
                                    if (turn.playerFirst == true) {
                                        setActivePokemon1State(findActive(trainers[0], T1FaintedCount))
                                        setPokemon1MAXHP(findActive(trainers[0], T1FaintedCount).currentHp);
                                        setPokemon1HP(100)
                                    }
                                    if (turn.playerFirst == false) {
                                        setActivePokemon2State(findActive(trainers[1], T2FaintedCount))
                                        setPokemon2MAXHP(findActive(trainers[1], T2FaintedCount).currentHp);
                                        setPokemon2HP(100)
                                    }
                                    
                                }
                                setTimeout(function () {

                                    if (TurnCounter < BattleScript.script.length) {
                                        setTurnCounter(TurnCounter + 1)
                                    }
                                }, 2000);

                            }, 2000);
                        
                    }, 2000);
                
            }, 2000);

        }, 2000);
        

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
        }, 2000);
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
                activePokemon = {ActivePokemon1State}
                />
            <TrainerArea2
                trainer={BattleScript.trainers[1]}
                PokemonState = {Pokemon2State} 
                PokemonHP={Pokemon2HP}
                activePokemon = {ActivePokemon2State}
                />
        </div>
    )
}

export default Arena;