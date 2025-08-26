import React from "react";

// Simple functional component for the Home page
function Home() {
  return (
    // Bootstrap container adds proper margins/padding
    <div className="container mt-4">
      {/* Page heading text */}
      <h2>Welcome to the Income Tax Department Portal</h2>
    </div>
  );
}

// Export so Routes can render this component
export default Home;