import React, {useState, useEffect} from 'react';
import TrainerSprite from './TrainerSprite';
import ActivePokemon from './ActivePokemon';
import Bench from './Bench'

const TrainerArea2 = () => {
    return (
        <div class="trainerArea trainerArea2">
            <div class="trainerInner">
                <ActivePokemon/>
            </div>
            <div class="trainerOuter">
                <TrainerSprite/>
                <Bench/>
            </div>
        </div>
    )
}

export default TrainerArea2;