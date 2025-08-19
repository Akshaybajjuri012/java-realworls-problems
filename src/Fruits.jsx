import React, { Component } from "react";

// Functional Component: shows fruits in a list
function FruitList({ fruits }) {
  return (
    <div>
      <h3>FruitList</h3>
    <ul>
        {/* 
    Loop through the "fruits" array using map().
    - Each item in the array is called "fruit"
    - "index" is the position of that fruit in the array
    - For every fruit, create an <li> element
    - key={index} helps React identify each item uniquely
  */}
      {fruits.map((fruit, index) => (
        <li key={index}>{fruit}</li>
      ))}
    </ul>
    </div>
  );
}

// Class Component: manages state + add new fruit
class Fruits extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fruits: ["Apple", "Banana", "Orange"], 
      newFruit: "" 
    };
  }

  // update input value
  handleInputChange = (e) => {
    this.setState({ newFruit: e.target.value });
  };

  // add fruit to list
  addFruit = () => {
    // Check if the input is NOT empty (ignores spaces using trim())
    if (this.state.newFruit.trim() !== "") {
      // Update the component's state
      this.setState({
        // Spread operator (...) → keeps all the existing fruits and adds the new fruit at the end of the array
        fruits: [...this.state.fruits, this.state.newFruit],
        // Reset the input field back to empty
        newFruit: ""
      });
    }
  };

  render() {
    return (
      <div>
        <h3>Fruit</h3>
        <input
          type="text"
          value={this.state.newFruit}
          onChange={this.handleInputChange}
          placeholder="Enter a fruit"
        />
        <button onClick={this.addFruit}>Add Fruit</button>

        {/* Pass fruits to child */}
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

export default Fruits;
