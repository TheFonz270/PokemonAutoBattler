import React, {useState, useEffect} from 'react';

const MaintenancePokemonSprite = ({pokemon}) => {

// console.log(activePokemon.AvatarImage)
const star = pokemon.level

    return (
        <div className="pokemonSprite">
        {star>16?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star"></img>:null }
        {star>33?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star"></img>:null }
        {star>49?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star"></img>:null }
        <img className="MaintenanceSprite" src={pokemon.avatarImage}></img>
        </div>
    )
}

export default MaintenancePokemonSprite;