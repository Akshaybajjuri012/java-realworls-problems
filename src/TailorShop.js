import React from "react";
import ServiceCard from "./ServiceCard";

const TailorShop = () => {
  const services = [
    {
      serviceName: "Shirts",
      price: 500,
      fabricsAvailable: ["Cotton", "Linen", "Polyester"]
    },
    {
      serviceName: "Pants",
      price: 800,
      fabricsAvailable: ["Denim", "Twill", "Corduroy"]
    },
    {
      serviceName: "Lehenga",
      price: 2500,
      fabricsAvailable: ["Silk", "Georgette", "Velvet"]
    },
    {
      serviceName: "Blouse",
      price: 700,
      fabricsAvailable: ["Cotton", "Silk", "Chiffon"]
    }
  ];

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">👗 Tailoring Shop Services</h2>
      <div className="row">
        {services.map((service, index) => (
          <ServiceCard
            key={index}
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
