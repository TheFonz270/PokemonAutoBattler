import React, {useState, useEffect} from 'react';

const RandomisePokemon = ({trainer, pokemon, handleRandomisePokemon, CantAfford}) => {


    return (
        <div class="randomisePokemon">
            <button onClick={handleRandomisePokemon}>Randomise Pokemon</button> <button className={`${trainer.pokedollars<5? "ptsCost red" : "ptsCost"}`}>5 pts</button>
        </div>
    )
}

export default RandomisePokemon;