import React, {useState, useEffect} from 'react';

const LevelUp = ({trainer, pokemon, handleLevelUp}) => {

    const handleLUClick = () => {
        handleLevelUp(pokemon.id)
    }

    return (
        <div class="LevelUp">
            <button onClick={handleLUClick}>Level Up!</button> <button className={`${trainer.pokedollars<10? "ptsCost red" : "ptsCost"}`}>10 pts</button>
        </div>
    )
}

export default LevelUp;