import React, {useState, useEffect} from 'react';

const RandomisePokemon = ({trainer, pokemon, handleRandomisePokemon, CantAfford}) => {

    const handleRPClick = () => {
        handleRandomisePokemon(pokemon.id)
    }


    return (
        <div class="randomisePokemon">
            <button onClick={handleRPClick}>Randomise Pokemon</button> <button className={`${trainer.pokedollars<5? "ptsCost red" : "ptsCost"}`}>5 pts</button>
        </div>
    )
}

export default RandomisePokemon;