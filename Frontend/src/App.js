import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate, Link } from 'react-router-dom';
import SignupPage from './component/Signup/signup'; // Signup component
import LoginPage from './component/Login/login';   // Login component
import ResultPage from './component/Result/Result'; // Results page component
import './component/Navbar/Navbar.css'; // Import your Navbar CSS file

const App = () => {
    return (
        <Router>
            <div className="navbar">
                <div className="logo">Sports</div> {/* Logo or title */}
                <ul>
                    <li><Link to="/">News</Link></li>
                    <li><Link to="/">Events</Link></li>
                    <li><Link to="/results">Results</Link></li> {/* Link to Results page */}
                    
                    <li><Link to="/">Coaches</Link></li>
                    <li><Link to="/">Athletes</Link></li>
                </ul>
                <div className="auth-links">
                    <Link to="/login">Login</Link>
                    <Link to="/signup">Sign Up</Link>
                </div>
            </div>
            <Routes>
                <Route path="/signup" element={<SignupPage />} /> {/* Signup Page */}
                <Route path="/login" element={<LoginPage />} /> {/* Login Page */}
                <Route path="/results" element={<ResultPage />} /> {/* Results Page */}
            </Routes>
        </Router>
    );
};

export default App;
