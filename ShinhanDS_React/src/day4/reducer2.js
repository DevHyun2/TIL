const initMember = {
  member: { mid: 0, name: "", phone: "", active: false },
  memberList: [
    { mid: 1, name: "A", phone: "1234", active: false },
    { mid: 2, name: "B", phone: "5678", active: false },
  ],
};

export function reducer2(state, action) {
  switch (action.type) {
    case "CHANGE_INPUT":
      return {
        ...state,
        member: { ...state.member, [action.name]: action.value },
      };
    case "CREATE_MEMBER":
      return {
        member: initMember.member, //clear
        memberList: state.memberList.concat(action.member), //[...state.memberList, action.member]
      };
    case "TOGGLE_MEMBER": //1건수정
      return {
        ...state,
        memberList: state.memberList.map((mem) =>
          mem.mid === action.mid ? { ...mem, active: !mem.active } : mem
        ),
      };
    //== : 값비교  ===:값과 타입을 비교
    case "REMOVE_MEMBER":
      console.log("삭제하러옴", action.mid);
      return {
        ...state,
        memberList: state.memberList.filter((mem) => mem.mid !== action.mid),
      };
    default:
      return state;
  }
}
