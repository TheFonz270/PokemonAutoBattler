import React, {useState, useEffect} from 'react';
import TrainerArea from './TrainerArea';
import TrainerArea2 from './TrainerArea2';

const Arena = () => {
    const [Pokemon1State, setPokemon1State] = useState("normal");
    const [Pokemon1HP, setPokemon1HP] = useState(100);
    const [Pokemon2State, setPokemon2State] = useState("normal");
    const [Pokemon2HP, setPokemon2HP] = useState(100);


    const fire_punch = {
        name : "Fire Punch",
        type : "Fire",
        DamageType : "Physical",
        Damage : 75
    }

    const iron_head = {
        name : "Iron Head",
        type : "Steel",
        DamageType : "Physical",
        Damage : 80
    }

    const quilava = {
        id : 159,
        name : "quilava",
        sprite : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/156.png",
        move : fire_punch,
        canEvolve : true,
        currentHp : 120

    }

    const honedge = {
        id : 679,
        name : "honedge",
        sprite : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/679.png",
        move : iron_head,
        canEvolve : true,
        currentHp : 100

    }

    const trainer1 = {
        team : [quilava, honedge],
        avatar : "/img/PokemonTrainer.png"
    }

    const trainer2 = {
        team : [honedge, quilava],
        avatar : "/img/VStrainers/Youngster.png"
    }

    
const Pokemon1Attacks = () => {
    /* Pokemon 2 flashes*/
    /* Pokemon 2's hp decreases */
}

const Pokemon2Attacks = () => {
    /* Pokemon 1 flashes*/
    /* Pokemon 1's hp decreases */

}

const Pokemon1Faints = () => {
    /* Pokemon 1 shrinks and hides */
}

const Pokemon2Faints = () => {
    /* Pokemon 2 shrinks and hides */
}

const NewPokemon1 = () => {
    /* New active pokemon is selected */
    /* Pokemon 1 goes from hidden to shown */
}

const NewPokemon2 = () => {
    /* New active pokemon is selected */
    /* Pokemon 1 goes from hidden to shown */
}

const handleDamage = () => {
    setPokemon1State("damaged")
    setTimeout(() => {
        setPokemon1State("normal")
      }, 1000);
    
}

const handleFaint = () => {
    setPokemon1State("fainting")
    setTimeout(() => {
        setPokemon1State("normal")
      }, 1000);
}

const handleSummon = () => {
    setPokemon1State("summoned")
    setTimeout(() => {
        setPokemon1State("normal")
      }, 1000);
}

const handlePokemon1HP = (int) => {
    setPokemon1HP(int);
}

const handlePokemon2HP = (int) => {
    setPokemon2HP(int);
}

    return (
        <div id="Arena">
            <TrainerArea 
                Pokemon1State = {Pokemon1State} 
                handleDamage={handleDamage}  
                handleFaint={handleFaint} 
                handleSummon={handleSummon}
                Pokemon1HP={Pokemon1HP}
                handlePokemon1HP={handlePokemon1HP}
                trainer={trainer1}
                />
            <TrainerArea2
            trainer={trainer2}/>
        </div>
    )
}

export default Arena;