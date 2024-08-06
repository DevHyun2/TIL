import React from 'react';
import { Table } from 'react-bootstrap';

function DisplayComponent({changeHandler, addHandler,memberList}) {
    return (
        <div>
            <h4>멤버 목록</h4>
      <Table striped bordered hover>
      <thead>
        <tr>
          <th>#</th>
          <th>이름</th>
          <th>전화번호</th>
          <th>Active</th>
        </tr>
      </thead>
      <tbody>
      {memberList.map((mem,seq)=>(
             <tr key={mem.mid}>
             <td>{mem.mid}</td>
             <td>{mem.name}</td>
             <td>{mem.phone}</td>
             <td>{mem.active?"활동중":"잠적"}</td>
           </tr>
            ))}
            </tbody>
            </Table>
        </div>
    );
}

export default DisplayComponent;