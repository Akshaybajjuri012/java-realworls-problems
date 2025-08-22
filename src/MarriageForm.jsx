import React, { Component } from "react";

class MarriageForm extends Component {
  constructor(props) {
    super(props);

    // Initial state for form fields + submitted details
    this.state = {
      brideName: "",
      groomName: "",
      date: "",
      venue: "",
      submitted: null, // will hold submitted details
    };
  }

  // handle input changes
  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };

  // handle form submit
  handleSubmit = (e) => {
    e.preventDefault(); // stop page refresh
    this.setState({
      submitted: {
        brideName: this.state.brideName,
        groomName: this.state.groomName,
        date: this.state.date,
        venue: this.state.venue,
      },
    });
  };

  render() {
    return (
      <div className="container mt-5">
        {/* Card for Form */}
        <div className="card shadow-lg border-0">
          <div className="card-header bg-primary text-white text-center">
            <h3 className="mb-0">💍 Marriage Registration Form</h3>
          </div>
          <div className="card-body p-4">
            <form onSubmit={this.handleSubmit}>
              {/* Bride Name */}
              <div className="mb-3">
                <label className="form-label">Bride Name</label>
                <input
                  type="text"
                  className="form-control"
                  name="brideName"
                  value={this.state.brideName}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Groom Name */}
              <div className="mb-3">
                <label className="form-label">Groom Name</label>
                <input
                  type="text"
                  className="form-control"
                  name="groomName"
                  value={this.state.groomName}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Marriage Date */}
              <div className="mb-3">
                <label className="form-label">Marriage Date</label>
                <input
                  type="date"
                  className="form-control"
                  name="date"
                  value={this.state.date}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Venue */}
              <div className="mb-3">
                <label className="form-label">Venue</label>
                <input
                  type="text"
                  className="form-control"
                  name="venue"
                  value={this.state.venue}
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Submit button */}
              <button type="submit" className="btn btn-success w-100">
                Submit
              </button>
            </form>
          </div>
        </div>

        {/* Show Marriage Details after submission */}
        {this.state.submitted && (
          <div className="card shadow-lg border-0 mt-4">
            <div className="card-header bg-success text-white text-center">
              <h3 className="mb-0">🎉 Marriage Details</h3>
            </div>
            <div className="card-body p-4">
              <p>
                <strong>Bride Name:</strong> {this.state.submitted.brideName}
              </p>
              <p>
                <strong>Groom Name:</strong> {this.state.submitted.groomName}
              </p>
              <p>
                <strong>Date:</strong> {this.state.submitted.date}
              </p>
              <p>
                <strong>Venue:</strong> {this.state.submitted.venue}
              </p>
            </div>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm;
