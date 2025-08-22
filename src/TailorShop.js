import React from "react";
import ServiceCard from "./ServiceCard";

const TailorShop = () => {
  // Services array
  const services = [
    { serviceName: "Shirts", price: 20, fabricsAvailable: ["Cotton", "Linen", "Polyester"] },
    { serviceName: "Pants", price: 30, fabricsAvailable: ["Denim", "Twill", "Corduroy"] },
    { serviceName: "Lehenga", price: 150, fabricsAvailable: ["Silk", "Georgette", "Velvet"] },
    { serviceName: "Blouse", price: 40, fabricsAvailable: ["Cotton", "Silk", "Chiffon"] }
  ];

  return (
    <div className="container mt-4">
      {/* Heading */}
      <h2 className="text-center mb-4">👗 Tailoring Shop Services</h2>

      {/* Bootstrap Row → Responsive Grid */}
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
