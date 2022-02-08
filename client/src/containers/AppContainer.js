import React, {useState, useEffect} from 'react';
import BattleContainer from './BattleContainer';
import MaintenanceContainer from './MaintenanceContainer';
import TeamGeneratorContainer from './TeamGeneratorContainer';
// import postTrainers from '../services/battleService';


function AppContainer() {

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

const surf = {
  name : "Surf",
  type : "Water",
  DamageType : "Special",
  Damage : 90
}

const aura_sphere = {
  name : "Aura Sphere",
  type : "Fighting",
  DamageType : "Special",
  Damage : 80
}

const confusion = {
  name : "Confusion",
  type : "Psychic",
  DamageType : "Special",
  Damage : 60
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
const squirtle = {
  pokemonId : 7,
  name : "squirtle",
  AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/7.png",
  ActiveMove : surf,
  level : 17,
  canEvolve : true,
  currentHp : 130,
  types : ["Water"],
  isFainted : false

}

const ralts = {
  pokemonId : 280,
  name : "ralts",
  AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/280.png",
  ActiveMove : confusion,
  level : 17,
  canEvolve : true,
  currentHp : 80,
  types : ["psychic", "fairy"],
  isFainted : false

}

const riolu = {
  pokemonId : 447,
  name : "riolu",
  AvatarImage : "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/447.png",
  ActiveMove : aura_sphere,
  level : 17,
  canEvolve : true,
  currentHp : 110,
  types : ["fighting"],
  isFainted : false
}

const trainer = {
    team : [quilava, pikachu, eevee, squirtle, ralts, riolu],
    avatar : "/img/PokemonTrainer.png",
    pokeDollars : 30
}

const trainer2 = {
  team : [squirtle, ralts, riolu],
    avatar : "/img/VStrainers/Youngster.png",
    pokeDollars : 10
}


    const [ScreenState, setScreenState] = useState("teamGen"); 
    const [SelectedPokemonState, setSelectedPokemonState] = useState([]);
    const [trainerState, setTrainerState] = useState(null);
    const [trainer2State, setTrainer2State] = useState(null);
    const [teamSelectErrorState, setTeamSelectErrorState] = useState(false);
    const [importState, setImportState] = useState(null);

    const handleScreenState = (newState) => {
      setScreenState(newState)
    }

    const handleTeamSubmit = () => {
      if (SelectedPokemonState.length == 3) {
      trainerState.pokemons = SelectedPokemonState;
      handleScreenState("maintenance")
      } 
      else {
        console.log("Error please select three Pokemon")
        setTeamSelectErrorState(true)
      }
    }

    const baseURL = 'http://localhost:8080/'

      
    const postTrainers = () => {
      // POST request using fetch with async/await
      
      // this.setState({ postId: data.id });
  }

    useEffect( () => {
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' }
        };
        const response = fetch(baseURL + "trainers", requestOptions)
        .then(response => response.json())
        .then(data => {console.log(data)
          setImportState(data)
          setTrainerState(data[0])
          setTrainer2State(data[1])
        })
        
    }, [])




      if (!trainerState) {
        return (
            <>
            "Loading..."
            </>
        )
        } 

  return (
    <main>
      {ScreenState=="teamGen"?<TeamGeneratorContainer trainer={trainerState} handleScreenState={handleScreenState} handleTeamSubmit={handleTeamSubmit} SelectedPokemonState={SelectedPokemonState} setSelectedPokemonState={setSelectedPokemonState} teamSelectErrorState={teamSelectErrorState}/>:null }
      {ScreenState=="maintenance"?<MaintenanceContainer trainer={trainerState} setTrainerState={setTrainerState} handleScreenState={handleScreenState}/>:null }
      {ScreenState=="battle"?<BattleContainer />:null }
    </main>
  );
}

export default AppContainer;