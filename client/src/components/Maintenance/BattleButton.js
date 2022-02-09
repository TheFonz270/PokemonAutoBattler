import React, {useState, useEffect} from 'react';

const BattleButton = ({trainer, handleBattleSubmit}) => {

    const handleclick = () => {
        handleBattleSubmit(trainer.id)
    }

    return (
        <div class="battleButton">
            <button onClick={handleclick}>To Battle!</button>
        </div>
    )
}

export default BattleButton;