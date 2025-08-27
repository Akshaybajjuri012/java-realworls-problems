const fs = require("fs");
const path = require("path");

// File paths
const fruitsFile = path.join(__dirname, "fruits.txt");
const fruitsCopyFile = path.join(__dirname, "fruits_copy.txt");

// Fruit data
const fruits = [
  { id: 1, name: "Apple", color: "Red", price: 120 },
  { id: 2, name: "Banana", color: "Yellow", price: 40 },
  { id: 3, name: "Mango", color: "Orange", price: 150 },
];

// 1. Writable Stream → Write fruits data into fruits.txt
const writeStream = fs.createWriteStream(fruitsFile);

writeStream.on("finish", () => {
  console.log("Data written to fruits.txt successfully.");

  // 2. Readable Stream → Read fruits.txt
  console.log("\nReading fruits.txt using stream...");
  const readStream = fs.createReadStream(fruitsFile, { encoding: "utf8" });

  // 4. Stream Events
  let buffer = "";
  readStream.on("data", (chunk) => {
    buffer += chunk;
  });

  readStream.on("end", () => {
    const lines = buffer.trim().split("\n");
    lines.forEach((line) => {
      const fruit = JSON.parse(line);
      console.log(
        `Fruit ID: ${fruit.id}, Name: ${fruit.name}, Color: ${fruit.color}, Price: ${fruit.price}`
      );
    });

    // 3. Pipe Streams → Copy fruits.txt to fruits_copy.txt
    const sourceStream = fs.createReadStream(fruitsFile);
    const destStream = fs.createWriteStream(fruitsCopyFile);
    sourceStream.pipe(destStream);

    destStream.on("finish", () => {
      console.log("\nContent copied to fruits_copy.txt using pipe.");
    });
  });

  readStream.on("error", (err) => {
    console.error("Error reading file:", err.message);
  });
});

// Write each fruit as JSON line
fruits.forEach((fruit) => {
  writeStream.write(JSON.stringify(fruit) + "\n");
});
writeStream.end();
