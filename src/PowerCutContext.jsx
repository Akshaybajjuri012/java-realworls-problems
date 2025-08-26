
import React, { createContext, useContext, useState } from "react";

// Create Context
const PowerCutContext = createContext();

// Custom hook for easy access
export const usePowerCut = () => useContext(PowerCutContext);

// Provider Component
export const PowerCutProvider = ({ children }) => {
  const [announcements, setAnnouncements] = useState([]);

  // Function to add a new announcement
  const addAnnouncement = (street, message) => {
    const newAnnouncement = {
      id: Date.now(),
      street,
      message,
      time: new Date().toLocaleTimeString(),
    };

    // Add new at top
    setAnnouncements((prev) => [newAnnouncement, ...prev]);

  };

  return (
    <PowerCutContext.Provider value={{ announcements, addAnnouncement }}>
      {children}
    </PowerCutContext.Provider>
  );
};

