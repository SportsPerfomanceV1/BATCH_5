import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignupPage from './component/RegLogin/signup'; 
import LoginPage from './component/RegLogin/login'; 
import ResultPage from './component/Result/Result'; 
import Events from './component/Events/events'; 
import Athletes from './component/Athletes/athletes'; 
import Navbar from './component/Navbar/Navbar'; 
import './App.css';
const App = () => {
  return (
    <Router>
      <Navbar /> 
      <Routes>
        <Route path="/signup" element={<SignupPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/results" element={<ResultPage />} />
        <Route path="/events" element={<Events />} />
        <Route path="/athletes" element={<Athletes />} />
      </Routes>
    </Router>
  );
};

export default App;
