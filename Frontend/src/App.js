<<<<<<< HEAD
// App.js
import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './component/Navbar/Navbar';
import ResultPage from './component/Result/Result';

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <Routes>
          <Route path="/results" element={<ResultPage />} />
        </Routes>
      </div>
    </Router>

  );
}

export default App;
