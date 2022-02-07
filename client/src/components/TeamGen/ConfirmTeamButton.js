import React, {useState, useEffect} from 'react';

const ConfirmTeamButton = ({SelectedPokemonState, handleTeamSubmit, handleScreenState}) => {

    const handleclick = () => {
        handleTeamSubmit()
    }

    return (
        <div class="maintenanceButton">
            <button onClick={handleclick}>Confirm Team</button>
        </div>
    )
}

export default ConfirmTeamButton;