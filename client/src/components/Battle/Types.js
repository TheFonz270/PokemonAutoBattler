import React, {useState, useEffect} from 'react';
import type from "../../assets/img/types/FireIC.png";

const Types = ({activePokemon}) => {

    const types = activePokemon.types;
    // console.log(activePokemon.types[0])

    return (
        <>
        <img src={process.env.PUBLIC_URL + `/img/types/${activePokemon.types[0]}IC.png`} class="type"></img>
        {types.length==2?<img src={process.env.PUBLIC_URL + `/img/types/${activePokemon.types[1]}IC.png`} class="type"></img>:null }
        </>
    )
}

export default Types;