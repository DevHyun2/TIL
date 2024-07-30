import logo from './logo.svg';
import './App.css';
import lodash from "loadsh";

var scores = [1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4]
var result = lodash.uniqBy(scores);
console.log(result);

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>App 컨포넌트</h1>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
