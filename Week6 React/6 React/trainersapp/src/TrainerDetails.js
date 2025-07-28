import React from 'react';
import { useParams } from 'react-router-dom';
import trainersMock from './TrainersMock';

const TrainerDetail = () => {
  const { id } = useParams();
  const trainer = trainersMock.find(t => t.trainerId === id);

  if (!trainer) return <div>Trainer not found</div>;

  return (
    <div>
      <h3>Trainers Details</h3>
      <p><strong>{trainer.name} ({trainer.technology})</strong></p>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, idx) => (
          <li key={idx}>{skill}</li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerDetail;
