import React, { Component, createRef } from "react";


// Controlled Component
class FlightBookingControlled extends Component {
  constructor(props) {
    super(props);

    // State stores all input values for the controlled form
    this.state = {
      passengerName: "",
      email: "",
      gender: "",
      mealPreference: "Veg",
      specialRequest: "",
      submitted: false, // flag to check if form was submitted
    };
  }

  // Handle change for all inputs (updates state in real time)
  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // prevent page reload
    this.setState({ submitted: true }); // mark form as submitted
  };

  render() {
    return (
      <div className="col-md-6">
        <h3 className="mb-3">Controlled Flight Booking Form</h3>

        <form onSubmit={this.handleSubmit}>
          {/* Passenger Name */}
          <div className="mb-3">
            <label className="form-label">Passenger Name</label>
            <input
              type="text"
              className="form-control"
              name="passengerName"
              value={this.state.passengerName}
              onChange={this.handleChange}
            />
          </div>

          {/* Email */}
          <div className="mb-3">
            <label className="form-label">Email</label>
            <input
              type="email"
              className="form-control"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
          </div>

          {/* Gender */}
          <div className="mb-3">
            <label className="form-label d-block">Gender</label>
            <div className="form-check form-check-inline">
              <input
                type="radio"
                className="form-check-input"
                name="gender"
                value="Male"
                onChange={this.handleChange}
              />
              <label className="form-check-label">Male</label>
            </div>
            <div className="form-check form-check-inline">
              <input
                type="radio"
                className="form-check-input"
                name="gender"
                value="Female"
                onChange={this.handleChange}
              />
              <label className="form-check-label">Female</label>
            </div>
          </div>

          {/* Meal Preference */}
          <div className="mb-3">
            <label className="form-label">Meal Preference</label>
            <select
              className="form-select"
              name="mealPreference"
              value={this.state.mealPreference}
              onChange={this.handleChange}
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

          {/* Special Request */}
          <div className="mb-3">
            <label className="form-label">Special Request</label>
            <textarea
              className="form-control"
              name="specialRequest"
              rows="3"
              value={this.state.specialRequest}
              onChange={this.handleChange}
            />
          </div>

          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>

        {/* Display submitted data in a table */}
        {this.state.submitted && (
          <table className="table table-bordered table-striped mt-3">
            <thead className="table-dark">
              <tr>
                <th>Passenger Name</th>
                <th>Email</th>
                <th>Gender</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{this.state.passengerName}</td>
                <td>{this.state.email}</td>
                <td>{this.state.gender}</td>
              </tr>
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

// Uncontrolled Component
class FlightBookingUncontrolled extends Component {
  constructor(props) {
    super(props);

    // Using Refs for form fields (instead of state)
    this.flightNumberRef = createRef();
    this.sourceRef = createRef();
    this.destinationRef = createRef();
    this.dateRef = createRef();
    this.termsRef = createRef();

    this.state = { submitted: false, details: {} };
  }

  // Handle uncontrolled form submission
  handleSubmit = (e) => {
    e.preventDefault();

    // Collect values directly from Refs
    this.setState({
      submitted: true,
      details: {
        flightNumber: this.flightNumberRef.current.value,
        source: this.sourceRef.current.value,
        destination: this.destinationRef.current.value,
        date: this.dateRef.current.value,
        termsAccepted: this.termsRef.current.checked,
      },
    });
  };

  render() {
    return (
      <div className="col-md-6">
        <h3 className="mb-3">Uncontrolled Flight Booking Form</h3>

        <form onSubmit={this.handleSubmit}>
          {/* Flight Number */}
          <div className="mb-3">
            <label className="form-label">Flight Number</label>
            <input type="text" className="form-control" ref={this.flightNumberRef} />
          </div>

          {/* Source */}
          <div className="mb-3">
            <label className="form-label">Source</label>
            <input type="text" className="form-control" ref={this.sourceRef} />
          </div>

          {/* Destination */}
          <div className="mb-3">
            <label className="form-label">Destination</label>
            <input type="text" className="form-control" ref={this.destinationRef} />
          </div>

          {/* Travel Date */}
          <div className="mb-3">
            <label className="form-label">Travel Date</label>
            <input type="date" className="form-control" ref={this.dateRef} />
          </div>

          {/* Terms Accepted */}
          <div className="form-check mb-3">
            <input type="checkbox" className="form-check-input" ref={this.termsRef} />
            <label className="form-check-label">Terms Accepted</label>
          </div>

          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>

        {/* Display submitted data in a Bootstrap Card */}
        {this.state.submitted && (
          <div className="card mt-3 shadow-sm">
            <div className="card-body">
              <h5 className="card-title">Flight Details</h5>
              <p>
                <b>Flight Number:</b> {this.state.details.flightNumber}
              </p>
              <p>
                <b>Source:</b> {this.state.details.source}
              </p>
              <p>
                <b>Destination:</b> {this.state.details.destination}
              </p>
              <p>
                <b>Date:</b> {this.state.details.date}
              </p>
              <p>
                <b>Terms Accepted:</b>{" "}
                {this.state.details.termsAccepted ? "Yes" : "No"}
              </p>
            </div>
          </div>
        )}
      </div>
    );
  }
}

// Parent Component
class App extends Component {
  render() {
    return (
      <div className="container mt-4">
        <div className="row g-4">
          {/* Left: Controlled Form | Right: Uncontrolled Form */}
          <FlightBookingControlled />
          <FlightBookingUncontrolled />
        </div>
      </div>
    );
  }
}

export default App;
