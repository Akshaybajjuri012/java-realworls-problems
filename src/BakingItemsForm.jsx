import React, { useState } from "react";

function BakingItemsForm() {
  // State for form inputs
  const [form, setForm] = useState({
    itemName: "",
    quantity: "",
    ingredients: "",
    bakingTime: "",
    category: "Cake",
  });

  // State for submitted baking items list
  const [items, setItems] = useState([]);

  // Handle form input changes
  // Arrow function to handle input changes
  const handleChange = (e) => {
    // e = event object from input field 
    // e.target = the input element that triggered the event
    const { name, value } = e.target;
    // Using object destructuring to directly extract "name" and "value" 
    //  from e.target instead of writing e.target.name, e.target.value each time 
    //  Update state: 
    //  - Copy the previous form state using spread operator (...form) 
    //  - Replace the field whose "name" matches with the new "value"
    setForm({ ...form, [name]: value });
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    setItems([...items, form]); // add new form data to list
    setForm({
      itemName: "",
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Cake",
    }); // reset form
  };

  return (
    <div className="container my-5">
      {/* Card for form */}
      <div className="card border-0 shadow-lg">
        <div className="card-header bg-primary text-white text-center">
          <h3 className="mb-0">Baking Items Form</h3>
        </div>
        <div className="card-body p-4">
          <form onSubmit={handleSubmit}>
            {/* Item Name */}
            <div className="mb-3">
              <label className="form-label">Item Name</label>
              <input
                type="text"
                className="form-control"
                name="itemName"
                value={form.itemName}
                onChange={handleChange}
                required
              />
            </div>

            {/* Quantity */}
            <div className="mb-3">
              <label className="form-label">Quantity</label>
              <input
                type="number"
                className="form-control"
                name="quantity"
                value={form.quantity}
                onChange={handleChange}
                required
              />
            </div>

            {/* Ingredients */}
            <div className="mb-3">
              <label className="form-label">Ingredients</label>
              <textarea
                className="form-control"
                name="ingredients"
                rows="3"
                value={form.ingredients}
                onChange={handleChange}
                required
              ></textarea>
            </div>

            {/* Baking Time */}
            <div className="mb-3">
              <label className="form-label">Baking Time (minutes)</label>
              <input
                type="number"
                className="form-control"
                name="bakingTime"
                value={form.bakingTime}
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
                value={form.category}
                onChange={handleChange}
              >
                <option value="Cake">Cake</option>
                <option value="Bread">Bread</option>
                <option value="Pastry">Pastry</option>
              </select>
            </div>

            <div className="d-grid">
              <button type="submit" className="btn btn-success">
                Add Baking Item
              </button>
            </div>
          </form>
        </div>
      </div>

      {/* Baking Items List */}
      {items.length > 0 && (
        <div className="card border-0 shadow-lg mt-4">
          <div className="card-header bg-success text-white">
            <h4 className="mb-0">Baking Items List</h4>
          </div>
          <div className="card-body p-4">
            <div className="table-responsive">
              <table className="table table-striped table-bordered align-middle">
                <thead className="table-dark">
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Item Name</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Ingredients</th>
                    <th scope="col">Baking Time</th>
                    <th scope="col">Category</th>
                  </tr>
                </thead>
                <tbody>
                  {items.map((item, index) => (
                    <tr key={index}>
                      <td>{index + 1}</td>
                      <td>{item.itemName}</td>
                      <td>{item.quantity}</td>
                      <td>{item.ingredients}</td>
                      <td>{item.bakingTime} mins</td>
                      <td>{item.category}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default BakingItemsForm;
