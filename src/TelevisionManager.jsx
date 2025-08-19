import React, { Component } from "react";

// Functional Component: displays television models
function TelevisionList({ models }) {
  return (
    <div>
      <h3>Television List</h3>
      <ul>
        {models.map((model, index) => (
          <li key={index}>{model}</li>
        ))}
      </ul>
    </div>
  );
}

// Class Component: manages television models
class TelevisionManager extends Component {
  // constructor runs first when component is created
  constructor(props) {
    // call parent class (Component) constructor
    super(props);
    // initialize component state
    this.state = {
      models: ["Samsung", "Sony", "LG"], 
      newModel: "" 
    };
  }

  // update input value
  handleInputChange = (e) => {
    this.setState({ newModel: e.target.value });
  };

  // add new television model using spread operator
  addModel = () => {
     // check: only add if input is not empty (ignores spaces)
    if (this.state.newModel.trim() !== "") {
      this.setState({
        models: [...this.state.models, this.state.newModel],
        newModel: ""
      });
    }
  };

  render() {
    return (
      <div>
        <h3>Television</h3>
        <input
          type="text"
          value={this.state.newModel}
          onChange={this.handleInputChange}
          placeholder="Enter TV model"
        />
        <button onClick={this.addModel}>Add</button>

        {/* Pass models to child functional component */}
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}

export default TelevisionManager;
