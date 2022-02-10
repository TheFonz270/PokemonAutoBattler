import React, {Component, useState, useEffect} from 'react';
import Arena from '../components/Battle/Arena';
import MusicPlayer from '../components/Battle/MusicPlayer';

const BattleContainer = ({BattleScriptState, setBattleScriptState, trainer, setTrainer, trainer2, setTrainer2, track1, play1, pause1}) => {

    if (!BattleScriptState || !trainer || !trainer2) {
        return (
            <div class="wrapper">
                <div class="pokeball">
                </div>
            </div>
        )
        } 


    return (
        <>
        <Arena BattleScript={BattleScriptState} setBattleScriptState={setBattleScriptState} trainer={trainer} setTrainer={setTrainer} trainer2={trainer2} setTrainer2={setTrainer2} track1={track1} play1={play1} pause1={pause1}/>
        {/* <MusicPlayer/> */}
        </>
    )
}

export default BattleContainer;