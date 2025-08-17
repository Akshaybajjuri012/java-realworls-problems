import React from "react";

const ServiceCard = ({ serviceName, price, fabricsAvailable }) => {
  return (
    <div className="col-md-4 mb-3">
      <div className="card shadow-sm">
        <div className="card-body">
          <h5 className="card-title">{serviceName}</h5>
          <p className="card-text">
            <strong>Price:</strong> ₹{price}
          </p>
          <p className="card-text">
            <strong>Fabrics Available:</strong>
          </p>
          <ul>
            {fabricsAvailable.map((fabric, index) => (
              <li key={index}>{fabric}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default ServiceCard;
