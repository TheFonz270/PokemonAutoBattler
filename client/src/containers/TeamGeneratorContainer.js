import React, {useState, useEffect} from 'react';
import TeamGenArea from '../components/TeamGen/TeamGenArea';

const TeamGeneratorContainer = ({trainer}) => {
    return (
        <>
        < TeamGenArea trainer={trainer}/>
        </>
    )
}

export default TeamGeneratorContainer;