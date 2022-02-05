import React, {useState, useEffect} from 'react';

const MaintenanceMove = ({pokemon}) => {

    return (
        <div class="maintenanceMove">
        <p>{pokemon.ActiveMove.name}</p>
        </div>
    )
}

export default MaintenanceMove;