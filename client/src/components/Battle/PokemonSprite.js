import React, {useState, useEffect} from 'react';
import poke from "../../assets/img/quilava.png";

const PokemonSprite = () => {
    return (
        <div class="pokemonSprite">
        <img src={poke}></img>
        </div>
    )
}

export default PokemonSprite;