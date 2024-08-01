import React, { useState } from 'react';

function StateTest3(props) {
  const [student, setStudent] = useState({username:"정성진", email:"jsj@naver", phone:"010-1111-1111"});
  const studentChangeHandler = (e) => {
    setStudent({...student, [e.target.username]:e.target.value});
  };
  return (
    <div>
      <p>이름 : {student.username}</p>
      <p>email : {student.email}</p>
      <p>phone : {student.phone}</p>
      <hr/>
      이름:<input name='username' onChange={studentChangeHandler} value={student.username}/>
      email:<input name='email' onChange={studentChangeHandler} value={student.email}/>
      phone:<input name='phone' onChange={studentChangeHandler} value={student.phone}/>
    </div>
  );
}

export default StateTest3;
