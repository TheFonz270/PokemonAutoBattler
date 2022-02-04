import React, {useState, useEffect} from 'react';
import NameBar from './NameBar';
import HpBar from './HPBar';
import Move from './Move';
import Types from './Types';
import PokemonSprite from './PokemonSprite'


const ActivePokemon = ({PokemonState, PokemonHP, activePokemon}) => {
    return (
        <div className="ActivePokemon">
            <NameBar activePokemon={activePokemon}/>
            <Types activePokemon={activePokemon}/>
            <HpBar PokemonHP={PokemonHP}/>
            <PokemonSprite activePokemon={activePokemon} PokemonState={PokemonState}/>
            <Move activePokemon={activePokemon}/>
        </div>
    )
}

export default ActivePokemon;

