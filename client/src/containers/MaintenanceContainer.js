import React, {useState, useEffect} from 'react';
import MaintenanceArea from '../components/Maintenance/MaintenanceArea';
import BattleButton from '../components/Maintenance/BattleButton';


const MaintenanceContainer = ({trainer, handleScreenState}) => {
    return (
        <>
        <MaintenanceArea trainer={trainer}/>
        <BattleButton handleScreenState={handleScreenState}/>
        </>
    )
}

export default MaintenanceContainer;