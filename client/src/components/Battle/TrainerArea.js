import React, {useState, useEffect} from 'react';
import TrainerSprite from './TrainerSprite';
import ActivePokemon from './ActivePokemon';
import Bench from './Bench'

const TrainerArea = () => {
    return (
        <div class="trainerArea trainerArea1">
            <div class="trainerOuter">
                <TrainerSprite/>
                <Bench/>
            </div>
            <div class="trainerInner">
                <ActivePokemon/>
            </div>
        </div>
    )
}

export default TrainerArea;