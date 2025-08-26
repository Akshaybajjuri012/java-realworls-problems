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
import ChessTournamentForm from "./ChessTournamentForm";
import HockeyTournamentForm from "./HockeyTournamentRegisForm";
import TailoringInventory from "./TailoringInventory";
import FootballPlayers from "./FootballPlayers";
import { PowerCutProvider } from "./PowerCutContext";
import SendAnnouncement from "./SendAnnouncement";
import AnnouncementList from "./AnnouncementList";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import TaxNavbar from "./TaxNavbar";
import Home from "./pages/Home";
import AddTaxpayer from "./pages/AddTaxpayer";
import TaxpayerList from "./pages/TaxpayerList";
import CalculateTax from "./pages/CalculateTax";
import TaxRates from "./pages/TaxRates";
import Contact from "./pages/Contact";
import About from "./pages/About";
import FAQ from "./pages/FAQ";
import NotFound from "./pages/NotFound";
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
        <hr />
        <ChessTournamentForm />
        <hr />
        <HockeyTournamentForm />
        <hr />
        <TailoringInventory />
        <hr />
        <FootballPlayers />
        <hr />
         <PowerCutProvider>
          <SendAnnouncement />
          <AnnouncementList />
        </PowerCutProvider>
        <hr />
         <Router>
      <TaxNavbar />  
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/add-taxpayer" element={<AddTaxpayer />} />
        <Route path="/taxpayer-list" element={<TaxpayerList />} />
        <Route path="/calculate-tax" element={<CalculateTax />} />
        <Route path="/tax-rates" element={<TaxRates />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/about" element={<About />} />
        <Route path="/faq" element={<FAQ />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
    </div>
  );
}

export default App;
