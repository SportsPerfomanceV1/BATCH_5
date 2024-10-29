import React, { useState } from 'react';
import axios from 'axios';
import './login.css'; // Import the CSS
import { useNavigate } from 'react-router-dom'; // Import useNavigate for redirection

const LoginPage = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        userType: 'athlete' // Default user type
    });

    const [error, setError] = useState(''); // For error messages
    const [message, setMessage] = useState(''); // For success messages

    // Handle input changes
    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    // Handle form submission
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            // Clear previous messages
            setError('');
            setMessage('');

            // Make a POST request to the backend login endpoint
            const response = await axios.post('http://localhost:8080/auth/login', formData);

            // Handle success: display the message and redirect
            setMessage("Login successful"); // You can customize this message
            // Navigate to a specific page upon successful login, adjust as necessary
            navigate('/home'); // Adjust the URL as per your application's routing
        } catch (error) {
            // Handle error
            if (error.response && error.response.data) {
                setError(error.response.data.error || 'Login failed. Please try again.');
            } else {
                setError('Login failed. Please try again.');
            }
        }
    };

    return (
        <div className="login-container">
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <input type="text" name="username" placeholder="Username" value={formData.username} onChange={handleChange} required />
                </div>
                <div>
                    <input type="password" name="password" placeholder="Password" value={formData.password} onChange={handleChange} required />
                </div>
                <div>
                    <select name="userType" value={formData.userType} onChange={handleChange}>
                        <option value="athlete">Athlete</option>
                        <option value="coach">Coach</option>
                    </select>
                </div>
                <button type="submit">Login</button>

                {/* Display success or error message below the button */}
                {message && <p className="success-message">{message}</p>}
                {error && <p className="error-message">{error}</p>}
            </form>
        </div>
    );
};

export default LoginPage;
