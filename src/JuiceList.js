import React from "react";
import Juice from "./Juice";

const JuiceList = () => {
  // Array of juice objects
  const juices = [
    { id: 1, name: "Grapes Juice", price: 80 },
    { id: 2, name: "Apple Juice", price: 100 },
    { id: 3, name: "Mango Juice", price: 120 },
    { id: 4, name: "Karbuja Juice", price: 80 }
  ];

  return (
    <div>
      <h2>Juice Menu</h2>
      <table border="1" cellPadding="8" style={{ borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {juices.map((juice) => (
            <Juice key={juice.id} id={juice.id} name={juice.name} price={juice.price} />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default JuiceList;
