import React, { useState } from "react";
import LocalUserList from "./LocalUserList";
import UserList from "./UserList";
import FakePostList from "./FakePostList";

function Dashboard() {
  const [page, setPage] = useState("local");

  return (
    <main className="dashboard">
      <header className="dashboard-hero">
        <p className="hero-tag">Data Studio</p>
        <h1>People and Posts Dashboard</h1>
        <p className="hero-subtitle">
          Browse local records, live users, and fake posts from one sleek view.
        </p>
      </header>

      <nav className="tab-bar" aria-label="Dashboard sections">
        <button
          className={`tab-button ${page === "local" ? "active" : ""}`}
          onClick={() => setPage("local")}
        >
          Local Users
        </button>
        <button
          className={`tab-button ${page === "api" ? "active" : ""}`}
          onClick={() => setPage("api")}
        >
          Users API
        </button>
        <button
          className={`tab-button ${page === "fake" ? "active" : ""}`}
          onClick={() => setPage("fake")}
        >
          Fake API Posts
        </button>
      </nav>

      <section className="content-panel">
        {page === "local" && <LocalUserList />}
        {page === "api" && <UserList />}
        {page === "fake" && <FakePostList />}
      </section>
    </main>
  );
}

export default Dashboard;