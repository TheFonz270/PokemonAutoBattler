import React, {useState, useEffect} from 'react';
import NameBar from './NameBar';
import HpBar from './HPBar';
import Move from './Move';
import Types from './Types';
import PokemonSprite from './PokemonSprite'


const ActivePokemon = ({Pokemon1State, Pokemon1HP}) => {
    return (
        <div className="ActivePokemon">
            <NameBar/>
            <Types/>
            <HpBar Pokemon1HP={Pokemon1HP}/>
            <PokemonSprite Pokemon1State={Pokemon1State}/>
            <Move/>
        </div>
    )
}

export default ActivePokemon;

