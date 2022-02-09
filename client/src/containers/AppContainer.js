import React, {useState, useEffect} from 'react';
import BattleContainer from './BattleContainer';
import MaintenanceContainer from './MaintenanceContainer';
import TeamGeneratorContainer from './TeamGeneratorContainer';
import { teamSubmition } from '../services/battleService';
// import { battleSubmition } from '../services/battleService'
// import postTrainers from '../services/battleService';



function AppContainer() {




    const [ScreenState, setScreenState] = useState("teamGen"); 
    const [SelectedPokemonState, setSelectedPokemonState] = useState([]);
    const [trainerState, setTrainerState] = useState(null);
    const [trainer2State, setTrainer2State] = useState(null);
    const [teamSelectErrorState, setTeamSelectErrorState] = useState(false);
    const [importState, setImportState] = useState(null);

    const [BattleScriptState, setBattleScriptState] = useState(null)

    const handleScreenState = (newState) => {
      setScreenState(newState)
    }

    const handleTeamSubmit = () => {
      if (SelectedPokemonState.length == 3) {
      trainerState.pokemons = SelectedPokemonState;

      const selectedIds = SelectedPokemonState.map(function (pokemon) {
        return pokemon.id;
      });

      teamSubmition(trainerState.id, selectedIds)
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
      const handleBattleSubmit = (id) => {
        const requestOptions = {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' }
      };
      const response = fetch(baseURL + `battles/${id}`, requestOptions)
      .then(response => response.json())
      .then(data => {console.log(data)
        setBattleScriptState(data.battleScript)
        setTrainerState(data.trainers[0])
        setTrainer2State(data.trainers[1])
      })
        handleScreenState("battle")
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
          <div class="wrapper">
            <div class="pokeball">
            </div>
          </div>
        )
        } 

  return (
    <main>
      {ScreenState=="teamGen"?<TeamGeneratorContainer trainer={trainerState} handleScreenState={handleScreenState} handleTeamSubmit={handleTeamSubmit} SelectedPokemonState={SelectedPokemonState} setSelectedPokemonState={setSelectedPokemonState} teamSelectErrorState={teamSelectErrorState}/>:null }
      {ScreenState=="maintenance"?<MaintenanceContainer trainer={trainerState} setTrainerState={setTrainerState} handleBattleSubmit={handleBattleSubmit}/>:null }
      {ScreenState=="battle"?<BattleContainer BattleScriptState={BattleScriptState} setBattleScriptState={setBattleScriptState} trainer={trainerState} setTrainer={setTrainerState} trainer2={trainer2State} setTrainer2={setTrainer2State} />:null }
    </main>
  );
}

export default AppContainer;