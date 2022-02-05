import React, {useState, useEffect} from 'react';

const RandomiseMove = ({trainer, pokemon}) => {

    return (
        <div class="randomiseMove">
            <button>Randomise Move</button> <button class="ptsCost">2 pts</button>
        </div>
    )
}

export default RandomiseMove;