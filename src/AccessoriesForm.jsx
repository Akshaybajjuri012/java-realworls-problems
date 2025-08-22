import React, { Component } from "react";

class AccessoriesForm extends Component {
  constructor(props) {
    super(props);

    // Initial state: holds all form inputs + submitted data
    this.state = {
      name: "",             // accessory name
      description: "",      // description text
      category: "Electronics", // default category
      brand: "",            // selected brand (via radio)
      inStock: false,       // checkbox value (true/false)
      warranty: "",         // warranty in years
      submitted: null,      // after form submission, stores entered details
    };
  }

  /**
   * handleChange()
   * ----------------------------
   * This method updates state when an input value changes.
   * - It works for text, textarea, select, checkbox, and radio inputs.
   * - For checkboxes, we use `checked` instead of `value`.
   * - Uses [name]: value syntax → updates correct state property dynamically.
   */
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    this.setState({
      [name]: type === "checkbox" ? checked : value,
    });
  };

  /**
   * handleSubmit()
   * ----------------------------
   * - Prevents default page reload (`e.preventDefault()`).
   * - Copies current state values into `submitted`.
   * - This allows us to display the data in a results card below the form.
   */
  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({
      submitted: {
        name: this.state.name,
        description: this.state.description,
        category: this.state.category,
        brand: this.state.brand,
        inStock: this.state.inStock,
        warranty: this.state.warranty,
      },
    });
  };

  /**
   * render()
   * ----------------------------
   * - Renders the full UI for this component.
   * - Contains:
   *   1. A form wrapped in a Bootstrap card.
   *   2. Inputs for name, description, category, brand, stock, warranty.
   *   3. Submit button to save form data.
   *   4. Conditional rendering: if form is submitted, display a table with results.
   */
  render() {
    return (
      <div className="container mt-5">
        {/* Form card */}
        <div className="card shadow-lg border-0">
          <div className="card-header bg-primary text-white text-center">
            <h3 className="mb-0">🛒 Accessories Form</h3>
          </div>
          <div className="card-body p-4">
            {/* Attach onSubmit handler */}
            <form onSubmit={this.handleSubmit}>
              
              {/* Accessory name (text input) */}
              <div className="mb-3">
                <label className="form-label">Accessory Name</label>
                <input
                  type="text"
                  className="form-control"
                  name="name"
                  value={this.state.name}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Description (textarea input) */}
              <div className="mb-3">
                <label className="form-label">Description</label>
                <textarea
                  className="form-control"
                  name="description"
                  rows="3"
                  value={this.state.description}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Category (dropdown select) */}
              <div className="mb-3">
                <label className="form-label">Category</label>
                <select
                  className="form-select"
                  name="category"
                  value={this.state.category}
                  onChange={this.handleChange}
                >
                  <option value="Electronics">Electronics</option>
                  <option value="Fashion">Fashion</option>
                  <option value="Home">Home</option>
                </select>
              </div>

              {/* Brand (radio buttons) */}
              <div className="mb-3">
                <label className="form-label">Brand</label>

                <div className="form-check">
                  <input
                    type="radio"
                    className="form-check-input"
                    name="brand"
                    value="Sony"
                    checked={this.state.brand === "Sony"}
                    onChange={this.handleChange}
                  />
                  <label className="form-check-label">Sony</label>
                </div>

                <div className="form-check">
                  <input
                    type="radio"
                    className="form-check-input"
                    name="brand"
                    value="Samsung"
                    checked={this.state.brand === "Samsung"}
                    onChange={this.handleChange}
                  />
                  <label className="form-check-label">Samsung</label>
                </div>

                <div className="form-check">
                  <input
                    type="radio"
                    className="form-check-input"
                    name="brand"
                    value="LG"
                    checked={this.state.brand === "LG"}
                    onChange={this.handleChange}
                  />
                  <label className="form-check-label">LG</label>
                </div>
              </div>

              {/* In stock (checkbox) */}
              <div className="form-check mb-3">
                <input
                  type="checkbox"
                  className="form-check-input"
                  name="inStock"
                  checked={this.state.inStock}
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Available in stock</label>
              </div>

              {/* Warranty (number input) */}
              <div className="mb-3">
                <label className="form-label">Warranty (years)</label>
                <input
                  type="number"
                  className="form-control"
                  name="warranty"
                  value={this.state.warranty}
                  onChange={this.handleChange}
                />
              </div>

              {/* Submit button */}
              <button type="submit" className="btn btn-success w-100">
                Submit
              </button>
            </form>
          </div>
        </div>

        {/* Results card - only show if submitted */}
        {this.state.submitted && (
          <div className="card shadow-lg border-0 mt-4">
            <div className="card-header bg-success text-white text-center">
              <h3 className="mb-0">📋 Submitted Accessory Details</h3>
            </div>
            <div className="card-body p-4">
              <table className="table table-striped table-bordered">
                <tbody>
                  <tr>
                    <th>Accessory Name</th>
                    <td>{this.state.submitted.name}</td>
                  </tr>
                  <tr>
                    <th>Description</th>
                    <td>{this.state.submitted.description}</td>
                  </tr>
                  <tr>
                    <th>Category</th>
                    <td>{this.state.submitted.category}</td>
                  </tr>
                  <tr>
                    <th>Brand</th>
                    <td>{this.state.submitted.brand}</td>
                  </tr>
                  <tr>
                    <th>Available in Stock</th>
                    <td>{this.state.submitted.inStock ? "✅ Yes" : "❌ No"}</td>
                  </tr>
                  <tr>
                    <th>Warranty</th>
                    <td>{this.state.submitted.warranty} years</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        )}
      </div>
    );
  }
}

export default AccessoriesForm;
