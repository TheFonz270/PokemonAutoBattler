import React, {useState, useEffect} from 'react';
import TrainerArea from './TrainerArea';
import TrainerArea2 from './TrainerArea2';

const Arena = ({BattleScript, setBattleScriptState, trainer, setTrainer, trainer2, setTrainer2}) => {
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
        findActive(trainer2, T2FaintedCount).currentHp = turn.P2CurrentHP
        setActivePokemon2State(findActive(trainer2, T2FaintedCount))
        handleDamageAnimation(2)
    }
    if (turn.playerFirst == false) {
        findActive(trainer, T1FaintedCount).currentHp = turn.P2CurrentHP
        setActivePokemon1State(findActive(trainer, T1FaintedCount))
        handleDamageAnimation(1)
    }
    checkHPs(trainers, turn);
}

const handleDamage2 = (trainers, turn) => {
    if (turn.playerFirst == true) {
        findActive(trainer, T1FaintedCount).currentHp = turn.P1CurrentHP
        setActivePokemon1State(findActive(trainer, T1FaintedCount))
        handleDamageAnimation(1)
        
    }
    if (turn.playerFirst == false) {
        findActive(trainer2, T2FaintedCount).currentHp = turn.P1CurrentHP
        setActivePokemon2State(findActive(trainer2, T2FaintedCount))
        handleDamageAnimation(2)
    }
    checkHPs(trainers, turn);
}



const checkHPs = (trainers, turn) => {
        setPokemon1HP((findActive(trainer, T1FaintedCount).currentHp/Pokemon1MAXHP) * 100)
        setPokemon2HP((findActive(trainer2, T2FaintedCount).currentHp/Pokemon2MAXHP) * 100)
    console.log("Check HP has run")
    
}

const checkIfFaints = (trainers, turn) => {
    if (findActive(trainer, T1FaintedCount).currentHp == 0) {
        console.log(`${ActivePokemon1State.name} has no HP!`)
        findActive(trainer, T1FaintedCount).isFainted = true
        handleFaintAnimation(1)
        setT1FaintedCount(+1)
        setActivePokemon1State(findActive(trainer, T1FaintedCount))
        
    }
    if (findActive(trainer2, T2FaintedCount).currentHp == 0) {
        console.log(`${ActivePokemon2State.name} has no HP!`)
        findActive(trainer2, T2FaintedCount).isFainted = true
        handleFaintAnimation(2)
        setT2FaintedCount(+1)
        setActivePokemon2State(findActive(trainer2, T2FaintedCount))
    }
    console.log("CheckIfFaints has run")
}

const SumonNewMons = (trainers, turn) => {
    if (turn.didP2Faint == true) {
        if (turn.playerFirst == true) {
            setActivePokemon2State(findActive(trainer2, T2FaintedCount))
            console.log("Go " + findActive(trainer2, T2FaintedCount).name + "!")
            handleSummonAnimation(2)
            setPokemon2MAXHP(findActive(trainer2, T2FaintedCount).currentHp);
            setPokemon2HP(100)
            
        }
        if (turn.playerFirst == false) {
            setActivePokemon1State(findActive(trainer, T1FaintedCount))
            console.log("Go " + findActive(trainer2, T2FaintedCount).name + "!")
            handleSummonAnimation(1)
            setPokemon1MAXHP(findActive(trainer, T1FaintedCount).currentHp);
            setPokemon1HP(100)
        }
        
    }

    if (turn.didP1Faint == true) {
        if (turn.playerFirst == true) {
            setActivePokemon1State(findActive(trainer, T1FaintedCount))
            console.log("Go " + findActive(trainer, T2FaintedCount).name + "!")
            handleSummonAnimation(1)
            setPokemon1MAXHP(findActive(trainer, T1FaintedCount).currentHp);
            setPokemon1HP(100)
        }
        if (turn.playerFirst == false) {
            setActivePokemon2State(findActive(trainer2, T2FaintedCount))
            console.log("Go " + findActive(trainer2, T2FaintedCount).name + "!")
            handleSummonAnimation(2)
            setPokemon2MAXHP(findActive(trainer2, T2FaintedCount).currentHp);
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
        BattleSetup()
    }, [])

    
    

const BattleSetup = () => {
    // music player
    setPokemon1MAXHP(findActive(trainer, T1FaintedCount).currentHp);
    setPokemon2MAXHP(findActive(trainer2, T2FaintedCount).currentHp);
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
                handleDamageAnimation(2)

                setTimeout(function () {

                    checkIfFaints(trainers, turn)
                
                    setTimeout(function () {

                        if (turn.playerFirst==true && findActive(trainer2, T2FaintedCount).isFainted == false || turn.playerFirst==false && findActive(trainer, T1FaintedCount).isFainted == false) {

                            handleDamage2(trainers, turn)
                            handleDamageAnimation(1)

                        }

                            setTimeout(function () {
                            checkIfFaints(trainers, turn)
                            

                            setTimeout(function () {

                                SumonNewMons(trainers, turn)

                                setTimeout(function () {

                                    if (TurnCounter < BattleScript.script.length) {
                                        setTurnCounter(TurnCounter + 1)
                                    }
                                    
                                }, 2000);

                            }, 2000);
                        
                        }, 2000);
                
                    }, 2000);

                }, 2000);
        

        }, 2000);
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