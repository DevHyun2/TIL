import React, { useCallback, useReducer } from 'react';
import { Button } from 'react-bootstrap';
import Reducer1 from './Reducer1';

//상태관리를 Component내에서 직접한다 : useState()
//상태관리를 Component외부에서 직접한다 : useReducer()

//업무로직(상태변경) => 외부파일로 저장 


function ReducerTest(props) {
    //const [count, setCount] = useState(0);
    const [count, dispatch] = useReducer(Reducer1,0);
    const clickHandler = useCallback((e) => {
        if(e.target.innerText === '증가'){
            //setCount(count+1);
            dispatch({type:"PLUS"});
        }else{
            //setCount(count-1);
            dispatch({type:"MINUS"});
        }
    },
    //eslint-disable-next-line react-hooks/exhaustive-deps
    [count]
);
    
    return (
        <div>
            <h2>현재count:{count}</h2>
            <Button onClick={clickHandler}>증가</Button>
            <Button onClick={clickHandler}>감소</Button>
        </div>
    );
}

export default ReducerTest;