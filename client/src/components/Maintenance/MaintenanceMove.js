import React, {useState, useEffect} from 'react';

const MaintenanceMove = ({pokemon}) => {

    return (
        <div class="maintenanceMove">
        <p class={`${pokemon.activeMove.type}`}>{pokemon.activeMove.name}</p>
        </div>
    )
}

export default MaintenanceMove;