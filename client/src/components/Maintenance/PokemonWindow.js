import React, {useState, useEffect} from 'react';
import MaintenanceNameBar from './MaintenanceNameBar';
import MaintenancePokemonSprite from './MaintenancePokemonSprite';
import MaintenanceMenu from './MaintenanceMenu';
import MaintenanceMove from './MaintenanceMove';
import MaintenanceTypes from './MaintenanceTypes';

const PokemonWindow = ({trainer, pokemon, handleRandomisePokemon, handleRandomiseMove, handleLevelUp, CantAfford}) => {

    return (
        <div class="pokemonWindow">
            <MaintenanceNameBar pokemon={pokemon}/>
            <MaintenanceTypes pokemon={pokemon}/>
            <MaintenancePokemonSprite pokemon={pokemon}/>
            <MaintenanceMove pokemon={pokemon}/>
            <MaintenanceMenu trainer={trainer} pokemon={pokemon} handleRandomisePokemon={handleRandomisePokemon} handleRandomiseMove={handleRandomiseMove} handleLevelUp={handleLevelUp} CantAfford={CantAfford}/>
        </div>
    )
}

export default PokemonWindow;