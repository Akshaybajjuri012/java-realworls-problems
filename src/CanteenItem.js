import React from "react";

const CanteenItem = ({ name, price, category, available }) => {
  return (
    <li>
      {name} – Price: ₹{price} – {category} –{" "}
      {available === "Yes" ? "Available" : "Not Available"}
    </li>
  );
};

export default CanteenItem;
