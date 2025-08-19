import React from "react";

// Functional Component SweetsList
const SweetsList = () => {
  // Array of sweet objects (id, name, price)
  const sweets = [
    { id: 1, name: "Laddu", price: 50 },
    { id: 2, name: "Jalebi", price: 40 },
    { id: 3, name: "Rasgulla", price: 60 },
    { id: 4, name: "Gulab Jamun", price: 70 }
  ];

  return (
    <div>
      <h2>Sweets List</h2>

      {/* Loop through sweets array and display each sweet */}
      {sweets.map((sweet) => (
        // key={sweet.id} → unique identifier for each element
        <div key={sweet.id}>
          {sweet.name} - Price: ₹{sweet.price}
        </div>
      ))}
    </div>
  );
};

export default SweetsList;
