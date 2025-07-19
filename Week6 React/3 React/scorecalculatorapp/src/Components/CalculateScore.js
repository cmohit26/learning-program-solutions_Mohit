import '../Stylesheets/myStyle.css';

// ✅ First define helper functions
const percentToDecimal = (decimal) => {
  return (decimal * 100).toFixed(2) + '%';
};

const calcScore = (total, goal) => {
  return percentToDecimal(total / goal);
};

// ✅ Then define the component
export const CalculateScore = ({ Name, School, total, goal }) => {
  return (
    <div className='formatStyle'>
      <h1 style={{ color: 'brown' }}>Student Details</h1>
      <div className='Name'>
        <strong>Name: </strong>{Name}
      </div>
      <div className='School'>
        <strong>School: </strong>{School}
      </div>
      <div className='Total'>
        <strong>Total: </strong>{total} Marks
      </div>
      <div className='Score'>
        <strong>Score: </strong>{calcScore(total, goal)}
      </div>
    </div>
  );
};
