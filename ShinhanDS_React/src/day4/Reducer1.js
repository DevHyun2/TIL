import React from 'react';

function Reducer1(state,action){
    switch(action.type){
        case "PLUS": return state+1;
        case "MINUS": return state-1;
        default: return state;
    }
}
export default Reducer1;