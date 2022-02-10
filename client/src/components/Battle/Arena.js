import React, {useState, useEffect} from 'react';
import TrainerArea from './TrainerArea';
import TrainerArea2 from './TrainerArea2';

const Arena = ({BattleScript, setBattleScriptState, trainer, setTrainer, trainer2, setTrainer2, track1, play1, pause1}) => {
    const [Pokemon1State, setPokemon1State] = useState("idle");           //CSS class for sprite
    const [ActivePokemon1State, setActivePokemon1State] = useState(null);   //Left Active Pokemon
    const [Pokemon1MAXHP, setPokemon1MAXHP] = useState(100);               //Left Pokemon Max Hp
    const [Pokemon1HP, setPokemon1HP] = useState(100);                      //Left Pokemon current HP percentage
    const [Pokemon2State, setPokemon2State] = useState("idle");
    const [ActivePokemon2State, setActivePokemon2State] = useState(null);
    const [Pokemon2MAXHP, setPokemon2MAXHP] = useState(100);
    const [Pokemon2HP, setPokemon2HP] = useState(100);
    const [TurnCounter, setTurnCounter] = useState(0);                      //Turn Counter
    const [T1FaintedCount, setT1FaintedCount] = useState(0);
    const [T2FaintedCount, setT2FaintedCount] = useState(0);



const handleDamage1 = (trainers, turn) => {
    if (turn.playerFirst == true) {
        setPokemon2HP((turn.P2currentHP/ActivePokemon2State.effectiveStats.HP) * 100)
        // setActivePokemon2State(findActive(trainer2, T2FaintedCount))
        handleDamageAnimation(2)
        checkHPs2(turn)
    }
    if (turn.playerFirst == false) {
        setPokemon1HP((turn.P1currentHP/ActivePokemon1State.effectiveStats.HP) * 100)
        // setActivePokemon1State(findActive(trainer, T1FaintedCount))
        handleDamageAnimation(1)
        checkHPs2(turn);
    }
    
}

const handleDamage2 = (turn) => {
    if (turn.playerFirst == true) {
        setPokemon1HP((turn.P1currentHP/ActivePokemon1State.effectiveStats.HP) * 100)
        // setActivePokemon1State(findActive(trainer, T1FaintedCount))
        handleDamageAnimation(1)
        
    }
    if (turn.playerFirst == false) {
        setPokemon2HP((turn.P2currentHP/ActivePokemon2State.effectiveStats.HP) * 100)
        // setActivePokemon2State(findActive(trainer2, T2FaintedCount))
        handleDamageAnimation(2)
    }
    // checkHPs(trainers, turn);
}



const checkHPs1 = (trainers, turn) => {
        setPokemon1HP((findActive(trainer, T1FaintedCount).currentHP/findActive(trainer, T1FaintedCount).effectiveStats.HP) * 100)
        console.log("Check HP1 has run : ", Pokemon1HP)
}
const checkHPs2 = (trainers, turn) => {
        setPokemon2HP((findActive(trainer2, T2FaintedCount).currentHP/findActive(trainer2, T1FaintedCount).effectiveStats.HP) * 100)
    console.log("Check HP2 has run : ", Pokemon2HP)
}

const checkIfFaints = (trainers, turn) => {
    if (turn.didP1Faint == true) {
        console.log("T1FaintedCount start of function", T1FaintedCount)
        const newCount = T1FaintedCount + 1
        setT1FaintedCount(newCount)
        console.log("T1FaintedCount after +1", T1FaintedCount)
        console.log(`${ActivePokemon1State.name} has no HP!`)
        // findActive(trainer, T1FaintedCount).isFainted = true
        handleFaintAnimation(1)
        console.log("ActivePokemon1State before new set", ActivePokemon1State)
        setActivePokemon1State(findActive(trainer, T1FaintedCount))
        console.log("ActivePokemon1State after new set", ActivePokemon1State)
        
    }
    if (turn.didP2Faint == true) {
        console.log(`${ActivePokemon2State.name} has no HP!`)
        // findActive(trainer2, T2FaintedCount).isFainted = true
        handleFaintAnimation(2)
        setT2FaintedCount(T2FaintedCount + 1 )
        setActivePokemon2State(findActive(trainer2, T2FaintedCount))
    }
    console.log("CheckIfFaints has run")
}

const SumonNewMons = (turn) => {
    if (turn.didP2NewMon == true) {
        if (turn.playerFirst == true) {
            setActivePokemon2State(findActive(trainer2, T2FaintedCount))
            console.log("Go " + findActive(trainer2, (T2FaintedCount +1)).name + "!")
            handleSummonAnimation(2)
            setPokemon2MAXHP(findActive(trainer, T1FaintedCount).effectiveStats.HP);
            setPokemon2HP(100)
            
        }
        if (turn.playerFirst == false) {
            setActivePokemon1State(findActive(trainer, T1FaintedCount))
            console.log("Go " + findActive(trainer2, T2FaintedCount +1).name + "!")
            handleSummonAnimation(1)
            setPokemon1MAXHP(findActive(trainer, T1FaintedCount).effectiveStats.HP);
            setPokemon1HP(100)
        }
        
    }

    if (turn.didP1NewMon == true) {
        if (turn.playerFirst == true) {
            setActivePokemon1State(findActive(trainer, T1FaintedCount))
            console.log("Go " + findActive(trainer, T2FaintedCount).name + "!")
            handleSummonAnimation(1)
            setPokemon1MAXHP(findActive(trainer, T1FaintedCount).effectiveStats.HP);
            setPokemon1HP(100)
        }
        if (turn.playerFirst == false) {
            setActivePokemon2State(findActive(trainer2, T2FaintedCount))
            console.log("Go " + findActive(trainer2, T2FaintedCount).name + "!")
            handleSummonAnimation(2)
            setPokemon2MAXHP(findActive(trainer, T1FaintedCount).effectiveStats.HP);
            setPokemon2HP(100)
        }
        
    }
}


const handleDamageAnimation = (int) => {
    if (int == 1) {
    setPokemon1State("damaged")
    setTimeout(() => {
        setPokemon1State("idle")
      }, 1000);
    }
    if (int == 2) {
    setPokemon2State("damaged")
    setTimeout(() => {
        setPokemon2State("idle")
      }, 1000);
    }
    
}

const handleFaintAnimation = (int) => {
    
    if (int == 1) {
        setPokemon1State("fainting")
        setTimeout(() => {
            setPokemon1State("hidden")
        }, 1000);
    }
    if (int == 2) {
        setPokemon2State("fainting")
        setTimeout(() => {
            setPokemon2State("hidden")
        }, 1000);
    }
}

const handleSummonAnimation = (int) => {
    if (int == 1) {
        setPokemon1State("summoned")
        setTimeout(() => {
            setPokemon1State("idle")
        }, 1000);
    }
    if (int == 2) {
        setPokemon2State("summoned")
        setTimeout(() => {
            setPokemon2State("idle")
        }, 1000);
    }
}


    useEffect(()=>{
        play1()
        BattleSetup()
    }, [])

    
    

const BattleSetup = () => {
    setPokemon1MAXHP(findActive(trainer, T1FaintedCount).effectiveStats.HP);
    setPokemon2MAXHP(findActive(trainer2, T1FaintedCount).effectiveStats.HP);
    setActivePokemon1State(findActive(trainer, T1FaintedCount))
    setActivePokemon2State(findActive(trainer2, T2FaintedCount))
    
    setTimeout(() => {
        setTurnCounter(1)
    }, 3000);
}

const findActive = (trainer, FaintedCount) => {
    return trainer.pokemons[FaintedCount]
}

    useEffect(()=>{
        BattleTurn([trainer, trainer2], BattleScript.script[TurnCounter-1])
    }, [TurnCounter])



const BattleTurn = (trainers, turn) => {
    if (TurnCounter > 0) {
            
        // decideP1(turn, trainers)
        console.log("Turn : " + TurnCounter + "begins")
        
        
        setTimeout(function () {

                handleDamage1(trainers, turn)

                setTimeout(function () {

                    checkIfFaints(trainers, turn)
                
                    setTimeout(function () {

                        if (turn.playerFirst==true && findActive(trainer2, T2FaintedCount).isFainted == false || turn.playerFirst==false && findActive(trainer, T1FaintedCount).isFainted == false) {

                            handleDamage2(trainers, turn)

                        }

                            setTimeout(function () {
                            checkIfFaints(trainers, turn)
                            

                            setTimeout(function () {

                                SumonNewMons(turn)

                                setTimeout(function () {

                                    if (turn.p1OutOfMons == true) {
                                        if (turn.playerFirst == true) {
                                        console.log("You've lost the battle!")
                                        pause1()
                                        }
                                        if (turn.playerFirst == false) {
                                        console.log("You've won the battle!")
                                        pause1()
                                        }
                                    }

                                    if (turn.p2OutOfMons == true) {
                                        if (turn.playerFirst == true) {
                                            console.log("You've won the battle!")
                                            pause1()
                                            }
                                            if (turn.playerFirst == false) {
                                            console.log("You've lost the battle!")
                                            pause1()
                                            }
                                    }

                                        setTimeout(function () {

                                            if (TurnCounter < BattleScript.script.length) {
                                                setTurnCounter(TurnCounter + 1)
                                            }
                                            
                                        }, 3000);

                            }, 3000);

                            }, 3000);
                        
                        }, 3000);
                
                    }, 3000);

                }, 3000);
        

        }, 3000);
    }
}






if (TurnCounter < 1) {
    return (
        <div class="wrapper">
            <div class="pokeball">
            </div>
        </div>
    )
    } 



    return (
        <div id="Arena">
            <TrainerArea 
                trainer={trainer}
                PokemonState = {Pokemon1State} 
                PokemonHP={Pokemon1HP}
                activePokemon = {ActivePokemon1State}
                />
            <TrainerArea2
                trainer={trainer2}
                PokemonState = {Pokemon2State} 
                PokemonHP={Pokemon2HP}
                activePokemon = {ActivePokemon2State}
                />
        </div>
    )
}

export default Arena;