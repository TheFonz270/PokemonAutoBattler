import React, {useState, useEffect} from 'react';

const MaintenancePokemonSprite = ({pokemon}) => {

// console.log(activePokemon.AvatarImage)
const star = pokemon.level
console.log("STARS CHECK", (star=="ONE_STAR" || star=="TWO_STARS" || star=="THREE_STARS"))

    return (
        <div className="pokemonSprite">
        {(star=="ONE_STAR" || star=="TWO_STARS" || star=="THREE_STARS")?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star"></img>:null }
        {(star=="TWO_STARS" || star=="THREE_STARS")?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star2"></img>:null }
        {(star=="THREE_STARS")?<img src={process.env.PUBLIC_URL + `/img/star.png`} class="star3"></img>:null }
        <img className="MaintenanceSprite" src={pokemon.avatarImage}></img>
        </div>
    )
}

export default MaintenancePokemonSprite;