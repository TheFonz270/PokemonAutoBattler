import React, {useState, useEffect} from 'react';
import BattleButton from './BattleButton';
import PokemonWindow from './PokemonWindow';

const MaintenanceArea = ({trainer, handleRandomisePokemon, handleRandomiseMove, handleLevelUp, CantAfford}) => {
    
    const pokemonWindows = trainer.pokemons.map((pokemon) =>{
        return <PokemonWindow trainer={trainer} pokemon={pokemon} handleRandomisePokemon={handleRandomisePokemon} handleRandomiseMove={handleRandomiseMove} handleLevelUp={handleLevelUp} CantAfford={CantAfford}/>
    });

    return (
        <div class="MaintenanceArea">
            {pokemonWindows}
        </div>
    )
}

export default MaintenanceArea;