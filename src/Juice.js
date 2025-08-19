import React from "react";

// Functional Component: Juice
// Props: id, name, price → passed from parent component (e.g., JuiceList)
const Juice = ({ id, name, price }) => {
  return (
    <tr>
      {/* Displaying each prop inside a table cell */}
      <td>{id}</td>
      <td>{name}</td>
      <td>₹{price}</td>
    </tr>
  );
};

export default Juice;
