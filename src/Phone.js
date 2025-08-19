import React, { useState } from "react";

// Functional Component Phone
const Phone = () => {
  // useState hook: phone is state, setPhone is updater function
  // initial state = object with brand, model, price
  const [phone, setPhone] = useState({
    brand: "Apple",
    model: "iPhone 15",
    price: 79999
  });

  // function to increase price by 1000
  const updatePrice = () => {
    // spread operator (...) copies old state
    // only update "price" field
    setPhone({ ...phone, price: phone.price + 1000 });
  };

  return (
    <div>
      <h2>Phone Details</h2>

      {/* Displaying state values */}
      <p><b>Brand:</b> {phone.brand}</p>
      <p><b>Model:</b> {phone.model}</p>
      <p><b>Price:</b> ${phone.price}</p>

      {/* Button to update price */}
      <button onClick={updatePrice}>Increase Price</button>
    </div>
  );
};

export default Phone;
