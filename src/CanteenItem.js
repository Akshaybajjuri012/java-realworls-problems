import React from "react";

// Functional Component CanteenItem
// Receives props: name, price, category, available
const CanteenItem = ({ name, price, category, available }) => {
  return (
    <li>
      {/* Displaying values from props */}
      {name} – Price: ₹{price} – {category} –{" "}
      {/* Conditional rendering: if available is "Yes", show Available, else show Not Available */}
      {available === "Yes" ? "Available" : "Not Available"}
    </li>
  );
};

export default CanteenItem;
