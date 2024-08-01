import { useState } from 'react';
import { Button, Card, Form, InputGroup, ListGroup } from 'react-bootstrap';

//class component에서 상태관리를 위해 this.state 사용, 값 변경은 setState()
//function component에서 상태관리를 위해 useState() 함수 사용

const initStudent = { stdId: 1, stdName: "민영킴", major: "컴공" };

function State4(props) {
  //1건의 객체
  const [student, setStudent] = useState({ initStudent });
  //여러건의 객체
  const [studentList, setStudentList] = useState([initStudent]);
  const changeHandler = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };
  const addHandler = () => {
    setStudentList([...studentList, student]);
  };
  return (
    <div>
      <h2>학생정보 입력</h2>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">학생번호</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.stdId}
          name="stdId"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">학생이름</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.stdName}
          name="stdName"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">전공</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.major}
          name="major"
        />
      </InputGroup>
      <Button onClick={addHandler}>학생Add</Button>
      <h2>학생들의 목록</h2>
      <Card style={{ width: '18rem' }}>
        <ListGroup variant="flush">
          {studentList.map((item, index)=>(
            <ListGroup.Item key={index}>{item.stdName}학생의 전공은{item.major}</ListGroup.Item>
          ))}
        </ListGroup>
      </Card>
    </div>
  );
}

export default State4;