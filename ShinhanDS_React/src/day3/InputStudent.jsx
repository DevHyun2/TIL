import React from 'react';
import { Form, InputGroup } from 'react-bootstrap';

function InputStudent({member, changeHandler}) {
  return (
    <div>
      <h2>학생정보 입력</h2>      
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">학생이름</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={member.name}
          name="name"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">이메일</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={member.email}
          name="email"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">나이</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={member.age}
          name="age"
        />
      </InputGroup>
    </div>
  );
}

export default InputStudent;