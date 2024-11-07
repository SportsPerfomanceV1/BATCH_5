import React, { useState } from 'react';
import './events.css';
import eventImage1 from '../../images/sta1.jpeg';
import eventImage2 from '../../images/sta2.jpeg';
import eventImage3 from '../../images/sta3.jpeg';
import eventImage4 from '../../images/sta4.jpeg';
import eventImage5 from '../../images/sta3.jpeg';
import eventImage6 from '../../images/sta2.jpeg';

const events = [
  {
    id: 1,
    image: eventImage1, 
    date: "16/10/2024",
    meet: "Grand Marathon Challenge",
    category: "400m",
    title: "Grand Marathon Challenge"
  },
  {
    id: 2,
    image: eventImage2,  
    date: "20/10/2024",
    meet: "City Half Marathon",
    category: "21km",
    title: "City Half Marathon"
  },
  {
    id: 3,
    image: eventImage3,  
    date: "25/10/2024",
    meet: "National Sprint",
    category: "100m",
    title: "National Sprint"
  },
  {
    id: 4,
    image: eventImage4,
    date: "30/10/2024",
    meet: "State Athletic Championships",
    category: "Marathon",
    title: "State Athletic Championships"
  },
  {
    id: 5,
    image: eventImage5,  
    date: "05/11/2024",
    meet: "Mountain Trail Run",
    category: "15km",
    title: "Mountain Trail Run"
  },
  {
    id: 6,
    image: eventImage6, 
    date: "10/11/2024",
    meet: "Speed and Agility Challenge",
    category: "Sprint",
    title: "Speed and Agility Challenge"
  },
  {
    id: 6,
    image: eventImage3, 
    date: "10/11/2024",
    meet: "Speed and Agility Challenge",
    category: "Sprint",
    title: "Speed and Agility Challenge"
  },
  {
    id: 6,
    image: eventImage1, 
    date: "10/11/2024",
    meet: "Speed and Agility Challenge",
    category: "Sprint",
    title: "Speed and Agility Challenge"
  },
];

const Events = () => {
  const [searchTerm, setSearchTerm] = useState("");

  const handleSearch = (event) => {
    setSearchTerm(event.target.value);
  };

  const filteredEvents = events.filter(
    (event) =>
      event.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
      event.meet.toLowerCase().includes(searchTerm.toLowerCase()) ||
      event.category.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="events-container">
      <h1>Events</h1>

      {/* Search Bar */}
      <div className="search-bar">
        <input
          type="text"
          placeholder="Search by Event Title, Meet, or Category..."
          value={searchTerm}
          onChange={handleSearch}
        />
      </div>

      {/* Event Cards */}
      <div className="event-cards">
        {filteredEvents.map((event) => (
          <div key={event.id} className="event-card">
            <img src={event.image} alt={event.meet} className="event-image" />
            <div className="event-details">
              <h3 className="event-title">{event.title}</h3>
              <p><strong>Date:</strong> {event.date}</p>
              <p><strong>Meet:</strong> {event.meet}</p>
              <p><strong>Category:</strong> {event.category}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Events;
