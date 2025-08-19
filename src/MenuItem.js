import React, { Component } from "react";

class MenuItem extends Component {
  render() {
    // Destructuring props for cleaner access
    const { name, price, category, available } = this.props;

    return (
      <li>
        {/* Display the menu item details */}
        {name} – ₹ {price} ({category}), {available}
      </li>
    );
  }
}

export default MenuItem;
