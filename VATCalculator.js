// Function to calculate VAT
function calculateVAT(price, vatRate = 3) {
  const vat = (price * vatRate) / 100;
  const totalPrice = price + vat;
  return {
    vat: vat,
    totalPrice: totalPrice,
  };
}

// Export the function
module.exports = { calculateVAT };
