import React, {useState, useEffect} from 'react';

const HPBar = ({Pokemon1HP}) => {



    return (
        <div class="HpBar">
            <div style={{width: `${ Pokemon1HP }%`}} className={`${Pokemon1HP<51 && Pokemon1HP>10? "yellow" : ""} ${Pokemon1HP<11? "red" : ""}`}></div>
        </div>
    )
}

export default HPBar;