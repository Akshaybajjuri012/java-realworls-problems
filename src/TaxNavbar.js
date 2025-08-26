// Import React to define the component
import React from "react";
// Import Link from React Router to navigate without reloading the page
import { Link } from "react-router-dom";

// Functional component for the top navigation bar
function TaxNavbar() {
  return (
    // Bootstrap navbar container with dark theme and expansion on large screens
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      {/* Full-width container for navbar content */}
      <div className="container-fluid">
        {/* Brand/logo that links to the home route ("/") */}
        <Link className="navbar-brand" to="/">
          Tax Portal
        </Link>

        {/* Hamburger button shown on small screens to toggle the collapsed menu */}
        <button
          className="navbar-toggler"          // Bootstrap toggler styles
          type="button"                        // Button element
          data-bs-toggle="collapse"            // Bootstrap attribute to toggle collapse
          data-bs-target="#navbarNav"          // The id of the collapsible content
          aria-controls="navbarNav"            // Accessibility: identifies controlled element
          aria-expanded="false"                // Accessibility: initial collapsed state
          aria-label="Toggle navigation"       // Accessibility label
        >
          {/* The icon inside the toggler button */}
          <span className="navbar-toggler-icon"></span>
        </button>

        {/* Collapsible area that contains the navigation links */}
        <div className="collapse navbar-collapse" id="navbarNav">
          {/* Unordered list for nav links */}
          <ul className="navbar-nav">
            {/* Each <li> is a nav item; Link navigates to the given route */}
            <li className="nav-item">
              <Link className="nav-link" to="/">Home</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/add-taxpayer">Add Taxpayer</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/taxpayer-list">Taxpayer List</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/calculate-tax">Calculate Tax</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/tax-rates">Tax Rates</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/contact">Contact</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/about">About</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/faq">FAQ</Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default TaxNavbar;

