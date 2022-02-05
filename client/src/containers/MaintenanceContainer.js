import React, {useState, useEffect} from 'react';
import MaintenanceArea from '../components/Maintenance/MaintenanceArea';
import BattleButton from '../components/Maintenance/BattleButton';

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

const thunderbolt = {
    name : "Thunderbolt",
    type : "Electric",
    DamageType : "Special",
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
    types : ["Fire"],
    isFainted : false

}

const pikachu = {
    pokemonId : 25,
    name : "pikachu",
    AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/25.png",
    ActiveMove : thunderbolt,
    level : 17,
    canEvolve : true,
    currentHp : 120,
    types : ["Electric"],
    isFainted : false

}

const eevee = {
    pokemonId : 133,
    name : "eevee",
    AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/133.png",
    ActiveMove : iron_head,
    level : 17,
    canEvolve : true,
    currentHp : 90,
    types : ["Normal"],
    isFainted : false

}

const trainer = {
    team : [quilava, pikachu, eevee],
    avatar : "/img/PokemonTrainer.png",
    pokeDollars : 10
}

const MaintenanceContainer = ({handleScreenState}) => {
    return (
        <>
        <MaintenanceArea trainer={trainer}/>
        <BattleButton handleScreenState={handleScreenState}/>
        </>
    )
}

export default MaintenanceContainer;