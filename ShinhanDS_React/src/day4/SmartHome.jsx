import { useState } from "react";
import Light from "day4/Light";
import { Link } from "react-router-dom";

function SmartHome() {
  const [masterOn, setMasterOn] = useState(false);
  const [kitchenOn, setKitchenOn] = useState(false);
  const [bathOn, setBathOn] = useState(false);

  const toggleMaster = () => {
    setMasterOn(!masterOn);
  };
  const toggleKitchen = () => {
    setKitchenOn(!kitchenOn);
  };
  const toggleBath = () => {
    setBathOn(!bathOn);
  };
  return (
    <div>
      <Link to="/webboard">WebBoard이동</Link>
      <button onClick={toggleMaster}>
        침실<Light on={masterOn} room="침실"></Light>
      </button>
      <button onClick={toggleKitchen}>
        주방<Light on={kitchenOn} room="주방"></Light>
      </button>
      <button onClick={toggleBath}>
        욕조<Light on={bathOn} room="욕조"></Light>
      </button>
    </div>
  );
}
export default SmartHome;
