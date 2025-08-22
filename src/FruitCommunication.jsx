import React, { useState } from 'react';

//  Child A: Displays fruit list and lets user select one
const ChildA = ({ fruits, onSelect }) => {
  return (
    <div className="card p-3 m-2">
      <h5> Fruit List</h5>
      <ul className="list-group">
        {fruits.map((fruit, index) => (
          <li
            key={index}
            className="list-group-item list-group-item-action"
            onClick={() => onSelect(fruit)} //  Notify parent of selected fruit
            style={{ cursor: 'pointer' }}
          >
            {fruit}
          </li>
        ))}
      </ul>
    </div>
  );
};

//  Child B: Sends a new fruit ("Orange") to parent when button is clicked
const ChildB = ({ onSendFruit }) => {
  return (
    <div className="card p-3 m-2">
      <h5>Sender</h5>
      <button className="btn btn-success" onClick={() => onSendFruit('Orange')}>
        Send Fruit
      </button>
    </div>
  );
};

// Child C: Displays the fruit selected in Child A
const ChildC = ({ selectedFruit }) => {
  return (
    <div className="card p-3 m-2">
      <h5> Selected Fruit</h5>
      <p className="lead">{selectedFruit || 'None selected yet'}</p>
    </div>
  );
};

// Parent Component: Manages state and connects all children
const ParentComponent = () => {
  const [fruits, setFruits] = useState(['Apple', 'Mango']); // Initial fruit list
  const [selectedFruit, setSelectedFruit] = useState('');   // Selected fruit from Child A

  //  Add fruit from Child B
  const handleAddFruit = (newFruit) => {
    if (!fruits.includes(newFruit)) {
      setFruits([...fruits, newFruit]); // Update fruit list
    }
  };

  // Update selected fruit from Child A
  const handleSelectFruit = (fruit) => {
    setSelectedFruit(fruit);
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-4">React – Parent / Child / Sibling Communication</h2>
      <div className="row">
        {/* Child A: Displays fruit list */}
        <div className="col-md-4">
          <ChildA fruits={fruits} onSelect={handleSelectFruit} />
        </div>

        {/* Child B: Sends new fruit to parent */}
        <div className="col-md-4">
          <ChildB onSendFruit={handleAddFruit} />
        </div>

        {/* Child C: Displays selected fruit */}
        <div className="col-md-4">
          <ChildC selectedFruit={selectedFruit} />
        </div>
      </div>
    </div>
  );
};

export default ParentComponent;