import React, { useEffect, useState } from "react";

function UserList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(res => res.json())
      .then(data => {
        setUsers(data);
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading...</p>;

  return (
    <div className="section-block">
      <h2>API Users</h2>
      <div className="grid-cards">
        {users.map(u => (
          <article className="card" key={u.id}>
            <h3>{u.name}</h3>
            <p>{u.email}</p>
            <p>{u.phone}</p>
          </article>
        ))}
      </div>
    </div>
  );
}

export default UserList;