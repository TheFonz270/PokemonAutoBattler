import React, {useState, useEffect} from 'react';
import TrainerSprite from './TrainerSprite';
import ActivePokemon from './ActivePokemon';
import Bench from './Bench'

const TrainerArea = ({trainer, PokemonState, PokemonHP, activePokemon}) => {

    // const handle100Click = () => {
    //     handlePokemon1HP(100)    
    // }

    // const handle40Click = () => {
    //     handlePokemon1HP(40)     
    // }

    // const handle10Click = () => {
    //     handlePokemon1HP(10)      
    // }

    // const activePokemon = trainer.team.find(pokemon => pokemon.isFainted == false);
   

    return (
        <div class="trainerArea trainerArea1">
            <div class="trainerOuter">
                <TrainerSprite trainer={trainer}/>
                <Bench trainer={trainer}/>
            </div>
            <div class="trainerInner">
                <ActivePokemon PokemonState={PokemonState} PokemonHP={PokemonHP} activePokemon={activePokemon}/>
                {/* <button onClick={handleDamageAnimation(1)} >Damage</button>  <button onClick={handleFaintAnimation} >Faint</button>  <button onClick={handleSummonAnimation} >Summon</button>
                <button onClick={handle100Click} >100%</button> <button onClick={handle40Click} >40%</button> <button onClick={handle10Click} >10%</button> */}
            </div>
        </div>
    )
}

export default TrainerArea;