import React, {useState, useEffect} from 'react';

const RandomisePokemon = ({trainer, pokemon}) => {

    const [CantAfford, setCantAfford] = useState("blue"); 

    const handleRandomisePokemon = () => {
        if (trainer.pokeDollars >=5) {
            trainer.pokeDollars -= 5;

        }
        else {
            setCantAfford("red")

        }

    }

    return (
        <div class="randomisePokemon">
            <button onClick={handleRandomisePokemon}>Randomise Pokemon</button> <button class={`${CantAfford} ptsCost`}>5 pts</button>
        </div>
    )
}

export default RandomisePokemon;