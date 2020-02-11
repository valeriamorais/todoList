import React from 'react';
import Tasks from './components/Tasks';

import './App.css';

function App() {
  return (
    <div className="container-fluid">
        <nav>
            <div className="nav-wrapper center-align">
                <a href="/" className="brand-logo">Tasks</a>
            </div>
        </nav>
        <div className="row">
            <Tasks />
        </div>
    </div>
  );
}

export default App;
