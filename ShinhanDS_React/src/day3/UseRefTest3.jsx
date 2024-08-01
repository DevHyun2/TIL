import { useEffect, useRef, useState } from 'react';
import { Button } from 'react-bootstrap';
import InputStudent from './InputStudent';

const initMember = {mid:1, name:"ㅇㅁㄱ", age:0, email:"a@gmail.com"};
const initList = [initMember, 
  {mid:2, name:"ㅇㅁㄱ2", age:2, email:"b@gmail.com"},
  {mid:3, name:"ㅇㅁㄱ3", age:4, email:"c@gmail.com"}
]

function UseRefTest3(props) {
  const [member, setMember] = useState(initMember);
  const [memberList, setMemberList] = useState(initList);
  //1.DOM을 선택할 때 사용
  const nameInput1 = useRef();      //document.getElementById("")역할
  const nameInput2 = useRef();
  //2.다시 랜더링 되어도 초기화 되지 않는 변수가 필요하다
  const memberId = useRef(4);

  const clickHandle1 = () => {
    nameInput1.current.focus();
  };
  const clickHandle2 = () => {
    nameInput2.current.focus();
  };
  const changeHandler = (e) => {
    setMember({...member, [e.target.name] : e.target.value});
  };
  const addHandler = () => {
    const newMember = {...member, mid:memberId.current} //비동기를 동기로 만들기
    setMember(newMember)
    memberId.current += 1; //다음번호
    setMemberList([...memberList, member]);
  };
  useEffect(()=>{
    console.log(memberList);
  }, [memberList]);
  return (
    <div>
      <input ref={nameInput1}/>
      <input ref={nameInput2}/>
      <Button onClick={clickHandle1}>이동1</Button>
      <Button onClick={clickHandle2}>이동2</Button><hr/>
      <InputStudent member={member} changeHandler={changeHandler}/>
      <Button onClick={addHandler}>멤버 추가</Button>
      <ul>
        {memberList.map((item, index)=>(
          <li key={index}>
            {item.mid} - {item.name} - {item.age} - {item.email}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UseRefTest3;