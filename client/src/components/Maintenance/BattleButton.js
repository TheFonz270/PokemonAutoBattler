import React, {useState, useEffect} from 'react';

const BattleButton = ({trainer, handleScreenState}) => {

    const handleclick = () => {
        handleScreenState("battle")
    }

    return (
        <div class="battleButton">
            <button onClick={handleclick}>To Battle!</button>
        </div>
    )
}

export default BattleButton;