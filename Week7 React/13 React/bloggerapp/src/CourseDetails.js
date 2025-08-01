const CourseDetails = ({ courses }) => {
  return (
    <>
      {courses && courses.map((course, index) => ( // logical && operator
        <div key={index}>
          <h3>{course.name}</h3>
          <p>{course.date}</p>
        </div>
      ))}
    </>
  );
};

export default CourseDetails;
