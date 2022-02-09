import React, {useState, useEffect} from 'react';
import TeamGenArea from '../components/TeamGen/TeamGenArea';
import ConfirmTeamButton from '../components/TeamGen/ConfirmTeamButton';
import TeamSelectError from '../components/TeamGen/TeamSelectError';
import song from '../assets/music/battle_trainer_battle.mp3'


const TeamGeneratorContainer = ({trainer, handleScreenState, handleTeamSubmit, SelectedPokemonState, setSelectedPokemonState, teamSelectErrorState}) => { 
    

    const handleClick = (pokemon) => {
        console.log("SelectedPokemonState : " + SelectedPokemonState)
        if (SelectedPokemonState.some(p => p.pokemonId == pokemon.pokemonId)) {
            console.log("duplicate")
            const newSelected = SelectedPokemonState.filter(p => p.pokemonId !== pokemon.pokemonId)
            setSelectedPokemonState(newSelected)
        }
        else {
        setSelectedPokemonState([...SelectedPokemonState,pokemon])
        }
     }


    return (
        <>
        < TeamGenArea handleClick={handleClick} trainer={trainer}/>
        {teamSelectErrorState==true?< TeamSelectError /> :null}
        < ConfirmTeamButton SelectedPokemonState={SelectedPokemonState} handleTeamSubmit={handleTeamSubmit} handleScreenState={handleScreenState}/>
        </>
    )
}

export default TeamGeneratorContainer;