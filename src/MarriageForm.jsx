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
      <div className="container mt-4">
        {/* Card for Form */}
        <div className="card p-4 mb-4 shadow-sm">
          <h3 className="text-center mb-3">Marriage Form</h3>
          <form onSubmit={this.handleSubmit}>
            {/* Bride Name */}
            <div className="form-group mb-3">
              <label>Bride Name</label>
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
            <div className="form-group mb-3">
              <label>Groom Name</label>
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
            <div className="form-group mb-3">
              <label>Marriage Date</label>
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
            <div className="form-group mb-3">
              <label>Venue</label>
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
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show Marriage Details after submission */}
        {this.state.submitted && (
          <div className="card p-4 shadow-sm">
            <h3 className="text-center mb-3">Marriage Details</h3>
            <p><strong>Bride Name:</strong> {this.state.submitted.brideName}</p>
            <p><strong>Groom Name:</strong> {this.state.submitted.groomName}</p>
            <p><strong>Date:</strong> {this.state.submitted.date}</p>
            <p><strong>Venue:</strong> {this.state.submitted.venue}</p>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm;
