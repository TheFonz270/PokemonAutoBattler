import React, {useState, useEffect} from 'react';

const MaintenanceMove = ({pokemon}) => {

    return (
        <div class="maintenanceMove">
        <p class={`${pokemon.ActiveMove.type}`}>{pokemon.ActiveMove.name}</p>
        </div>
    )
}

export default MaintenanceMove;