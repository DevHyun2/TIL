import MyApp4 from 'day2/MyApp4';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import MyApp5 from 'day2/MyApp5';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div>
    <h1>React JS시작하기</h1>
    {/* <MyApp1></MyApp1> */}
    {/* <MyApp2/> */}
    {/* <EnvTest/> */}
    {/* <MyApp3/> */}
    {/* <MyApp4/> */}
    <MyApp5/>
  </div>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
