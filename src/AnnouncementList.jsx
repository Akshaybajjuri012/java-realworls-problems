
import React from "react";
import { usePowerCut } from "./PowerCutContext";

const AnnouncementList = () => {
  const { announcements } = usePowerCut();

  return (
    <div className="container mt-4">
      <h4>Power Cut Announcements</h4>
      <div
        className="border rounded p-2"
        style={{ maxHeight: "300px", overflowY: "auto" }}
      >
        {announcements.length === 0 ? (
          <p className="text-muted">No announcements yet.</p>
        ) : (
          announcements.map((a) => (
            <div key={a.id} className="border p-2 rounded mb-2 bg-light">
              <p><strong>Street:</strong> {a.street}</p>
              <p><strong>Message:</strong> {a.message}</p>
              <p><strong>Time:</strong> {a.time}</p>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default AnnouncementList;
