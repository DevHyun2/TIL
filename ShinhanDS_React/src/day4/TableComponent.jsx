import React from "react";
import { Button, Table } from "react-bootstrap";

function TableComponent({ removeHandler, updateHandler, memberList }) {
  const f_update = (e) => {
    //JavaScript: getAttribute, attr:jQuery
    const mid = e.target.getAttribute("data-mid");
    updateHandler(mid);
  };
  const f_delete = (e) => {
    const mid = e.target.getAttribute("data-mid");
    removeHandler(mid);
  };
  return (
    <div>
      <h4>Member목록</h4>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>전화번호</th>
            <th>Active</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {memberList.map((mem, seq) => (
            <tr key={mem.mid}>
              <td>{mem.mid}</td>
              <td>{mem.name}</td>
              <td>{mem.phone}</td>
              <td>
                <div className="checkBox_col">
                  <input
                  type="checkbox"
                  defaultChecked={mem.active} 
                  name="isDone"
                  data-mid={mem.mid}
                  onChange={f_update}
                  />
                </div>
              </td>
              <td>{mem.active ? "활동중" : "잠적"}</td>
              <td>-
                <Button onClick={f_delete} data-mid={mem.mid}>
                  삭제
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default TableComponent;
