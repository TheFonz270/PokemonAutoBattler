import React, {useState, useEffect} from 'react';
import pokeball from "../../assets/img/pokeball.png"

// const pokemons = ["pokemon1", "pokemon2", "pokemon3"]


const Bench = ({trainer}) => {

    // const pokemons = trainer.pokemons
    // console.log(trainer.pokemons)

    return (
        <div class="Bench">
        {trainer.pokemons.map((pokemon) => 
            <img src={pokeball} class="BenchPokeball"></img>
        )}
        </div>
    )
}

export default Bench;