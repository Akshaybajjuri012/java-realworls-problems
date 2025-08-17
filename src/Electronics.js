import React, { useState } from "react";

const Electronics = () => {
  const [name] = useState("Laptop");
  const [brand, setBrand] = useState("Dell");
  const [price, setPrice] = useState(5500);

  const updateBrand = () => {
    setBrand("HP"); 
  };

  const increasePrice = () => {
    setPrice(price + 500); 
  };

  return (
    <div>
      <h2>Electronic Item Details</h2>
      <p><b>Name:</b> {name}</p>
      <p><b>Brand:</b> {brand}</p>
      <p><b>Price:</b> ₹{price}</p>

      <button onClick={updateBrand}>Update Brand</button>
      <button onClick={increasePrice} style={{ marginLeft: "10px" }}>
        Increase Price
      </button>
    </div>
  );
};

export default Electronics;
