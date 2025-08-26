// Import necessary React and Axios libraries
import React, { useEffect, useState } from "react";
import axios from "axios";

const TailoringInventory = () => {
  // React state to hold the tailoring items data
  const [items, setItems] = useState([]);

  // useEffect runs after the component is mounted (like componentDidMount in class components)
  useEffect(() => {
    // Fetch data from JSON Server using Axios
    axios
      .get("http://localhost:5000/tailoringItems")  // API endpoint from JSON Server
      .then((response) => {
        setItems(response.data); // Store fetched data into state
        console.log("Fetched Data:", response.data); // Debug log to check data
      })
      .catch((error) => {
        // Handle errors (like server not running, wrong URL, etc.)
        console.error("Error fetching data:", error);
      });
  }, []); 
  // [] means this effect runs only once (on component mount)

  return (
    <div className="container mt-4">
      {/* Page Title */}
      <h2 className="text-center mb-4">Tailoring Inventory</h2>

      {/* Bootstrap Table */}
      <table className="table table-bordered table-striped text-center">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Size</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {/* Loop through items and display them as table rows */}
          {items.map((item) => (
            <tr key={item.id}> {/* key helps React track elements efficiently */}
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.size}</td>
              <td>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TailoringInventory;
