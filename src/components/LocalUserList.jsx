import React, { useEffect, useState } from "react";

function LocalUserList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("/users.json")
      .then(res => res.json())
      .then(data => {
        setUsers(data);
        setLoading(false);
      })
      .catch(() => {
        setError("Error loading local data");
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div className="section-block">
      <h2>Local Users</h2>
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

export default LocalUserList;