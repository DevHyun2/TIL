import { useState } from 'react';
import { Button, Card, ListGroup } from 'react-bootstrap';
import InputStudent from './InputStudent';

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
      <InputStudent student={student} changeHandler={changeHandler}></InputStudent>
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