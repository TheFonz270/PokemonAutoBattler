import React, {useState, useEffect} from 'react';
import MaintenanceArea from '../components/Maintenance/MaintenanceArea';
import BattleButton from '../components/Maintenance/BattleButton';
import PtsBank from '../components/Maintenance/PtsBank';



const MaintenanceContainer = ({trainer, setTrainerState, handleScreenState}) => {

    const [CantAfford, setCantAfford] = useState("blue"); 

    const handleRandomisePokemon = () => {
        if (trainer.pokeDollars >= 5) {
            let newTrainer = {...trainer};                 
                newTrainer.pokeDollars -= 5;                                         
            setTrainerState(newTrainer)
        }
        else {
            setCantAfford("red")
        }
    }

    const handleRandomiseMove = () => {
        if (trainer.pokeDollars >= 2) {
            let newTrainer = {...trainer};                 
                newTrainer.pokeDollars -= 2;                                         
            setTrainerState(newTrainer)
        }
        else {
            setCantAfford("red")
        }
    }

    const handleLevelUp = () => {
        if (trainer.pokeDollars >= 10) {
            let newTrainer = {...trainer};                 
                newTrainer.pokeDollars -= 10;                                         
            setTrainerState(newTrainer)
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