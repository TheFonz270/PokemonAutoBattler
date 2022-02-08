import React, {useState, useEffect} from 'react';
import MaintenanceArea from '../components/Maintenance/MaintenanceArea';
import BattleButton from '../components/Maintenance/BattleButton';
import PtsBank from '../components/Maintenance/PtsBank';


const MaintenanceContainer = ({trainer, handleScreenState}) => {
    return (
        <>
        <MaintenanceArea trainer={trainer}/>
        <div class="MaintenanceFooter">
        <PtsBank trainer={trainer}/>
        <BattleButton trainer={trainer} handleScreenState={handleScreenState}/>
        </div>
        </>
    )
}

export default MaintenanceContainer;