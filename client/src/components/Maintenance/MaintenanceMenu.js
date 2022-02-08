import React, {useState, useEffect} from 'react';
import RandomisePokemon from './RandomisePokemon';
import RandomiseMove from './RandomiseMove';
import LevelUp from './LevelUp';

const MaintenanceMenu = ({trainer, pokemon, handleRandomisePokemon, handleRandomiseMove, handleLevelUp, CantAfford}) => {

    return (
        <div class="MaintenanceMenu">
            <RandomisePokemon trainer={trainer} pokemon={pokemon} handleRandomisePokemon={handleRandomisePokemon} CantAfford={CantAfford}/>
            <RandomiseMove trainer={trainer} pokemon={pokemon} handleRandomiseMove={handleRandomiseMove} />
            <LevelUp trainer={trainer} pokemon={pokemon} handleLevelUp={handleLevelUp}/>
        </div>
    )
}

export default MaintenanceMenu;