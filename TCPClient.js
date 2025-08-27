
const net = require("net");
const readline = require("readline");

// Create connection to server
const client = new net.Socket();
client.connect(5000, "127.0.0.1", () => {
  console.log("Connected to server.");
});

// Handle server responses
client.on("data", (data) => {
  console.log("Server Response:\n" + data.toString());
});

// Handle connection close
client.on("close", () => {
  console.log("Connection closed.");
});

// Handle errors
client.on("error", (err) => {
  console.error("Connection error:", err.message);
});

// Allow user input from terminal
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  client.write(input);

  if (input.trim().toUpperCase() === "EXIT") {
    rl.close();
  }
});
