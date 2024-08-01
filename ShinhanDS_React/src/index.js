import Day3App from 'day3/Day3App';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import Day3App2 from 'day3/Day3App2';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div>
    {/* <h1>React JS시작하기</h1> */}
    {/* <MyApp1></MyApp1> */}
    {/* <MyApp2/> */}
    {/* <EnvTest/> */}
    {/* <MyApp3/> */}
    {/* <MyApp4/> */}
    {/* <MyApp5/> */}
    {/* <Day3App/> */}
    <Day3App2/>
  </div>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
