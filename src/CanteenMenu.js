import React from "react";
import CanteenItem from "./CanteenItem"; // Importing child component

// Parent Component: CanteenMenu
const CanteenMenu = () => {
  return (
    <div>
      {/* Basic Canteen Info */}
      <h2>Canteen Name: Campus Food Court</h2>
      <p><b>Location:</b> Block A, Ground Floor</p>
      <p><b>Open Hours:</b> 8:00 AM – 8:00 PM</p>

      <h3>Canteen Menu:</h3>

      {/* Using <CanteenItem /> multiple times (child components) */}
      <ul>
        <CanteenItem name="Idli" price={30} category="Breakfast" available="Yes" />
        <CanteenItem name="Dosa" price={5} category="Breakfast" available="Yes" />
        <CanteenItem name="Vada" price={2} category="Snack" available="No" />
        <CanteenItem name="Poori" price={40} category="Breakfast" available="Yes" />
        <CanteenItem name="Meals" price={120} category="Lunch" available="Yes" />
      </ul>
    </div>
  );
};

export default CanteenMenu;
