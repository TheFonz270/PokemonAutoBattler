import React, {useState, useEffect} from 'react';
import CardName from './CardName';
import CardTypes from './CardTypes';
import CardSprite from './CardSprite'

const PokemonCard = ({pokemon}) => {

    return (
        <div class="pokemonCard">
            <CardName pokemon={pokemon}/>
            <CardTypes pokemon={pokemon}/>
            <CardSprite pokemon={pokemon}/>
        </div>
    )
}

export default PokemonCard;