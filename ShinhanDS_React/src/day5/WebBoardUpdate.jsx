import React from 'react';
import { useLocation } from 'react-router-dom';

function WebBoardUpdate(props) {
    const location = useLocation();
    const originalBoard = location.state.board;
    console.log(originalBoard);
    
    return (
        <div>
           <p>update</p> 
        </div>
    );
}

export default WebBoardUpdate;