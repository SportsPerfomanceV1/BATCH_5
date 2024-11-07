import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './signup.css';
import InputPassword from './inputPassword'; 

const Register = () => {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    role: '',
  });

  const [errors, setErrors] = useState({
    username: '',
    email: '',
    password: '',
    role: '',
  });

  const handlePasswordChange = (password) => {
    setFormData((prevData) => ({
      ...prevData,
      password: password,
    }));
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const validateForm = () => {
    let valid = true;
    let errorMessages = { username: '', email: '', password: '', role: '' };

    if (!formData.username) {
      errorMessages.username = 'Username is required.';
      valid = false;
    }

    if (!formData.email) {
      errorMessages.email = 'Email is required.';
      valid = false;
    }

    if (!formData.password) {
      errorMessages.password = 'Password is required.';
      valid = false;
    }

    if (!formData.role) {
      errorMessages.role = 'Role is required.';
      valid = false;
    }

    setErrors(errorMessages);
    return valid;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (validateForm()) {
      try {
        const response = await fetch('YOUR_API_ENDPOINT_HERE', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(formData),
        });

        if (!response.ok) {
          throw new Error('Network response was not ok');
        }

        const data = await response.json();
        console.log('Success:', data);
      } catch (error) {
        console.error('Error:', error);
      }
    }
  };

  return (
    <form className="form-container" onSubmit={handleSubmit}>
      <h2>Register</h2>

      <div>
        <input
          type="text"
          name="username"
          placeholder="Username"
          required
          value={formData.username}
          onChange={handleChange}
        />
        {errors.username && <div className="error-message">{errors.username}</div>}
      </div>

      <div>
        <input
          type="email"
          name="email"
          placeholder="Email"
          required
          value={formData.email}
          onChange={handleChange}
        />
        {errors.email && <div className="error-message">{errors.email}</div>}
      </div>

      <div>
        <InputPassword
          onPasswordChange={handlePasswordChange}
          errorMessage={errors.password} // Pass the password error message
        />
      </div>

      <div>
        <select
          name="role"
          required
          value={formData.role}
          onChange={handleChange}
        >
          <option value="" disabled>Select role</option>
          <option value="coach">Coach</option>
          <option value="athlete">Athlete</option>
        </select>
        {errors.role && <div className="error-message">{errors.role}</div>}
      </div>

      <div>
        <button type="submit">Register</button>
      </div>

      <p className='alreadyuser'>
        Already a user? <Link to="/login">Login here</Link>.
      </p>
    </form>
  );
};

export default Register;
