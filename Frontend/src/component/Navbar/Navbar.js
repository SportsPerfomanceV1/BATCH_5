import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css'; // Include CSS for styling

const Navbar = () => {
  return (
    <nav className="navbar">

      <div className="navbar-title">
        <Link to="/">Athletics</Link>
      </div>


      <ul className="nav-links">
        <li><Link to="/news">News</Link></li>
        <li><Link to="/events">Events</Link></li>
        <li><Link to="/results">Results</Link></li>
        <li><Link to="/coaches">Coaches</Link></li>
        <li><Link to="/athletes">Athletes</Link></li>
        <li><Link to="/profile">Profile</Link></li>
      </ul>

      <div className="nav-button-container">
        <button className="signin-button">Sign In</button>
      </div>
    </nav>
  );
};

export default Navbar;
