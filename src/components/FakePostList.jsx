import React, { useEffect, useState } from "react";
import axios from "axios";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filter, setFilter] = useState("");

  const fetchData = () => {
    axios.get("https://dummyjson.com/posts")
      .then(res => setPosts(res.data.posts));
  };

  useEffect(() => {
    fetchData();
  }, []);

  const filteredPosts = filter
    ? posts.filter(p => p.userId === Number(filter))
    : posts;

  return (
    <div className="section-block">
      <h2>Fake API Posts</h2>

      <div className="controls-row">
        <select className="filter-select" onChange={(e) => setFilter(e.target.value)}>
          <option value="">All Users</option>
          <option value="1">User 1</option>
          <option value="2">User 2</option>
          <option value="3">User 3</option>
        </select>

        <button className="action-button" onClick={fetchData}>Refresh</button>
      </div>

      <div className="post-list">
        {filteredPosts.map(p => (
          <article className="card post-card" key={p.id}>
            <h3>{p.title}</h3>
            <p>{p.body}</p>
          </article>
        ))}
      </div>
    </div>
  );
}

export default FakePostList;