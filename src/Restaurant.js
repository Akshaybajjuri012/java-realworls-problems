import React, { Component } from "react";
import MenuItem from "./MenuItem"; // Importing child component

class Restaurant extends Component {
  render() {
    // Restaurant basic details
    const restaurantDetails = {
      name: "Spice Hub",
      location: "Block B, First Floor",
      openHours: "10:00 AM – 10:00 PM",
    };

    // Array of menu items (each item is an object)
    const menuItems = [
      { id: 1, name: "Paneer Butter Masala", price: 150, category: "Main Course", available: "Available" },
      { id: 2, name: "Chicken Biryani", price: 200, category: "Main Course", available: "Available" },
      { id: 3, name: "Masala Dosa", price: 80, category: "Breakfast", available: "Available" },
      { id: 4, name: "Gulab Jamun", price: 40, category: "Dessert", available: "Not Available" },
      { id: 5, name: "Veg Thali", price: 120, category: "Combo", available: "Available" },
    ];

    return (
      <div style={{ fontFamily: "Arial, sans-serif", padding: "16px" }}>
        {/* Restaurant details */}
        <h2>Restaurant Name: {restaurantDetails.name}</h2>
        <p><b>Location:</b> {restaurantDetails.location}</p>
        <p><b>Open Hours:</b> {restaurantDetails.openHours}</p>

        {/* Restaurant Menu */}
        <h3>Restaurant Menu:</h3>
        <ul>
          {/* Loop through menuItems and render MenuItem component for each */}
          {menuItems.map((item) => (
            <MenuItem
              key={item.id}           // Unique key for each list item
              name={item.name}        // Passing props to MenuItem
              price={item.price}
              category={item.category}
              available={item.available}
            />
          ))}
        </ul>
      </div>
    );
  }
}

export default Restaurant;
