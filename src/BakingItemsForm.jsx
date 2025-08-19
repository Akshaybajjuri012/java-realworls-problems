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
    //  Using object destructuring to directly extract "name" and "value" 
   //  from e.target instead of writing e.target.name, e.target.value each time

   // Update state: 
  // - Copy the previous form state using spread operator (...form)
  // - Replace the field whose "name" matches with the new "value"
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
    <div className="container mt-4">
      {/* Card for form */}
      <div className="card p-4 shadow-sm mb-4">
        <h3 className="text-center mb-3">Baking Items Form</h3>

        <form onSubmit={handleSubmit}>
          {/* Item Name */}
          <div className="form-group mb-3">
            <label>Item Name</label>
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
          <div className="form-group mb-3">
            <label>Quantity</label>
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
          <div className="form-group mb-3">
            <label>Ingredients</label>
            <textarea
              className="form-control"
              name="ingredients"
              value={form.ingredients}
              onChange={handleChange}
              required
            />
          </div>

          {/* Baking Time */}
          <div className="form-group mb-3">
            <label>Baking Time (minutes)</label>
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
          <div className="form-group mb-3">
            <label>Category</label>
            <select
              className="form-control"
              name="category"
              value={form.category}
              onChange={handleChange}
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          <button type="submit" className="btn btn-success">
            Add Baking Item
          </button>
        </form>
      </div>

      {/* Baking Items List */}
      {items.length > 0 && (
        <div className="card p-4 shadow-sm">
          <h4 className="mb-3">Baking Items List</h4>
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time</th>
                <th>Category</th>
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
      )}
    </div>
  );
}

export default BakingItemsForm;
