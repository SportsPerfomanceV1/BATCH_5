// Result.js
import React from 'react';
import './Result.css'
const ResultPage = () => {
  return (
    <div className='container'>
      <h1>Event Results</h1>
      <input type='search' class='search-bar' placeholder='Search by meet name or event title'></input>
      <div className='result-table'>
        <table border='1px' className='table' cellPadding='10px 30px' cellSpacing='0px'>
          <tr>
            <th>Event ID</th>
            <th>Event Title</th>
            <th>Meet Name</th>
            <th>Actions</th>
          </tr>
          <tr>
            <td>E_0001</td>
            <td>Golden Mile Run</td>
            <td>Grand Marathon Challenge</td>
            <td><button className='res-btn'>Publish Result</button></td>
          </tr>
        </table>
      </div>
    </div>
  );
};

export default ResultPage;
