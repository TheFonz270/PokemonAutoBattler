import React, {useState, useEffect} from 'react';

const RandomiseMove = ({trainer, pokemon, handleRandomiseMove}) => {

    const handleRMClick = () => {
        handleRandomiseMove(pokemon.id)
    }

    return (
        <div class="randomiseMove">
            <button onClick={handleRMClick}>Randomise Move</button> <button className={`${trainer.pokedollars<2? "ptsCost red" : "ptsCost"}`}>2 pts</button>
        </div>
    )
}

export default RandomiseMove;