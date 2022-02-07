import React, {useState, useEffect} from 'react';

const LevelUp = ({trainer, pokemon}) => {

    return (
        <div class="LevelUp">
            <button>Level Up!</button> <button class="ptsCost">10 pts</button>
        </div>
    )
}

export default LevelUp;