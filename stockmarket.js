const db = require('./mysqldbconnection');


function addStock(symbol, companyName, price, volume, callback) {
    // SQL query to insert a new stock record
    const sql = 'INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)';
    // Execute the query with placeholders (helps prevent SQL injection)
    db.query(sql, [symbol, companyName, price, volume], (err, result) => {
        if (err) return callback(err);
        console.log('Added stock with ID:', result.insertId); // Print the newly inserted row’s ID
        callback(null, result.insertId); // Pass result back via callback
    });
}

/* 
   READ - List all stocks
   To fetch and view all stock records from the database.
 */
function listStocks(callback) {
    const sql = 'SELECT * FROM stocks';
    db.query(sql, (err, results) => {
        if (err) return callback(err);
        console.log('All Stocks:', results); // Display all stocks as an array of objects
        callback(null, results);
    });
}

/* 
   UPDATE - Modify stock price & volume
   Stock values change frequently, so we must update them.
 */
function updateStockPriceAndVolume(id, price, volume, callback) {
    const sql = 'UPDATE stocks SET price = ?, volume = ? WHERE id = ?';
    db.query(sql, [price, volume, id], (err, result) => {
        if (err) return callback(err);
        console.log('Updated records:', result.affectedRows); // affectedRows tells how many rows were updated
        callback(null, result.affectedRows);
    });
}

/*  
   DELETE - Remove stock by ID
   Sometimes a stock may be delisted or removed from our database.
 */
function deleteStock(id, callback) {
    const sql = 'DELETE FROM stocks WHERE id = ?';
    db.query(sql, [id], (err, result) => {
        if (err) return callback(err);
        console.log('Deleted records:', result.affectedRows); // Shows how many rows were deleted
        callback(null, result.affectedRows);
    });
}

/* 
   Sequential Execution of CRUD
   We perform each operation step-by-step in sequence using callbacks.
 */
addStock("AAPL", "Apple Inc.", 175.50, 1000, (err, insertId) => {
    if (err) throw err;

    // List all stocks
    listStocks((err, stocks) => {
        if (err) throw err;

        // Update stock with the inserted ID
        updateStockPriceAndVolume(insertId, 180.00, 1200, (err, updated) => {
            if (err) throw err;

            // Delete the stock after update
            deleteStock(insertId, (err, deleted) => {
                if (err) throw err;

                // Close DB connection after all operations
                db.end((err) => {
                    if (err) throw err;
                    console.log('MySQL connection closed');
                });
            });
        });
    });
});
