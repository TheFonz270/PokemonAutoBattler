import React, {useState, useEffect} from 'react';
import BattleContainer from './BattleContainer';
import MaintenanceContainer from './MaintenanceContainer';
import TeamGeneratorContainer from './TeamGeneratorContainer';
import { teamSubmition } from '../services/battleService';
// import postTrainers from '../services/battleService';



function AppContainer() {




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
      teamSubmition(trainerState.id, SelectedPokemonState)
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
          <div class="wrapper">
            <div class="pokeball">
            </div>
          </div>
        )
        } 

  return (
    <main>
      {ScreenState=="teamGen"?<TeamGeneratorContainer trainer={trainerState} handleScreenState={handleScreenState} handleTeamSubmit={handleTeamSubmit} SelectedPokemonState={SelectedPokemonState} setSelectedPokemonState={setSelectedPokemonState} teamSelectErrorState={teamSelectErrorState}/>:null }
      {ScreenState=="maintenance"?<MaintenanceContainer trainer={trainerState} setTrainerState={setTrainerState} handleScreenState={handleScreenState}/>:null }
      {ScreenState=="battle"?<BattleContainer/>:null }
    </main>
  );
}

export default AppContainer;