import React from 'react';
import './App.css';

function App() {
  const officeSpaces = [
    {
      name: 'Elegant Tower',
      rent: 50000,
      address: 'MG Road, Bangalore',
      image: 'https://via.placeholder.com/200x100.png?text=Elegant+Tower',
    },
    {
      name: 'Tech Park View',
      rent: 75000,
      address: 'Electronic City, Bangalore',
      image: 'https://via.placeholder.com/200x100.png?text=Tech+Park+View',
    },
    {
      name: 'Skyline Hub',
      rent: 60000,
      address: 'Whitefield, Bangalore',
      image: 'https://via.placeholder.com/200x100.png?text=Skyline+Hub',
    },
  ];

  return (
    <div className="App">
      <h1>🏢 Office Space Rental Listings</h1>

      {officeSpaces.map((office, index) => (
        <div key={index} style={{ border: '1px solid #ccc', padding: 10, marginBottom: 10 }}>
          <img src={office.image} alt={office.name} width="200" height="100" />
          <h2>{office.name}</h2>
          <p><strong>Address:</strong> {office.address}</p>
          <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            <strong>Rent:</strong> ₹{office.rent}
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
