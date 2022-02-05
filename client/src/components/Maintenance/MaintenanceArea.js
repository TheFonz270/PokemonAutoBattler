import React, {useState, useEffect} from 'react';
import BattleButton from './BattleButton';
import PokemonWindow from './PokemonWindow';

const MaintenanceArea = ({trainer}) => {

    const pokemonWindows = trainer.team.map((pokemon) =>{
        return <PokemonWindow pokemon={pokemon}/>
        });

    return (
        <div class="MaintenanceArea">
            <BattleButton />
            {pokemonWindows}
        </div>
    )
}

export default MaintenanceArea;