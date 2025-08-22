import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

// ---------------- Loading Component ----------------
const LoadingComponent = () => (
  <div className="alert alert-info text-center">Loading product details...</div>
);

// ---------------- Error Component ----------------
const ErrorComponent = () => (
  <div className="alert alert-danger text-center">
    ⚠ Error fetching product details
  </div>
);

// ---------------- Product Component ----------------
const ProductComponent = ({ product }) => {
  return (
    <div className="card shadow-sm p-3 mt-4">
      <h5 className="card-title">Electronic Product Details</h5>
      <ul className="list-group list-group-flush">
        <li className="list-group-item">
          <strong>Name:</strong> {product.name}
        </li>
        <li className="list-group-item">
          <strong>Brand:</strong> {product.brand}
        </li>
        <li className="list-group-item">
          <strong>Price:</strong> ₹{product.price}
        </li>
        <li className="list-group-item">
          <strong>Category:</strong> {product.category}
        </li>
        <li className="list-group-item">
          <strong>Type:</strong>{" "}
          {product.price > 50000 ? "Premium Product" : "Budget Product"}
        </li>
        <li className="list-group-item">
          <strong>Warranty:</strong>{" "}
          {product.warranty > 0 ? `${product.warranty} years` : "No Warranty"}
        </li>
        <li className="list-group-item">
          {product.availability ? "✅ In Stock" : "❌ Out of Stock"}
        </li>
        {product.category === "Laptop" ? (
          <li className="list-group-item text-success fw-bold">
            🎒 Free Laptop Bag Offer
          </li>
        ) : null}
      </ul>
    </div>
  );
};

// ---------------- Main App Component ----------------
function App() {
  const [loading, setLoading] = useState(false); // initially no loading
  const [error, setError] = useState(false); // initially no error
  const [product, setProduct] = useState(null); // will hold user-entered product
  const [formData, setFormData] = useState({
    name: "",
    brand: "",
    price: "",
    category: "Mobile",
    warranty: "",
    availability: true,
  });

  // Handle input changes
  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Simulate loading
    setLoading(true);
    setError(false);

    setTimeout(() => {
      // Fake error simulation (10% chance)
      if (Math.random() < 0.1) {
        setError(true);
        setLoading(false);
      } else {
        setProduct(formData);
        setLoading(false);
      }
    }, 1000);
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">
        Lab Question: Conditional Rendering with Multiple Components
      </h2>

      {/* ---------- Bootstrap Form for Product Entry ---------- */}
      <div className="card p-4 shadow">
        <h4 className="mb-3">Enter Product Details</h4>
        <form onSubmit={handleSubmit}>
          {/* Name */}
          <div className="mb-3">
            <label className="form-label">Product Name</label>
            <input
              type="text"
              className="form-control"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
            />
          </div>

          {/* Brand */}
          <div className="mb-3">
            <label className="form-label">Brand</label>
            <input
              type="text"
              className="form-control"
              name="brand"
              value={formData.brand}
              onChange={handleChange}
              required
            />
          </div>

          {/* Price */}
          <div className="mb-3">
            <label className="form-label">Price</label>
            <input
              type="number"
              className="form-control"
              name="price"
              value={formData.price}
              onChange={handleChange}
              required
            />
          </div>

          {/* Category */}
          <div className="mb-3">
            <label className="form-label">Category</label>
            <select
              className="form-select"
              name="category"
              value={formData.category}
              onChange={handleChange}
            >
              <option>Mobile</option>
              <option>Laptop</option>
              <option>TV</option>
            </select>
          </div>

          {/* Warranty */}
          <div className="mb-3">
            <label className="form-label">Warranty (years)</label>
            <input
              type="number"
              className="form-control"
              name="warranty"
              value={formData.warranty}
              onChange={handleChange}
            />
          </div>

          {/* Availability */}
          <div className="form-check mb-3">
            <input
              className="form-check-input"
              type="checkbox"
              name="availability"
              checked={formData.availability}
              onChange={handleChange}
            />
            <label className="form-check-label">Available in Stock</label>
          </div>

          {/* Submit */}
          <button type="submit" className="btn btn-primary">
            Submit Product
          </button>
        </form>
      </div>

      {/* ---------- Conditional Rendering ---------- */}
      <div className="mt-4">
        {loading ? (
          <LoadingComponent />
        ) : error ? (
          <ErrorComponent />
        ) : product ? (
          <ProductComponent product={product} />
        ) : null}
      </div>
    </div>
  );
}

export default App;
