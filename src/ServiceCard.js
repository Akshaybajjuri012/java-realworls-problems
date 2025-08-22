import React from "react";

const ServiceCard = ({ serviceName, price, fabricsAvailable }) => {
  return (
    // Each card takes 4 columns in a Bootstrap grid
    <div className="col-md-4 mb-3">
      {/* Bootstrap Card */}
      <div className="card shadow-sm h-100">
        <div className="card-body bg-warning rounded">
          {/* Service Name */}
          <h5 className="card-title">{serviceName}</h5>

          {/* Price */}
          <p className="card-text">
            <strong>Price:</strong>{" "}
            <span className="text-danger fw-bold">${price}</span>
          </p>

          {/* Fabrics */}
          <p className="card-text">
            <strong>Fabrics Available:</strong>
          </p>
          <ul className="list-unstyled">
            {fabricsAvailable.map((fabric, index) => (
              <li key={index}>✔️ {fabric}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default ServiceCard;
