import React from "react";
import ServiceCard from "./ServiceCard"; // Import child component

const TailorShop = () => {
  // Array of tailoring services (outer loop data)
  const services = [
    {
      serviceName: "Shirts",
      price: 20,
      fabricsAvailable: ["Cotton", "Linen", "Polyester"] // inner loop
    },
    {
      serviceName: "Pants",
      price: 30,
      fabricsAvailable: ["Denim", "Twill", "Corduroy"]
    },
    {
      serviceName: "Lehenga",
      price: 150,
      fabricsAvailable: ["Silk", "Georgette", "Velvet"]
    },
    {
      serviceName: "Blouse",
      price: 40,
      fabricsAvailable: ["Cotton", "Silk", "Chiffon"]
    }
  ];

  return (
    <div className="container mt-4">
      {/* Heading */}
      <h2 className="text-center mb-4">Tailoring Shop Services</h2>

      {/* Bootstrap Row → Cards will be arranged in grid layout */}
      <div className="row">
        {/*  Looping through services (outer loop) */}
        {services.map((service, index) => (
          // Passing each service as props to child ServiceCard
          <ServiceCard
            key={index} // unique key for React
            serviceName={service.serviceName}
            price={service.price}
            fabricsAvailable={service.fabricsAvailable}
          />
        ))}
      </div>
    </div>
  );
};

export default TailorShop;
