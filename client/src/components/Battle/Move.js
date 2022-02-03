import React, {useState, useEffect} from 'react';

const moveName = "Fire Spin"

const Move = ({activePokemon}) => {

// console.log(activePokemon.ActiveMove.name)

    return (
        <div class="moveName">
        {activePokemon.ActiveMove.name}
        </div>
    )
}

export default Move;