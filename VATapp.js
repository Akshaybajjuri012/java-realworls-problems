
const { calculateVAT } = require("./VATCalculator");

// Single jewellery item
const jewellery = { id: 1, name: "Gold Necklace", price: 50000 };

// Calculate VAT
const result = calculateVAT(jewellery.price);

// Display result
console.log("Jewellery ID:", jewellery.id);
console.log("Name:", jewellery.name);
console.log("Price:", jewellery.price);
console.log("VAT (3%):", result.vat);
console.log("Total Price:", result.totalPrice);

// BONUS: Multiple items
const jewelleryItems = [
  { id: 2, name: "Gold Ring", price: 20000 },
  { id: 3, name: "Diamond Earrings", price: 75000 },
  { id: 4, name: "Silver Bracelet", price: 10000 },
];

console.log("\n--- Multiple Items ---");
jewelleryItems.forEach((item) => {
  const res = calculateVAT(item.price, 3); // VAT rate configurable
  console.log(`Jewellery ID: ${item.id}`);
  console.log(`Name: ${item.name}`);
  console.log(`Price: ${item.price}`);
  console.log(`VAT (3%): ${res.vat}`);
  console.log(`Total Price: ${res.totalPrice}`);
  console.log("---------------------");
});
