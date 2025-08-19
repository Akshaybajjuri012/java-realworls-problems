import React from "react";

const ServiceCard = ({ serviceName, price, fabricsAvailable }) => {
  return (
    // 🔹 Bootstrap grid column (each card takes 4 columns out of 12 in a row)
    <div className="col-md-4 mb-3">
    
      {/* 🔹 Bootstrap Card */}
      <div className="card shadow-sm">
        <div className="card-body bg-warning">

          
          {/* Service Name */}
          <h5 className="card-title">{serviceName}</h5>

          {/* Price Display */}
          <p className="card-text">
            <b>Price:</b>{" "}
            {/* Price styled in red and bold */}
            <span className="text-danger fw-bold">${price}</span>
          </p>

          {/* Fabrics List */}
          <p className="card-text">
            <strong>Fabrics Available:</strong>
          </p>
          <ul>
            {/* Nested Loop: Iterating over fabricsAvailable array */}
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
