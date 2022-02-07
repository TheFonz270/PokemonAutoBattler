import React, {useState, useEffect} from 'react';
import TeamGenArea from '../components/TeamGen/TeamGenArea';
import ConfirmTeamButton from '../components/TeamGen/ConfirmTeamButton';

const TeamGeneratorContainer = ({trainer, handleScreenState, handleTeamSubmit, SelectedPokemonState, setSelectedPokemonState}) => { 
    

    const handleClick = (pokemon) => {
        if (SelectedPokemonState.includes(pokemon)) {
        setSelectedPokemonState(SelectedPokemonState.slice(SelectedPokemonState.indexOf(pokemon, 1)))
        }
        else {
        setSelectedPokemonState([...SelectedPokemonState,pokemon])
        }
     }


    return (
        <>
        < TeamGenArea handleClick={handleClick} trainer={trainer}/>
        < ConfirmTeamButton SelectedPokemonState={SelectedPokemonState} handleTeamSubmit={handleTeamSubmit} handleScreenState={handleScreenState}/>
        </>
    )
}

export default TeamGeneratorContainer;