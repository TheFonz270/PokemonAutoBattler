import React, {useState, useEffect} from 'react';
import CardName from './CardName';
import CardTypes from './CardTypes';
import CardSprite from './CardSprite'

const PokemonCard = ({handleClick, pokemon}) => {

    
    const handleClick2 = () => {
        handleClick(pokemon)
    }

    return (
        <div class="pokemonCard" onClick={handleClick2}>
            <CardName pokemon={pokemon}/>
            <CardTypes pokemon={pokemon}/>
            <CardSprite pokemon={pokemon}/>
        </div>
    )
}

export default PokemonCard;