import React, { Component } from "react";
import MenuItem from "./MenuItem";

class Restaurant extends Component {
  render() {
    const restaurantDetails = {
      name: "Spice Hub",
      location: "Block B, First Floor",
      openHours: "10:00 AM – 10:00 PM",
    };

    const menuItems = [
      { id: 1, name: "Paneer Butter Masala", price: 150, category: "Main Course", available: "Available" },
      { id: 2, name: "Chicken Biryani", price: 200, category: "Main Course", available: "Available" },
      { id: 3, name: "Masala Dosa", price: 80, category: "Breakfast", available: "Available" },
      { id: 4, name: "Gulab Jamun", price: 40, category: "Dessert", available: "Not Available" },
      { id: 5, name: "Veg Thali", price: 120, category: "Combo", available: "Available" },
    ];

    return (
      <div style={{ fontFamily: "Arial, sans-serif", padding: "16px" }}>
        <h2>Restaurant Name: {restaurantDetails.name}</h2>
        <p><b>Location:</b> {restaurantDetails.location}</p>
        <p><b>Open Hours:</b> {restaurantDetails.openHours}</p>

        <h3>Restaurant Menu:</h3>
        <ul>
          {menuItems.map((item) => (
            <MenuItem
              key={item.id}
              name={item.name}
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
