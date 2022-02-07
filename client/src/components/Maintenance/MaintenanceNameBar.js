import React, {useState, useEffect} from 'react';

const MaintenanceNameBar = ({pokemon}) => {

    // console.log(activePokemon)
    
    return (
        <div class="maintenanceNameBar">
        <p>{pokemon.name}</p>
        </div>
    )
}

export default MaintenanceNameBar;