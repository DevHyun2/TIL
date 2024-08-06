import React, { useCallback, useReducer, useRef } from "react";
import FormComponent from "./FormComponent";
import TableComponent from "./TableComponent";
const initMember = {
  member: { mid: 0, name: "", phone: "", active: false },
  memberList: [
    { mid: 1, name: "A", phone: "1234", active: false },
    { mid: 2, name: "B", phone: "5678", active: false },
  ],
};
function reducer(state, action) {
  switch (action.type) {
    case "CHANGE_INPUT":
      return {
        ...state,
        member: { ...state.member, [action.name]: action.value },
      };
    case "CREATE_MEMBER":
      return {
        member: initMember.member, //clear
        memberList: state.memberList.concat(action.member),
      };
    case "TOGGLE_MEMBER": //1건수정
      return {
        ...state,
        memberList: state.memberList.map((mem) =>
          mem.mid === action.mid ? { ...mem, active: !mem.active } : mem
        ),
      };
      //== : 값비교 ===: 값과 타입비교
    case "REMOVE_MEMBER":
      console.log("삭제하러옴",action.mid);
      return {
        ...state,
        memberList: state.memberList.filter((mem) => mem.mid != action.mid),
      };
    default:
      return state;
  }
}
const ReducerTest2 = () => {
  //state는 외부에서 상태관리를 한다.초기값은 initMember이다.
  //{member:{},memberList:[{},{}]}
  //호출은 함수이름 dispatch를 이용한다. 전달되는 값은 2번째 argument인 action에 들어간다.
  const [state, dispatch] = useReducer(reducer, initMember);
  const mid = useRef(3);
  const { memberList } = state;
  const { name, phone } = state.member;
  const changeHandler = useCallback(
    (e) =>
      dispatch({
        type: "CHANGE_INPUT",
        name: e.target.name,
        value: e.target.value,
      }),
    []
  );
  //한건의 Member를 배열에 Add
  const addHandle = (e) => {
    const newMember = { name, phone, mid: mid.current };
    dispatch({ type: "CREATE_MEMBER", member: newMember });
    mid.current++;
  };
  const removeHandler = useCallback((mid) => {
    dispatch({ type: "REMOVE_MEMBER", mid: mid });
  }, []);
  const updateHandler = useCallback((mid) => {
    dispatch({ type: "TOGGLE_MEMBER", mid });
  }, []);
  return (
    <div>
      <FormComponent
        changeHandler={changeHandler}
        addHandle={addHandle}
      ></FormComponent>
      <TableComponent
        removeHandler={removeHandler}
        updateHandler={updateHandler}
        memberList={memberList}
      ></TableComponent>
    </div>
  );
};
export default ReducerTest2;