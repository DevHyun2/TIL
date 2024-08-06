import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Form, InputGroup } from 'react-bootstrap';
import { useParams } from 'react-router-dom';

function WebBoardDetail(props) {

    // 파라미터 받기 : 객체로 넘어온다.{"bno":20. "aa":1, "bb":2}
    const {bno} = useParams();
    console.log("매개변수 받기" + bno);

    const [board,setBoard] = useState({});
    useEffect(()=>{
        // ajax, fetch, primise ... 비동기 통신
        axios({
            url:`/api/board/detail/${bno}`, // WebBoardRestController
            method:"get"
        }).then((response)=>{
            console.log(response.data);
            setBoard(response.data); // setBoard 했으니까 board에 들어감
        }).catch((error)=>{
            console.log(error);
        });
        
    }, []);

    return (
        <div>
            <p>WebBoardDetail</p>
            <InputGroup className="mb-3">
                <InputGroup.Text id="basic-addon1">번호</InputGroup.Text>
                <Form.Control name="bno" defaultValue={board.bno}/>
            </InputGroup>
        </div>
    );
}

export default WebBoardDetail;