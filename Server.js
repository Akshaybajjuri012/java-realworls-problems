// server.js
const express = require("express");
const bodyParser = require("body-parser");
const path = require("path");

const app = express();
const PORT = 3000;

// Middleware
app.use(bodyParser.urlencoded({ extended: true }));

// Serve index.html at root
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "index.html"));
});

// Handle form submission
app.post("/submit", (req, res) => {
  const { trackingId, senderName, receiverName, pickupAddress, deliveryAddress, weight } = req.body;

  // Validation
  if (!trackingId || !senderName || !receiverName || !pickupAddress || !deliveryAddress || !weight) {
    return res.send("Error: All fields are required!");
  }

  // Calculate cost
  const deliveryCost = 50 + (parseFloat(weight) * 20);

  // Response
  res.send(`
    <h2>Courier Booking Confirmation</h2>
    <p><b>Courier Tracking ID:</b> ${trackingId}</p>
    <p><b>Sender:</b> ${senderName}</p>
    <p><b>Receiver:</b> ${receiverName}</p>
    <p><b>Pickup:</b> ${pickupAddress}</p>
    <p><b>Delivery:</b> ${deliveryAddress}</p>
    <p><b>Weight:</b> ${weight} kg</p>
    <p><b>Delivery Cost:</b> ${deliveryCost}</p>
  `);
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
