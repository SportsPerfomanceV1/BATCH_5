import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './signup.css';
import InputPassword from './inputPassword';  // Import the InputPassword component

const Login = () => {
  const [loginData, setLoginData] = useState({
    identifier: '', 
    password: '',
    role: '',
  });

  const [formErrors, setFormErrors] = useState({});  // State to store error messages

  const handleChange = (e) => {
    setLoginData({
      ...loginData,
      [e.target.name]: e.target.value,
    });
  };

  const handlePasswordChange = (password) => {
    setLoginData((prevData) => ({
      ...prevData,
      password: password,
    }));
  };

  const validateForm = () => {
    const errors = {};
    // Validate identifier (username or email)
    if (!loginData.identifier) {
      errors.identifier = "Username or Email is required.";
    }

    // Validate password
    if (!loginData.password) {
      errors.password = "Password is required.";
    }

    // Validate role selection
    if (!loginData.role) {
      errors.role = "Please select a role.";
    }

    setFormErrors(errors);
    return Object.keys(errors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!validateForm()) return;  // Don't proceed if there are validation errors

    // Logic to handle form submission goes here
    console.log('Login Data:', loginData);
  };

  return (
    <form className="form-container" onSubmit={handleSubmit}>
      <h2>Login</h2>
      
      <div>
        <input 
          type="text" 
          name="identifier" 
          placeholder="Username or Email" 
          value={loginData.identifier}
          onChange={handleChange}
          required 
        />
        {formErrors.identifier && <span className="error-message">{formErrors.identifier}</span>}
      </div>
      
      <div>
        <InputPassword onPasswordChange={handlePasswordChange} isLogin={true} errorMessage={formErrors.password} /> 
        {formErrors.password && <span className="error-message">{formErrors.password}</span>}
      </div>
      
      <div>
        <select 
          name="role" 
          value={loginData.role}
          onChange={handleChange}
          required
        >
          <option value="" disabled>Select role</option>
          <option value="coach">Coach</option>
          <option value="athlete">Athlete</option>
        </select>
        {formErrors.role && <span className="error-message">{formErrors.role}</span>}
      </div>
      
      <div>
        <button type="submit">Login</button>
      </div>

      <p>
        New user? <Link to="/register">Register Here!</Link>
      </p>
    </form>
  );
};

export default Login;
