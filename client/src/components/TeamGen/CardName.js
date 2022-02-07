import React, {useState, useEffect} from 'react';

const CardName = ({pokemon}) => {

    // console.log(activePokemon)
    
    return (
        <div class="CardNameBar">
        <p>{pokemon.name}</p>
        </div>
    )
}

export default CardName;