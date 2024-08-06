import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Table } from 'react-bootstrap';
import { Link } from 'react-router-dom';

function WebBoardList(props) {

    const [boardList, setBoardList] = useState([]);
    useEffect(()=>{
        // ajax, fetch, primise ... 비동기 통신
        axios({
            url:"/api/board/list", // WebBoardRestController
            method:"get"
        }).then((response)=>{
            console.log(response.data);
            setBoardList(response.data);
        }).catch((error)=>{
            console.log(error);
        });
        
    }, []); // 의존 배열이 빈 배열이면 최초 Rendering시 1회 




    return (
        <div>
            <h1>Board List</h1>
        <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>title</th>
            <th>content</th>
            <th>writer</th>
            <th>regDate</th>
            <th>updateDate</th>
            <th>댓글수</th>
          </tr>
        </thead>
        <tbody>
            {boardList.map((board, index)=>(
                <tr key={board.bno}>
                    <td>
                        <Link to={`/webboard/detail/${board.bno}`}>{board.bno}</Link>
                    </td>
                    <td>{board.title}</td>
                    <td>{board.content}</td>
                    <td>{board.mname}</td>
                    <td>{board.regdate}</td>
                    <td>{board.updatedate}</td>
                    <td>{board.replyCount}</td>
                </tr>
            ))}
        </tbody>
        </Table>
        </div>
    );
}

export default WebBoardList;<h1>WebBoardList</h1>