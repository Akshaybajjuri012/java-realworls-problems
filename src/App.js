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
import Fruits from "./Fruits";
import TelevisionManager from "./TelevisionManager";
import MarriageForm from "./MarriageForm";
import AccessoriesForm from "./AccessoriesForm";
import BakingItemsForm from "./BakingItemsForm";
import FlightBooking from "./FlightBooking";
import MovieForm from "./MovieForm";
import ProductDisplay from "./ProductDisplay";
import FurnitureStore from "./FurnitureStore";
import FestivalApp from "./FestivalApp";
import RestaurantForm from "./RestaurantRegistrationForm";
import FruitCommunication from "./FruitCommunication"
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
      <hr />
       <Fruits />
      <hr />
       <TelevisionManager />
      <hr />
       <MarriageForm />
       <hr />
       <AccessoriesForm />
       <hr />
       <BakingItemsForm />
       <hr />
       <FlightBooking />
       <hr />
        <MovieForm />
        <hr />
        <ProductDisplay />
        <hr />
        <FurnitureStore />
        <hr />
        <FestivalApp />
        <hr />
        <RestaurantForm />
        <hr />
        <FruitCommunication />
    </div>
  );
}

export default App;
