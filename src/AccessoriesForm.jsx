import React, { Component } from "react";

class AccessoriesForm extends Component {
  constructor(props) {
    super(props);

    // state for all form inputs
    this.state = {
      name: "",
      description: "",
      category: "Electronics", // default select
      brand: "",
      inStock: false,
      warranty: "",
      submitted: null,
    };
  }

  // handle input changes (text, textarea, select, number)
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    this.setState({
      [name]: type === "checkbox" ? checked : value, // checkbox = checked
    });
  };

  // handle form submit
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

  render() {
    return (
      <div className="container mt-4">
        {/* Form card */}
        <div className="card p-4 shadow-sm mb-4">
          <h3 className="text-center mb-3">Accessories Form</h3>
          <form onSubmit={this.handleSubmit}>
            
            {/* Text input */}
            <div className="form-group mb-3">
              <label>Accessory Name</label>
              <input
                type="text"
                className="form-control"
                name="name"
                value={this.state.name}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Textarea */}
            <div className="form-group mb-3">
              <label>Description</label>
              <textarea
                className="form-control"
                name="description"
                value={this.state.description}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Select dropdown */}
            <div className="form-group mb-3">
              <label>Category</label>
              <select
                className="form-control"
                name="category"
                value={this.state.category}
                onChange={this.handleChange}
              >
                <option value="Electronics">Electronics</option>
                <option value="Fashion">Fashion</option>
                <option value="Home">Home</option>
              </select>
            </div>

            {/* Radio buttons */}
            <div className="form-group mb-3">
              <label>Brand</label>
              <div>
                <input
                  type="radio"
                  name="brand"
                  value="Sony"
                  checked={this.state.brand === "Sony"}
                  onChange={this.handleChange}
                />{" "}
                Sony
              </div>
              <div>
                <input
                  type="radio"
                  name="brand"
                  value="Samsung"
                  checked={this.state.brand === "Samsung"}
                  onChange={this.handleChange}
                />{" "}
                Samsung
              </div>
              <div>
                <input
                  type="radio"
                  name="brand"
                  value="LG"
                  checked={this.state.brand === "LG"}
                  onChange={this.handleChange}
                />{" "}
                LG
              </div>
            </div>

            {/* Checkbox */}
            <div className="form-group mb-3">
              <input
                type="checkbox"
                name="inStock"
                checked={this.state.inStock}
                onChange={this.handleChange}
              />{" "}
              Available in stock
            </div>

            {/* Number input */}
            <div className="form-group mb-3">
              <label>Warranty (years)</label>
              <input
                type="number"
                className="form-control"
                name="warranty"
                value={this.state.warranty}
                onChange={this.handleChange}
              />
            </div>

            {/* Submit */}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show table only if submitted */}
        {this.state.submitted && (
          <div className="card p-4 shadow-sm">
            <h3 className="text-center mb-3">Submitted Accessory Details</h3>
            <table className="table table-bordered">
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
                  <td>{this.state.submitted.inStock ? "Yes" : "No"}</td>
                </tr>
                <tr>
                  <th>Warranty</th>
                  <td>{this.state.submitted.warranty} years</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default AccessoriesForm;
