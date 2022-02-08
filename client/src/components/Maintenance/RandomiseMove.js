import React, {useState, useEffect} from 'react';

const RandomiseMove = ({trainer, pokemon, handleRandomiseMove}) => {

    return (
        <div class="randomiseMove">
            <button onClick={handleRandomiseMove}>Randomise Move</button> <button className={`${trainer.pokedollars<2? "ptsCost red" : "ptsCost"}`}>2 pts</button>
        </div>
    )
}

export default RandomiseMove;