import React, { useState } from 'react';
import { Button, Form, InputGroup, Table } from 'react-bootstrap';

function StateTest2(props) {
  const [member, setMember] = useState({name:"길동", age:25});
  const [memberList, setMemberList] = useState([member, member, member]);
  const f1 = () => {
    var obj = {name:"홍", age:30};
    obj["age"] = 40;
    obj.age = 50;
    console.log(obj);
  };
  f1();
  const onMemberChangeHandler = (e) => {
    var newMember = {...member, [e.target.name]:e.target.value}; //비동기 처리됨
    setMember(newMember);
    console.log(
      "setMember 비동기 처리되기 때문에 setting하고 출력이 아님",
      newMember
    )
  };
  const addHandler = () => {
    setMemberList([...memberList, member])
  };
  return (
    <div>
      <h1>이름과 나이를 입력하세요.</h1>
      <h3>이름:{member.name}</h3>
      <h3>나이:{member.age}</h3>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">이름</InputGroup.Text>
        <Form.Control
          name = "name"
          defaultValue={member.name}
          onChange = {onMemberChangeHandler}
          aria-label="Username"
          aria-describedby="basic-addon1"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">나이</InputGroup.Text>
        <Form.Control
          name = "age"
          defaultValue={member.age}
          onChange = {onMemberChangeHandler}
          aria-label="UserAge"
          aria-describedby="basic-addon1"
        />
      </InputGroup>
      <Button variant="success" onClick={addHandler}>멤버추가</Button>
      <hr/>
      <h3>멤버목록</h3>
      <Table striped bordered hover>
      <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>age</th>
        </tr>
      </thead>
      <tbody>
      {memberList.map((item, seq) => (
        <tr key={seq}>
          <td>{seq + 1}</td>
          <td>{item.name}</td>
          <td>{item.age}</td>
        </tr>
      ))}
      </tbody>
      </Table>
    </div>
  );
}

export default StateTest2;