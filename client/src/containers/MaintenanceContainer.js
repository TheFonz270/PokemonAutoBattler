import React, {useState, useEffect} from 'react';
import MaintenanceArea from '../components/Maintenance/MaintenanceArea';
import BattleButton from '../components/Maintenance/BattleButton';
import PtsBank from '../components/Maintenance/PtsBank';
import RandomisePokemon from '../components/Maintenance/RandomisePokemon';
import { randomisePokemonRequest } from '../services/battleService';
import { randomiseMoveRequest } from '../services/battleService';
import { levelUpRequest } from '../services/battleService';



const MaintenanceContainer = ({trainer, setTrainerState, handleScreenState}) => {

    const [CantAfford, setCantAfford] = useState("blue"); 

    const handleRandomisePokemon = (id) => {
        if (trainer.pokedollars >= 5) {
            // pokemon(id) = data
            let newTrainer = {...trainer};
            newTrainer.pokedollars -= 5;
            let found = newTrainer.pokemons.find(element => element.id == id)

            randomisePokemonRequest(id)
            .then((pokemon) => {
                    newTrainer.pokemons.splice(newTrainer.pokemons.indexOf(found), 1, pokemon)
                    setTrainerState(newTrainer)
            })                                 
        }
        
        else {
            setCantAfford("red")
        }
    }

    const handleRandomiseMove = (id) => {
        if (trainer.pokedollars >= 2) {
            let newTrainer = {...trainer};                 
            newTrainer.pokedollars -= 2; 
            let found = newTrainer.pokemons.find(element => element.id == id)

            randomiseMoveRequest(id)
            .then((pokemon) => {
                    console.log("MOVE: ", pokemon.activeMove)
                    newTrainer.pokemons[newTrainer.pokemons.indexOf(found)].activeMove = pokemon.activeMove
                    setTrainerState(newTrainer)
                }) 
        }
        else {
            setCantAfford("red")
        }
    }

    const handleLevelUp = (id) => {
        if (trainer.pokedollars >= 10) {
            let newTrainer = {...trainer};                 
            newTrainer.pokedollars -= 10;    
            let found = newTrainer.pokemons.find(element => element.id == id)                                     

            levelUpRequest(id)
            .then((pokemon) => {
                console.log("LEVEL: ", pokemon)
                newTrainer.pokemons[newTrainer.pokemons.indexOf(found)].level = pokemon.level
                setTrainerState(newTrainer)
            })

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