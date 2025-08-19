import React, { useState } from "react";

// Functional Component Electronics
const Electronics = () => {
  // useState hooks
  const [name] = useState("Laptop");       // fixed value (no setter used)
  const [brand, setBrand] = useState("Dell"); // brand can change
  const [price, setPrice] = useState(5500);   // price can change

  // function to update brand
  const updateBrand = () => {
    setBrand("HP"); // brand changes from Dell → HP
  };

  // function to increase price
  const increasePrice = () => {
    setPrice(price + 500); // adds 500 to current price
  };

  return (
    <div>
      <h2>Electronic Item Details</h2>

      {/* Display values from state */}
      <p><b>Name:</b> {name}</p>
      <p><b>Brand:</b> {brand}</p>
      <p><b>Price:</b> ₹{price}</p>

      {/* Buttons to update state */}
      <button onClick={updateBrand}>Update Brand</button>
      <button onClick={increasePrice} style={{ marginLeft: "10px" }}>
        Increase Price
      </button>
    </div>
  );
};

export default Electronics;
