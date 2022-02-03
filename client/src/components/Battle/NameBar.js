import React, {useState, useEffect} from 'react';

// const tempName = "Quilava"

const NameBar = ({activePokemon}) => {

    // console.log(activePokemon)
    
    return (
        <div class="nameBar">
        {activePokemon.name}
        </div>
    )
}

export default NameBar;