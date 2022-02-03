import React, {useState, useEffect} from 'react';
import NameBar from './NameBar';
import HpBar from './HPBar';
import Move from './Move';
import Types from './Types';
import PokemonSprite from './PokemonSprite'


const ActivePokemon = ({Pokemon1State, Pokemon1HP, activePokemon}) => {
    return (
        <div className="ActivePokemon">
            <NameBar activePokemon={activePokemon}/>
            <Types activePokemon={activePokemon}/>
            <HpBar Pokemon1HP={Pokemon1HP}/>
            <PokemonSprite activePokemon={activePokemon} Pokemon1State={Pokemon1State}/>
            <Move activePokemon={activePokemon}/>
        </div>
    )
}

export default ActivePokemon;

