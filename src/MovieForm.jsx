import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

class MovieForm extends Component {
  constructor(props) {
    super(props);
    console.log("constructor executed");

    // State stores form inputs + list of added movies
    this.state = {
      movieTitle: "",
      director: "",
      releaseYear: "",
      genre: "Action", // default value
      rating: "",
      description: "",
      // checkboxes for streaming platforms
      platforms: {
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
      movies: [], // list of added movies
    };
  }

  // Lifecycle Methods for Logging
  static getDerivedStateFromProps(props, state) {
    console.log("getDerivedStateFromProps executed");
    return null; // No change to state
  }

  componentDidMount() {
    console.log("componentDidMount executed");
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true; // Always re-render when state changes
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate executed");
    return null; // Snapshot not used here
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate executed");
  }

  componentWillUnmount() {
    console.log("componentWillUnmount executed");
  }

  // Handle input change for text, number, select, textarea, radio
  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  // Handle checkbox changes (updates platforms object in state)
  handleCheckboxChange = (e) => {
    const { name, checked } = e.target;
    this.setState((prevState) => ({
      platforms: { ...prevState.platforms, [name]: checked },
    }));
  };

  // On form submit: create new movie object, update state, reset form
  handleSubmit = (e) => {
    e.preventDefault();

    const { movieTitle, director, releaseYear, genre, rating, description, platforms } =
      this.state;

    // Collect selected streaming platforms
    const selectedPlatforms = Object.keys(platforms).filter(
      (platform) => platforms[platform]
    );

    // New movie entry
    const newMovie = {
      movieTitle,
      director,
      releaseYear,
      genre,
      rating,
      description,
      platforms: selectedPlatforms,
    };

    // Update movie list + reset form fields
    this.setState((prevState) => ({
      movies: [...prevState.movies, newMovie],
      movieTitle: "",
      director: "",
      releaseYear: "",
      genre: "Action",
      rating: "",
      description: "",
      platforms: {
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
    }));
  };

  render() {
    console.log("render executed");

    return (
      <div className="container mt-4">
        {/* Bootstrap card to hold the form */}
        <div className="card p-4 shadow">
          <h3>Add Movie</h3>
          <form onSubmit={this.handleSubmit}>
            {/* Movie Title Input */}
            <div className="mb-3">
              <label>Movie Title</label>
              <input
                type="text"
                className="form-control"
                name="movieTitle"
                value={this.state.movieTitle}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Director Input */}
            <div className="mb-3">
              <label>Director</label>
              <input
                type="text"
                className="form-control"
                name="director"
                value={this.state.director}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Release Year Input */}
            <div className="mb-3">
              <label>Release Year</label>
              <input
                type="number"
                className="form-control"
                name="releaseYear"
                value={this.state.releaseYear}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Genre Dropdown */}
            <div className="mb-3">
              <label>Genre</label>
              <select
                className="form-control"
                name="genre"
                value={this.state.genre}
                onChange={this.handleChange}
              >
                <option>Action</option>
                <option>Comedy</option>
                <option>Drama</option>
                <option>Sci-Fi</option>
                <option>Horror</option>
              </select>
            </div>

            {/* Rating as radio buttons */}
            <div className="mb-3">
              <label>Rating</label>
              <br />
              {[1, 2, 3, 4, 5].map((num) => (
                <label key={num} className="me-3">
                  <input
                    type="radio"
                    name="rating"
                    value={num}
                    checked={this.state.rating === String(num)}
                    onChange={this.handleChange}
                  />{" "}
                  {num}
                </label>
              ))}
            </div>

            {/* Description Textarea */}
            <div className="mb-3">
              <label>Description</label>
              <textarea
                className="form-control"
                name="description"
                value={this.state.description}
                onChange={this.handleChange}
              ></textarea>
            </div>

            {/* Checkboxes for Streaming Platforms */}
            <div className="mb-3">
              <label>Available on Streaming Platforms</label>
              <br />
              {Object.keys(this.state.platforms).map((platform) => (
                <label key={platform} className="me-3">
                  <input
                    type="checkbox"
                    name={platform}
                    checked={this.state.platforms[platform]}
                    onChange={this.handleCheckboxChange}
                  />{" "}
                  {platform}
                </label>
              ))}
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary">
              Add Movie
            </button>
          </form>
        </div>

        {/* Table to display added movies */}
        {this.state.movies.length > 0 && (
          <table className="table table-bordered mt-4">
            <thead>
              <tr>
                <th>Title</th>
                <th>Director</th>
                <th>Release Year</th>
                <th>Genre</th>
                <th>Rating</th>
                <th>Available on Streaming Platforms</th>
              </tr>
            </thead>
            <tbody>
              {this.state.movies.map((movie, index) => (
                <tr key={index}>
                  <td>{movie.movieTitle}</td>
                  <td>{movie.director}</td>
                  <td>{movie.releaseYear}</td>
                  <td>{movie.genre}</td>
                  <td>{movie.rating}</td>
                  <td>{movie.platforms.join(", ")}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

export default MovieForm;
