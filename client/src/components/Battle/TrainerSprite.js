import React, {useState, useEffect} from 'react';



const TrainerSprite = ({trainer}) => {
    // console.log(process.env.PUBLIC_URL)
    return (
        <div class="trainerSprite">
        <img src={process.env.PUBLIC_URL + `${trainer.avatar}`}></img>
    
        </div>
    )
}

export default TrainerSprite;