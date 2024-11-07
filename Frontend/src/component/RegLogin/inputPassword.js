import React, { useState } from 'react';
import hidePass from '../../images/hide.png';
import showPass from '../../images/show.png';

const InputPassword = ({ onPasswordChange, isLogin, errorMessage }) => { 
  const [password, setPassword] = useState('');
  const [isPasswordVisible, setIsPasswordVisible] = useState(false);

  const handlePasswordChange = (e) => {
    const inputPassword = e.target.value;
    setPassword(inputPassword);
    onPasswordChange(inputPassword);
  };

  const checkPasswordStrength = (password) => {
    const hasNumber = /\d/.test(password);
    const hasSymbol = /[!@#$%^&*(),.?":{}|<>]/.test(password);
    const isValidLength = password.length >= 8;
    
    // Check password validity based on the new rules
    if (!isValidLength) {
      return "Password must be at least 8 characters long.";
    }
    if (!hasNumber) {
      return "Password must contain at least one number.";
    }
    if (!hasSymbol) {
      return "Password must contain at least one symbol.";
    }

    return null;  
  };

  const togglePasswordVisibility = () => {
    setIsPasswordVisible(prev => !prev);
  };

  const error = checkPasswordStrength(password);  

  return (
    <div className="password-wrapper">
      <div className="password-input-container">
        <input
          type={isPasswordVisible ? 'text' : 'password'}
          placeholder="Enter your password"
          value={password}
          onChange={handlePasswordChange}
          className="password-input"
          required
        />
        <div className="password-controls">
          <img
            src={isPasswordVisible ? showPass : hidePass}
            alt={isPasswordVisible ? 'Hide password' : 'Show password'}
            onClick={togglePasswordVisibility}
            className="visibility-toggle"
          />
        </div>
      </div>
      {error && <span className="error-message">{error}</span>} 
    </div>
  );
};

export default InputPassword;
