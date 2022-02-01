import React, {useState, useEffect} from 'react';
import poke from "../../assets/img/quilava.png";

const PokemonSprite = ({Pokemon1State}) => {
    return (
        <div className="pokemonSprite">
        <img className={Pokemon1State} src={poke}></img>
        </div>
    )
}

export default PokemonSprite;