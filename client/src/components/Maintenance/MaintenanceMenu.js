import React, {useState, useEffect} from 'react';
import RandomisePokemon from './RandomisePokemon';
import RandomiseMove from './RandomiseMove';
import LevelUp from './LevelUp';

const MaintenanceMenu = ({trainer, pokemon}) => {

    return (
        <div class="MaintenanceMenu">
            <RandomisePokemon trainer={trainer} pokemon={pokemon}/>
            <RandomiseMove trainer={trainer} pokemon={pokemon}/>
            <LevelUp trainer={trainer} pokemon={pokemon}/>
        </div>
    )
}

export default MaintenanceMenu;