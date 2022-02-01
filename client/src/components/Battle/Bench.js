import React, {useState, useEffect} from 'react';
import pokeball from "../../assets/img/pokeball.png"

const team = ["pokemon1", "pokemon2", "pokemon3"]

const Bench = () => {
    return (
        <div class="Bench">
        {team.map(pokemon => 
            (<img src={pokeball} class="BenchPokeball"></img>)
        )}
        </div>
    )
}

export default Bench;