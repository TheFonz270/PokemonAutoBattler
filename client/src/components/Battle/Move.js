import React, {useState, useEffect} from 'react';

const Move = ({activePokemon}) => {

// console.log(activePokemon.ActiveMove.name)

    return (
        <div className={`${activePokemon.activeMove.type} moveName`} >
        {activePokemon.activeMove.name}
        </div>
    )
}

export default Move;