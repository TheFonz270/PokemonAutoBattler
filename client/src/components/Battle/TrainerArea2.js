import React, {useState, useEffect} from 'react';
import TrainerSprite from './TrainerSprite';
import ActivePokemon from './ActivePokemon';
import Bench from './Bench'

const TrainerArea2 = ({trainer, PokemonState, PokemonHP, activePokemon}) => {

    // const activePokemon = trainer.pokemons.find(pokemon => pokemon.isFainted == false);

    return (
        <div class="trainerArea trainerArea2">
            <div class="trainerInner">
                <ActivePokemon PokemonState={PokemonState} PokemonHP={PokemonHP} activePokemon={activePokemon} />
            </div>
            <div class="trainerOuter">
                <TrainerSprite trainer={trainer}/>
                <Bench trainer={trainer}/>
            </div>
        </div>
    )
}

export default TrainerArea2;