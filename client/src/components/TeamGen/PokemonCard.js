import React, {useState, useEffect} from 'react';
import CardName from './CardName';
import CardTypes from './CardTypes';
import CardSprite from './CardSprite'

const PokemonCard = ({handleClick, pokemon}) => {

    const [SelectedState, setSelectedState] = useState(null); 

    
    const handleClick2 = () => {
        if (SelectedState == null) {
        setSelectedState("selected")
        handleClick(pokemon)
    }
    else {
        setSelectedState(null)
        handleClick(pokemon)
    }
}

    return (
        <div class={`pokemonCard ${SelectedState}`}  onClick={handleClick2}>
            <CardName pokemon={pokemon}/>
            <CardTypes pokemon={pokemon}/>
            <CardSprite pokemon={pokemon}/>
        </div>
    )
}

export default PokemonCard;