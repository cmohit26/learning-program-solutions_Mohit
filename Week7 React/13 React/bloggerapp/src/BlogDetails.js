const BlogDetails = ({ blogs }) => {
  return (
    <>
      {blogs.length > 0 ? ( // ternary operator
        blogs.map((blog) => (
          <div key={blog.id}>
            <h3>{blog.title}</h3>
            <p><b>{blog.author}</b></p>
            <p>{blog.content}</p>
          </div>
        ))
      ) : (
        <p>No blogs found.</p>
      )}
    </>
  );
};

export default BlogDetails;
