import React, {useState, useEffect} from 'react';
import ActivePokemon from './ActivePokemon';

const PokemonSprite = ({activePokemon, PokemonState}) => {

// console.log(activePokemon.AvatarImage)
const star = activePokemon.level

    return (
        <div className="pokemonSprite">
        {star>16?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star"></img>:null }
        {star>33?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star2"></img>:null }
        {star>49?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star3"></img>:null }
        <img className={`${PokemonState}`} src={activePokemon.avatarImage}></img>
        </div>
    )
}

export default PokemonSprite;