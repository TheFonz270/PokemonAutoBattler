import React, {useState, useEffect} from 'react';

const PtsBank = ({trainer}) => {

    useEffect(()=>{
        console.log(trainer.pokedollars)
    }, [trainer])

    return (
        <div class="PtsBank">
            Poke$: {trainer.pokedollars}
        </div>
    )
}

export default PtsBank;