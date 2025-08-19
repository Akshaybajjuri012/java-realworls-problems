import React from "react";
import Juice from "./Juice"; // Importing child component

const JuiceList = () => {
  // Array of juice objects (data for our table)
  const juices = [
    { id: 1, name: "Grapes Juice", price: 80 },
    { id: 2, name: "Apple Juice", price: 100 },
    { id: 3, name: "Mango Juice", price: 120 },
    { id: 4, name: "Karbuja Juice", price: 80 }
  ];

  return (
    <div>
      <h2>Juice Menu</h2>

      {/* Table with simple inline CSS for borders */}
      <table border="1" cellPadding="8" style={{ borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price</th>
          </tr>
        </thead>

        <tbody>
          {/* Loop through juices array and render <Juice /> for each item */}
          {juices.map((juice) => (
            <Juice
              key={juice.id}     // unique key for each row
              id={juice.id}      // pass id as prop
              name={juice.name}  // pass name as prop
              price={juice.price} // pass price as prop
            />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default JuiceList;
