
const net = require("net");

// In-memory jewellery stock
let jewelleryItems = [
  { id: 1, name: "Gold Ring", quantity: 5, price: 15000 },
  { id: 2, name: "Silver Necklace", quantity: 3, price: 5000 },
];

// Create TCP server
const server = net.createServer((socket) => {
  console.log("New client connected!");

  socket.write("Welcome to the Jewellery Store TCP System!\n");
  socket.write("Available Commands: LIST, ADD <id> <name> <quantity> <price>, EXIT\n");

  // Handle incoming data
  socket.on("data", (data) => {
    const input = data.toString().trim();
    const parts = input.split(" ");
    const command = parts[0].toUpperCase();

    if (command === "LIST") {
      let response = "";
      jewelleryItems.forEach((item) => {
        response += `ID: ${item.id}, Name: ${item.name}, Quantity: ${item.quantity}, Price: ${item.price}\n`;
      });
      socket.write(response || "No items in stock.\n");
    } else if (command === "ADD") {
      if (parts.length < 5) {
        socket.write("Usage: ADD <id> <name> <quantity> <price>\n");
      } else {
        const id = parseInt(parts[1]);
        const name = parts[2];
        const quantity = parseInt(parts[3]);
        const price = parseFloat(parts[4]);

        jewelleryItems.push({ id, name, quantity, price });
        console.log(`Item Added: ID=${id}, Name=${name}, Quantity=${quantity}, Price=${price}`);
        socket.write("Jewellery item added successfully!\n");
      }
    } else if (command === "EXIT") {
      socket.write("Client disconnected.\n");
      socket.end();
    } else {
      socket.write("Unknown command. Try LIST, ADD, or EXIT.\n");
    }
  });

  // Handle client disconnection
  socket.on("end", () => {
    console.log("Client disconnected.");
  });

  socket.on("error", (err) => {
    console.error("Socket error:", err.message);
  });
});

// Start server
server.listen(5000, () => {
  console.log("TCP Server running on port 5000...");
});
