import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

// Chair Component
function Chair() {
  const chair = {
    name: "Office Chair",
    price: "₹ 2500",
    material: "Plastic",
    brand: "Nilkamal",
  };

  return (
    <div className="card shadow bg-success text-white p-3">
      <h2 className="h5 mb-3">🪑 Chair</h2>
      <p><strong>Name:</strong> {chair.name}</p>
      <p><strong>Price:</strong> {chair.price}</p>
      <p><strong>Material:</strong> {chair.material}</p>
      <p><strong>Brand:</strong> {chair.brand}</p>
    </div>
  );
}

// Table Component
function Table() {
  const table = {
    name: "Dining Table",
    price: "₹ 7500",
    material: "Wood",
    size: "6 Seater",
    brand: "Godrej",
  };

  return (
    <div className="card shadow bg-primary text-white p-3">
      <h2 className="h5 mb-3">🍽️ Table</h2>
      <p><strong>Name:</strong> {table.name}</p>
      <p><strong>Price:</strong> {table.price}</p>
      <p><strong>Material:</strong> {table.material}</p>
      <p><strong>Size:</strong> {table.size}</p>
      <p><strong>Brand:</strong> {table.brand}</p>
    </div>
  );
}

// Sofa Component
function Sofa() {
  const sofa = {
    name: "Recliner Sofa",
    price: "₹ 15000",
    material: "Leather",
    size: "3 Seater",
    brand: "Durian",
  };

  return (
    <div className="card shadow bg-warning text-dark p-3">
      <h2 className="h5 mb-3">🛋️ Sofa</h2>
      <p><strong>Name:</strong> {sofa.name}</p>
      <p><strong>Price:</strong> {sofa.price}</p>
      <p><strong>Material:</strong> {sofa.material}</p>
      <p><strong>Size:</strong> {sofa.size}</p>
      <p><strong>Brand:</strong> {sofa.brand}</p>
    </div>
  );
}

// Bed Component
function Bed() {
  const bed = {
    name: "King Size Bed",
    price: "₹ 20000",
    material: "Teak Wood",
    size: "King",
    brand: "Urban Ladder",
  };

  return (
    <div className="card shadow bg-danger text-white p-3">
      <h2 className="h5 mb-3">🛏️ Bed</h2>
      <p><strong>Name:</strong> {bed.name}</p>
      <p><strong>Price:</strong> {bed.price}</p>
      <p><strong>Material:</strong> {bed.material}</p>
      <p><strong>Size:</strong> {bed.size}</p>
      <p><strong>Brand:</strong> {bed.brand}</p>
    </div>
  );
}

// Main App Component
export default function App() {
  const [furniture, setFurniture] = useState("Chair");

  const renderFurniture = () => {
    switch (furniture) {
      case "Chair":
        return <Chair />;
      case "Table":
        return <Table />;
      case "Sofa":
        return <Sofa />;
      case "Bed":
        return <Bed />;
      default:
        return <p>Select a furniture item</p>;
    }
  };

  return (
    <div className="d-flex flex-column align-items-center justify-content-center min-vh-100 bg-light">
      <h1 className="display-5 fw-bold mb-4 text-dark">Furniture Store</h1>
      
      <select
        className="form-select w-50 mb-4"
        value={furniture}
        onChange={(e) => setFurniture(e.target.value)}
      >
        <option value="Chair">Chair</option>
        <option value="Table">Table</option>
        <option value="Sofa">Sofa</option>
        <option value="Bed">Bed</option>
      </select>

      <div className="w-50">{renderFurniture()}</div>
    </div>
  );
}
