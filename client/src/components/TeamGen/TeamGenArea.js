import React, {useState, useEffect} from 'react';
import PokemonCard from './PokemonCard';

const TeamGenArea = ({handleClick, trainer}) => {

    const pokemonCards = trainer.team.map((pokemon) =>{

        return <PokemonCard handleClick={handleClick} pokemon={pokemon}/>
        });

    return (
        <div class="teamGenArea">
            {pokemonCards}
        </div>
    )
}

export default TeamGenArea;