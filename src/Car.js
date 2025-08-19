import React, { Component } from "react";

// Class Component Car
class Car extends Component {
  render() {
    // Destructure props (brand, model, color, year) for easy use
    const { brand, model, color, year } = this.props;

    return (
      <div>
        {/* Heading */}
        <h2>Car Details</h2>

        {/* Display car details passed from props */}
        <p><b>Brand:</b> {brand}</p>
        <p><b>Model:</b> {model}</p>
        <p><b>Color:</b> {color}</p>
        <p><b>Year:</b> {year}</p>
      </div>
    );
  }
}

export default Car;
