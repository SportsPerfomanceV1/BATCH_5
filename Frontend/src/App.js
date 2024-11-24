// src/App.js
import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import Login from "./components/Login";
import Register from "./components/Register";
import { AppBar, Toolbar, Button, Typography, Box } from "@mui/material";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import LoginIcon from "@mui/icons-material/Login";
import "./App.css";

const App = () => {
    return (
        <Router>
            <AppBar position="static" sx={{ background: "#ffffff", boxShadow: "0 4px 12px rgba(0, 0, 0, 0.1)" }}>
                <Toolbar sx={{ display: "flex", justifyContent: "space-between", padding: "0 2rem" }}>
                    <Typography variant="h5" sx={{ color: "#000000", fontWeight: "bold" }}>
                        Sports Performance
                    </Typography>
                    <Box sx={{ display: "flex", alignItems: "center" }}>
                        <Link to="/register" style={{ textDecoration: "none", color: "#000000" }}>
                            <Button startIcon={<PersonAddIcon />} sx={{ marginRight: "1rem", color: "#000000" }}>Register</Button>
                        </Link>
                        <Link to="/login" style={{ textDecoration: "none", color: "#000000" }}>
                            <Button startIcon={<LoginIcon />} sx={{ color: "#000000" }}>Login</Button>
                        </Link>
                    </Box>
                </Toolbar>
            </AppBar>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
            </Routes>
        </Router>
    );
};

export default App;
