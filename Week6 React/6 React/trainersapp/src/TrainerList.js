import React from 'react';
import { Link } from 'react-router-dom';

const TrainersList = ({ data }) => {
  return (
    <div>
      <h3>Trainers List</h3>
      <ul>
        {data.map(trainer => (
          <li key={trainer.trainerId}>
            <Link to={`/trainers/${trainer.trainerId}`}>{trainer.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TrainersList;
