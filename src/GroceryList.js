import React from "react";

// Functional Component GroceryList (receives props)
const GroceryList = ({ items }) => {
  // Function to handle button click
  const handleClick = () => {
    alert("Groceries Added to Cart!"); // shows alert message
  };

  return (
    <div>
      {/* Heading */}
      <h2>Grocery List</h2>

      {/* Display items dynamically using map() */}
      <ul>
        {items.map((item, index) => (
          // key={index} helps React identify each list item uniquely
          <li key={index}>{item}</li>
        ))}
      </ul>

      {/* Button to trigger handleClick */}
      <button onClick={handleClick}>Add to Cart</button>
    </div>
  );
};

export default GroceryList;
