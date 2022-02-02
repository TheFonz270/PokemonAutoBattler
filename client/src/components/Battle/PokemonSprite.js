import React, {useState, useEffect} from 'react';
import ActivePokemon from './ActivePokemon';

const PokemonSprite = ({activePokemon, Pokemon1State}) => {

// console.log(activePokemon.AvatarImage)

    return (
        <div className="pokemonSprite">
        <img className={Pokemon1State} src={activePokemon.AvatarImage}></img>
        </div>
    )
}

export default PokemonSprite;