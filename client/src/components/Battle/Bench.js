import React, {useState, useEffect} from 'react';
import pokeball from "../../assets/img/pokeball.png"

// const team = ["pokemon1", "pokemon2", "pokemon3"]


const Bench = ({trainer}) => {

    // const team = trainer.team
    console.log(trainer.team)

    return (
        <div class="Bench">
        {trainer.team.map((pokemon) => 
            <img src={pokeball} class="BenchPokeball"></img>
        )}
        </div>
    )
}

export default Bench;