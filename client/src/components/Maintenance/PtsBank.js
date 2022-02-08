import React, {useState, useEffect} from 'react';

const PtsBank = ({trainer}) => {

    useEffect(()=>{
        console.log(trainer.pokeDollars)
    }, [trainer])

    return (
        <div class="PtsBank">
            Poke$: {trainer.pokeDollars}
        </div>
    )
}

export default PtsBank;