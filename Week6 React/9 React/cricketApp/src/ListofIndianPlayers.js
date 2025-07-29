function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <div>
      {IndianPlayers.map((player, index) => (
        <div key={index}>
          <li>Mr. {player}</li>
        </div>
      ))}
    </div>
  );
}

export default ListofIndianPlayers;
