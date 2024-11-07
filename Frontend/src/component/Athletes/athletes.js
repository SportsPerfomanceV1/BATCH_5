import React, { useState, useEffect } from "react";
import "./athletes.css";

const AthletesPage = () => {
  const [athletes, setAthletes] = useState([]);

  useEffect(() => {
    // Fetch athletes from API (Replace with actual API call)
    setAthletes([
      { id: 1, name: "John Doe", event: "100m Sprint", status: "Registered" },
      { id: 2, name: "Jane Smith", event: "Long Jump", status: "Not Registered" },
    ]);
  }, []);

  return (
    <div className="athletes-page">
      <h1>Athletes</h1>
      <div className="athletes-list">
        {athletes.map((athlete) => (
          <div className="athlete-card" key={athlete.id}>
            <h3>{athlete.name}</h3>
            <p>Event: {athlete.event}</p>
            <p>Status: {athlete.status}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AthletesPage;
