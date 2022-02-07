import React, {useState, useEffect} from 'react';
import TrainerArea from './TrainerArea';
import TrainerArea2 from './TrainerArea2';

const Arena = ({BattleScript, setBattleScriptState, Trainer1, setTrainer1, Trainer2, setTrainer2}) => {
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


    
const PokemonAttacks = (attacker, defender) => {
    /* Pokemon 2 flashes*/
    handleDamageAnimation(defender)
}

const handleDamage1 = (trainers, turn) => {
    if (turn.playerFirst == true) {
        findActive(Trainer2, T2FaintedCount).currentHp = turn.P2CurrentHP
        setActivePokemon2State(findActive(Trainer2, T2FaintedCount))
    }
    if (turn.playerFirst == false) {
        findActive(Trainer1, T1FaintedCount).currentHp = turn.P2CurrentHP
        setActivePokemon1State(findActive(Trainer1, T1FaintedCount))
    }
    checkHPs(trainers, turn);
}

const handleDamage2 = (trainers, turn) => {
    if (turn.playerFirst == true) {
        findActive(Trainer1, T1FaintedCount).currentHp = turn.P1CurrentHP
        setActivePokemon1State(findActive(Trainer1, T1FaintedCount))
        
    }
    if (turn.playerFirst == false) {
        findActive(Trainer2, T2FaintedCount).currentHp = turn.P1CurrentHP
        setActivePokemon2State(findActive(Trainer2, T2FaintedCount))
    }
    checkHPs(trainers, turn);
}



const checkHPs = (trainers, turn) => {
        setPokemon1HP((findActive(Trainer1, T1FaintedCount).currentHp/Pokemon1MAXHP) * 100)
        setPokemon2HP((findActive(Trainer2, T2FaintedCount).currentHp/Pokemon2MAXHP) * 100)
    console.log("Check HP has run")
    
}

const checkIfFaints = (trainers, turn) => {
    if (findActive(Trainer1, T1FaintedCount).currentHp == 0) {
        console.log(`${ActivePokemon1State.name} has no HP!`)
        findActive(Trainer1, T1FaintedCount).isFainted = true
        setT1FaintedCount(+1)
        
    }
    if (findActive(Trainer2, T2FaintedCount).currentHp == 0) {
        console.log(`${ActivePokemon2State.name} has no HP!`)
        findActive(Trainer2, T2FaintedCount).isFainted = true
        setT2FaintedCount(+1)
        setActivePokemon2State(findActive(Trainer2, T2FaintedCount))
    }
    console.log("CheckIfFaints has run")
}

const SumonNewMons = (trainers, turn) => {
    if (turn.didP2Faint == true) {
        if (turn.playerFirst == true) {
            setActivePokemon2State(findActive(Trainer2, T2FaintedCount))
            console.log("Go " + findActive(Trainer2, T2FaintedCount).name + "!")
            setPokemon2HP(100)
            setPokemon2MAXHP(findActive(Trainer2, T2FaintedCount).currentHp);
            
        }
        if (turn.playerFirst == false) {
            setActivePokemon1State(findActive(Trainer1, T1FaintedCount))
            setPokemon1MAXHP(findActive(Trainer1, T1FaintedCount).currentHp);
            setPokemon1HP(100)
        }
        
    }

    if (turn.didP1Faint == true) {
        if (turn.playerFirst == true) {
            setActivePokemon1State(findActive(Trainer1, T1FaintedCount))
            setPokemon1MAXHP(findActive(Trainer1, T1FaintedCount).currentHp);
            setPokemon1HP(100)
        }
        if (turn.playerFirst == false) {
            setActivePokemon2State(findActive(Trainer2, T2FaintedCount))
            setPokemon2MAXHP(findActive(Trainer2, T2FaintedCount).currentHp);
            setPokemon2HP(100)
        }
        
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


    useEffect(()=>{
        BattleSetup()
    }, [])

    
    

const BattleSetup = () => {
    // music player
    setPokemon1MAXHP(findActive(Trainer1, T1FaintedCount).currentHp);
    setPokemon2MAXHP(findActive(Trainer2, T2FaintedCount).currentHp);
    setActivePokemon1State(findActive(Trainer1, T1FaintedCount))
    setActivePokemon2State(findActive(Trainer2, T2FaintedCount))
    
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

                        if (turn.playerFirst==true && findActive(Trainer2, T2FaintedCount).isFainted == false || turn.playerFirst==false && findActive(Trainer1, T1FaintedCount).isFainted == false) {

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
        <>
        "Loading..."
        </>
    )
    } 



    return (
        <div id="Arena">
            <TrainerArea 
                trainer={Trainer1}
                PokemonState = {Pokemon1State} 
                PokemonHP={Pokemon1HP}
                activePokemon = {ActivePokemon1State}
                />
            <TrainerArea2
                trainer={Trainer2}
                PokemonState = {Pokemon2State} 
                PokemonHP={Pokemon2HP}
                activePokemon = {ActivePokemon2State}
                />
        </div>
    )
}

export default Arena;