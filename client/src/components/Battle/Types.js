import React, {useState, useEffect} from 'react';

const Types = ({activePokemon}) => {

    const types = activePokemon.types;

    return (
        <>
        {types.length>0?<img src={process.env.PUBLIC_URL + `/img/types/${activePokemon.types[0]}IC.png`} class="type"></img>:null }
        {types.length==2?<img src={process.env.PUBLIC_URL + `/img/types/${activePokemon.types[1]}IC.png`} class="type"></img>:null }
        </>
    )
}

export default Types;