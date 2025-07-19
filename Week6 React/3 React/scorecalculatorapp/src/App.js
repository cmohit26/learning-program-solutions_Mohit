import logo from './logo.svg';
import './App.css';

import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore 
        Name = {"Daniel"}
        School = {"Brussels International Catholic School"}
        total={89}
        goal={2}
      />
    </div>
  );
}

export default App;
