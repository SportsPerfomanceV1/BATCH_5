import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css'; 

const Navbar = () => {
  return (
    <div className="navbar">
      <div className="logo">Sports</div> 
      <ul>
        <li><Link to="/news">News</Link></li>
        <li><Link to="/events">Events</Link></li>
        <li><Link to="/results">Results</Link></li>
        <li><Link to="/coaches">Coaches</Link></li>
        <li><Link to="/athletes">Athletes</Link></li>
      </ul>
      <div className="auth-links">
        <Link to="/login">Login</Link>
        <Link to="/signup">Sign Up</Link>
      </div>
    </div>
  );
};

export default Navbar;
