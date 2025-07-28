import React from 'react';
import { BrowserRouter, Routes, Route, Link, Navigate } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainerList';
import TrainerDetail from './TrainerDetails.js';
import trainersMock from './TrainersMock';

const App = () => {
  return (
    <BrowserRouter>
      <div>
        <h2>My Academy Trainers App</h2>
        <nav>
          <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList data={trainersMock} />} />
          <Route path="/trainers/:id" element={<TrainerDetail />} />
          <Route path="*" element={<Navigate to="/" />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
};

export default App;
