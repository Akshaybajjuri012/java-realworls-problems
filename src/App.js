import React from "react";
import GroceryList from "./GroceryList";
import Car from "./Car";   
import Phone from "./Phone";
import SweetsList from "./SweetsList";
import Electronics from "./Electronics";
import CanteenMenu from "./CanteenMenu";
import JuiceList from "./JuiceList";
import Restaurant from "./Restaurant";
import TempleList from "./TempleList";
import TailorShop from "./TailorShop";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const items = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

  return (
    <div>
      <GroceryList items={items} />
      <hr />

      <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />

      <hr />
      <Phone />

      <hr />
      <SweetsList />

      <hr />
      <Electronics />
      <hr />
      <CanteenMenu />
      <hr />
      <JuiceList />
      <hr />
       <Restaurant />
      <hr />
       <TempleList />
      <hr />
       <TailorShop />
    </div>
  );
}

export default App;
