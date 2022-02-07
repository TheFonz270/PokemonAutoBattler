import React, {useState, useEffect} from 'react';

const moveName = "Fire Spin"

const Move = ({activePokemon}) => {

// console.log(activePokemon.ActiveMove.name)

    return (
        <div className={`${activePokemon.ActiveMove.type} moveName`} >
        {activePokemon.ActiveMove.name}
        </div>
    )
}

export default Move;