const mysql = require('mysql2');
const readline = require('readline');// Import Node.js built-in readline module to take interactive input from the console

// MySQL connection
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',         
    password: 'Akshay@9100', 
    database: 'stock_market'
});

// Connect to MySQL
db.connect((err) => {
    if (err) throw err;
    console.log(" Connected to MySQL");
    mainMenu();
});

// readline interface for console input
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Display Menu
function mainMenu() {
    console.log(`\nStock Market Management System
-----------------------------------
1. Add Stock
2. View All Stocks
3. View Stock by ID
4. Update Stock Price & Volume
5. Delete Stock
6. Exit`);

    rl.question("Enter your choice: ", (choice) => {
        switch (choice) {
            case "1":
                addStock();
                break;
            case "2":
                viewAllStocks();
                break;
            case "3":
                viewStockById();
                break;
            case "4":
                updateStock();
                break;
            case "5":
                deleteStock();
                break;
            case "6":
                exitApp();
                break;
            default:
                console.log(" Invalid choice, please try again.");
                mainMenu();
        }
    });
}

/* ----------------- CRUD FUNCTIONS ----------------- */

// Add Stock
function addStock() {
    rl.question("Enter Stock Symbol: ", (symbol) => {
        if (!symbol.trim()) return invalidInput("Symbol cannot be empty.", addStock);

        rl.question("Enter Company Name: ", (companyName) => {
            if (!companyName.trim()) return invalidInput("Company Name cannot be empty.", addStock);

            rl.question("Enter Price: ", (price) => {
                if (isNaN(price) || price <= 0) return invalidInput("Price must be a positive number.", addStock);

                rl.question("Enter Volume: ", (volume) => {
                    if (isNaN(volume) || volume <= 0) return invalidInput("Volume must be a positive number.", addStock);

                    const sql = "INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)";
                    db.query(sql, [symbol, companyName, parseFloat(price), parseInt(volume)], (err, result) => {
                        if (err) throw err;
                        console.log("Stock added successfully!");
                        mainMenu();
                    });
                });
            });
        });
    });
}

// View All Stocks
function viewAllStocks() {
    const sql = "SELECT * FROM stocks";
    db.query(sql, (err, results) => {
        if (err) throw err;
        if (results.length === 0) {
            console.log("📭 No stocks found.");
        } else {
            results.forEach(stock => {
                console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
            });
        }
        mainMenu();
    });
}

// View Stock by ID
function viewStockById() {
    rl.question("Enter Stock ID: ", (id) => {
        if (isNaN(id) || id <= 0) return invalidInput("Invalid Stock ID.", viewStockById);

        const sql = "SELECT * FROM stocks WHERE id = ?";
        db.query(sql, [id], (err, result) => {
            if (err) throw err;
            if (result.length === 0) {
                console.log("Stock not found.");
            } else {
                const stock = result[0];
                console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
            }
            mainMenu();
        });
    });
}

// Update Stock
function updateStock() {
    rl.question("Enter Stock ID to Update: ", (id) => {
        if (isNaN(id) || id <= 0) return invalidInput("Invalid Stock ID.", updateStock);

        rl.question("Enter New Price: ", (price) => {
            if (isNaN(price) || price <= 0) return invalidInput("Price must be a positive number.", updateStock);

            rl.question("Enter New Volume: ", (volume) => {
                if (isNaN(volume) || volume <= 0) return invalidInput("Volume must be a positive number.", updateStock);

                const sql = "UPDATE stocks SET price = ?, volume = ? WHERE id = ?";
                db.query(sql, [parseFloat(price), parseInt(volume), id], (err, result) => {
                    if (err) throw err;
                    if (result.affectedRows === 0) {
                        console.log(" Stock not found.");
                    } else {
                        console.log(" Stock updated successfully!");
                    }
                    mainMenu();
                });
            });
        });
    });
}

// Delete Stock
function deleteStock() {
    rl.question("Enter Stock ID to Delete: ", (id) => {
        if (isNaN(id) || id <= 0) return invalidInput("Invalid Stock ID.", deleteStock);

        const sql = "DELETE FROM stocks WHERE id = ?";
        db.query(sql, [id], (err, result) => {
            if (err) throw err;
            if (result.affectedRows === 0) {
                console.log(" Stock not found.");
            } else {
                console.log(" Stock deleted successfully!");
            }
            mainMenu();
        });
    });
}

// Exit Program
function exitApp() {
    console.log(" Exiting Stock Market Management System...");
    rl.close();
    db.end();
}

/* ----------------- Helper Function ----------------- */
function invalidInput(message, retryFunction) {
    console.log(message);
    retryFunction();
}
