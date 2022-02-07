import React, {useState, useEffect} from 'react';
import MaintenanceNameBar from './MaintenanceNameBar';
import MaintenancePokemonSprite from './MaintenancePokemonSprite';
import MaintenanceMenu from './MaintenanceMenu';
import MaintenanceMove from './MaintenanceMove';
import MaintenanceTypes from './MaintenanceTypes';

const PokemonWindow = ({pokemon}) => {

    return (
        <div class="pokemonWindow">
            <MaintenanceNameBar pokemon={pokemon}/>
            <MaintenanceTypes pokemon={pokemon}/>
            <MaintenancePokemonSprite pokemon={pokemon}/>
            <MaintenanceMove pokemon={pokemon}/>
            <MaintenanceMenu pokemon={pokemon}/>
        </div>
    )
}

export default PokemonWindow;