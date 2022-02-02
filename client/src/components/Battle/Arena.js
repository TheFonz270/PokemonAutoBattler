import React, {useState, useEffect} from 'react';
import TrainerArea from './TrainerArea';
import TrainerArea2 from './TrainerArea2';

const Arena = () => {
    const [Pokemon1State, setPokemon1State] = useState("normal");
    const [Pokemon1MAXHP, setPokemon1MAXHP] = useState(100);
    const [Pokemon1HP, setPokemon1HP] = useState(100);
    const [Pokemon2State, setPokemon2State] = useState("normal");
    const [Pokemon2MAXHP, setPokemon2MAXHP] = useState(100);
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
        pokemonId : 159,
        name : "quilava",
        AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/156.png",
        ActiveMove : fire_punch,
        level : 17,
        canEvolve : true,
        currentHp : 120,
        types : ["fire"],
        isFainted : false

    }

    const honedge = {
        pokemonId : 679,
        name : "honedge",
        AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/679.png",
        ActiveMove : iron_head,
        level : 17,
        canEvolve : true,
        currentHp : 100,
        types : ["fire"],
        isFainted : false

    }

    const trainer1 = {
        team : [quilava, honedge],
        avatar : "/img/PokemonTrainer.png",
        pokeDollars : 10
    }

    const trainer2 = {
        team : [honedge, quilava],
        avatar : "/img/VStrainers/Youngster.png",
        pokeDollars : 10
    }

    const BattleScript1 = {
            playerFirst : 1,
            firstDamageDealt : 23,
            P2CurrentHP: 77,
            didP2Faint : 0,
            secondDamageDealt : 18,
            P1CurrentHP: 102,
            didP1Faint : 0,
            didP2NewMon : 0,
            didP1NewMon : 0,
            P1OutOfMons : 0,
            P2OutOfMons : 0
    }

const RunBattle = (BattleScript, trainer1, trainer2) => {
    setPokemon1MAXHP(trainer1.team[0].currentHP)
    setPokemon2MAXHP(trainer2.team[0].currentHP)

}

    
const Pokemon1Attacks = () => {
    /* Pokemon 2 flashes*/
    handleDamageAnimation(2)
    /* Pokemon 2's hp decreases */

}

const Pokemon2Attacks = () => {
    /* Pokemon 1 flashes*/
    /* Pokemon 1's hp decreases */

}

const handleDamage = () => {

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

const handleDamageAnimation = (int) => {
    if (int == 1) {
    setPokemon1State("damaged")
    setTimeout(() => {
        setPokemon1State("normal")
      }, 1000);
    }
    if (int == 2) {
    setPokemon2State("damaged")
    setTimeout(() => {
        setPokemon2State("normal")
      }, 1000);
    }
    
}

const handleFaintAnimation = () => {
    setPokemon1State("fainting")
    setTimeout(() => {
        setPokemon1State("normal")
      }, 1000);
}

const handleSummonAnimation = () => {
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
                handleDamageAnimation={handleDamageAnimation}  
                handleFaintAnimation={handleFaintAnimation} 
                handleSummonAnimation={handleSummonAnimation}
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