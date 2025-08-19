import React from "react";

const TempleList = () => {
  // Array of temples (each temple has id, name, location, and an array of deities)
  const temples = [
    {
      id: 1,
      name: "Meenakshi Amman Temple",
      location: "Madurai, Tamil Nadu",
      deities: ["Meenakshi", "Sundareswarar"] 
    },
    {
      id: 2,
      name: "Sri Venkateswara Temple",
      location: "Tirupati, Andhra Pradesh",
      deities: ["Venkateswara", "Lakshmi"]
    },
    {
      id: 3,
      name: "Jagannath Temple",
      location: "Puri, Odisha",
      deities: ["Jagannath", "Balabhadra", "Subhadra"]
    }
  ];

  return (
    <div style={{ fontFamily: "Arial, sans-serif", padding: "16px" }}>
      <h2>
        <span role="img" aria-label="temple">⛪</span>{" "}
        Famous Temples in India
      </h2>

      {/* Temple details shown in a table */}
      <table
        border="1"
        cellPadding="10"
        style={{
          borderCollapse: "collapse",
          width: "100%",
          textAlign: "left"
        }}
      >
        <thead style={{ backgroundColor: "#d2b3b3ff" }}>
          <tr>
            <th>ID</th>
            <th>Temple Name</th>
            <th>Location</th>
            <th>Deities</th>
          </tr>
        </thead>
        <tbody>
          {/* Outer loop → goes through each temple */}
          {temples.map((temple) => (
            <tr key={temple.id}>
              <td>{temple.id}</td>
              <td>{temple.name}</td>
              <td>{temple.location}</td>
              <td>
                {/* Inner loop → goes through each deity of the temple */}
                <ul style={{ margin: 0, paddingLeft: "20px" }}>
                  {temple.deities.map((deity, index) => (
                    <li key={index}>{deity}</li>
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TempleList;
