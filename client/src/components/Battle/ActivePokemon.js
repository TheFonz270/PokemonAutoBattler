import React, {useState, useEffect} from 'react';
import NameBar from './NameBar';
import HpBar from './HPBar';
import Move from './Move';
import Types from './Types';
import PokemonSprite from './PokemonSprite'


const ActivePokemon = () => {
    return (
        <div class="ActivePokemon">
            <NameBar/>
            <Types/>
            <HpBar/>
            <PokemonSprite/>
            <Move/>
        </div>
    )
}

export default ActivePokemon;

