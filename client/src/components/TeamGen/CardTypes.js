import React, {useState, useEffect} from 'react';

const CardTypes = ({pokemon}) => {

    const types = pokemon.types;
    

    return (
        <>
        {types.length>0?<img src={process.env.PUBLIC_URL + `/img/types/${pokemon.types[0]}IC.png`} class="type"></img>:null }
        {types.length==2?<img src={process.env.PUBLIC_URL + `/img/types/${pokemon.types[1]}IC.png`} class="type"></img>:null }
        </>
    )
}

export default CardTypes;