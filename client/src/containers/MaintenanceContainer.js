import React, {useState, useEffect} from 'react';
import MaintenanceArea from '../components/Maintenance/MaintenanceArea';
import BattleButton from '../components/Maintenance/BattleButton';
import PtsBank from '../components/Maintenance/PtsBank';
import RandomisePokemon from '../components/Maintenance/RandomisePokemon';
import { RandomisePokemonRequest } from '../services/battleService';
import { RandomiseMoveRequest } from '../services/battleService';
import { LevelUpRequest } from '../services/battleService';



const MaintenanceContainer = ({trainer, setTrainerState, handleScreenState}) => {

    const [CantAfford, setCantAfford] = useState("blue"); 

    const handleRandomisePokemon = (id) => {
        if (trainer.pokedollars >= 5) {
            let newTrainer = {...trainer};                 
                newTrainer.pokedollars -= 5;                                         
            setTrainerState(newTrainer)

            RandomisePokemonRequest(id)         
        }
        
        else {
            setCantAfford("red")
        }
    }

    const handleRandomiseMove = (id) => {
        if (trainer.pokedollars >= 2) {
            let newTrainer = {...trainer};                 
                newTrainer.pokedollars -= 2;                                         
            setTrainerState(newTrainer)

            RandomiseMoveRequest(id)  
        }
        else {
            setCantAfford("red")
        }
    }

    const handleLevelUp = (id) => {
        if (trainer.pokedollars >= 10) {
            let newTrainer = {...trainer};                 
                newTrainer.pokedollars -= 10;                                         
            setTrainerState(newTrainer)

            LevelUpRequest(id)
        }
        else {
            setCantAfford("red")
        }
    }

    if (!trainer) {
        return (
            <>
            "Loading..."
            </>
        )
    } 

    return (
        <>
        <MaintenanceArea trainer={trainer} handleRandomisePokemon={handleRandomisePokemon} handleRandomiseMove={handleRandomiseMove} handleLevelUp={handleLevelUp} CantAfford={CantAfford}/>
        <div class="MaintenanceFooter">
        <PtsBank trainer={trainer}/>
        <BattleButton trainer={trainer} handleScreenState={handleScreenState}/>
        </div>
        </>
    )
}

export default MaintenanceContainer;