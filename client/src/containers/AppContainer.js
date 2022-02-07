import React, {useState, useEffect} from 'react';
import BattleContainer from './BattleContainer';
import MaintenanceContainer from './MaintenanceContainer';


function AppContainer() {


    const [ScreenState, setScreenState] = useState("maintenance"); 

    const handleScreenState = (newState) => {
      setScreenState(newState)
    }

  return (
    <main>
      {ScreenState=="maintenance"?<MaintenanceContainer handleScreenState={handleScreenState}/>:null }
      {ScreenState=="battle"?<BattleContainer />:null }
    </main>
  );
}

export default AppContainer;