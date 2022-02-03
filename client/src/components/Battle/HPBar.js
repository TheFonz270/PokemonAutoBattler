import React, {useState, useEffect} from 'react';

const HPBar = ({PokemonHP}) => {



    return (
        <div class="HpBar">
            <div style={{width: `${ PokemonHP }%`}} className={`${PokemonHP<51 && PokemonHP>10? "yellow" : ""} ${PokemonHP<11? "red" : ""}`}></div>
            
        </div>
    )
}

export default HPBar;