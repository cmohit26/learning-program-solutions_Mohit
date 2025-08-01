import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [showSection, setShowSection] = useState('book');

  const books = [
    { id: 101, bname: 'Master React', price: 670 },
    { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
    { id: 103, bname: 'Mongo Essentials', price: 450 },
  ];

  const blogs = [
    { id: 1, title: 'React Learning', author: 'Stephen Biz', content: 'Welcome to learning React!' },
    { id: 2, title: 'Installation', author: 'Schewzdenier', content: 'You can install React from npm.' },
  ];

  const courses = [
    { name: 'Angular', date: '4/5/2021' },
    { name: 'React', date: '6/3/20201' },
  ];

  return (
    <div style={{ display: 'flex', justifyContent: 'space-around' }}>
      <div>
        <button onClick={() => setShowSection('book')}>Book Details</button>
        <button onClick={() => setShowSection('blog')}>Blog Details</button>
        <button onClick={() => setShowSection('course')}>Course Details</button>
      </div>

      <div style={{ marginTop: '20px' }}>
        {showSection === 'book' && <BookDetails books={books} />}
        {showSection === 'blog' && <BlogDetails blogs={blogs} />}
        {showSection === 'course' && <CourseDetails courses={courses} />}
      </div>
    </div>
  );
}

export default App;
