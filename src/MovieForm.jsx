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
    return null;
  }

  componentDidMount() {
    console.log("componentDidMount executed");
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true;
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate executed");
    return null;
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

    const selectedPlatforms = Object.keys(platforms).filter(
      (platform) => platforms[platform]
    );

    const newMovie = {
      movieTitle,
      director,
      releaseYear,
      genre,
      rating,
      description,
      platforms: selectedPlatforms,
    };

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
      <div className="container mt-5">
        <div className="row justify-content-center">
          <div className="col-lg-8">
            {/* Bootstrap Card for Form */}
            <div className="card shadow-lg border-0">
              <div className="card-body">
                <h3 className="card-title text-center mb-4">Add Movie</h3>
                <form onSubmit={this.handleSubmit}>
                  {/* Movie Title */}
                  <div className="mb-3">
                    <label className="form-label">Movie Title</label>
                    <input
                      type="text"
                      className="form-control"
                      name="movieTitle"
                      value={this.state.movieTitle}
                      onChange={this.handleChange}
                      required
                    />
                  </div>

                  {/* Director */}
                  <div className="mb-3">
                    <label className="form-label">Director</label>
                    <input
                      type="text"
                      className="form-control"
                      name="director"
                      value={this.state.director}
                      onChange={this.handleChange}
                      required
                    />
                  </div>

                  {/* Release Year */}
                  <div className="mb-3">
                    <label className="form-label">Release Year</label>
                    <input
                      type="number"
                      className="form-control"
                      name="releaseYear"
                      value={this.state.releaseYear}
                      onChange={this.handleChange}
                      required
                    />
                  </div>

                  {/* Genre */}
                  <div className="mb-3">
                    <label className="form-label">Genre</label>
                    <select
                      className="form-select"
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

                  {/* Rating */}
                  <div className="mb-3">
                    <label className="form-label">Rating</label>
                    <div>
                      {[1, 2, 3, 4, 5].map((num) => (
                        <div key={num} className="form-check form-check-inline">
                          <input
                            className="form-check-input"
                            type="radio"
                            name="rating"
                            value={num}
                            checked={this.state.rating === String(num)}
                            onChange={this.handleChange}
                          />
                          <label className="form-check-label">{num}</label>
                        </div>
                      ))}
                    </div>
                  </div>

                  {/* Description */}
                  <div className="mb-3">
                    <label className="form-label">Description</label>
                    <textarea
                      className="form-control"
                      rows="3"
                      name="description"
                      value={this.state.description}
                      onChange={this.handleChange}
                    ></textarea>
                  </div>

                  {/* Platforms */}
                  <div className="mb-3">
                    <label className="form-label">Available on Streaming Platforms</label>
                    <div>
                      {Object.keys(this.state.platforms).map((platform) => (
                        <div key={platform} className="form-check form-check-inline">
                          <input
                            className="form-check-input"
                            type="checkbox"
                            name={platform}
                            checked={this.state.platforms[platform]}
                            onChange={this.handleCheckboxChange}
                          />
                          <label className="form-check-label">{platform}</label>
                        </div>
                      ))}
                    </div>
                  </div>

                  {/* Submit Button */}
                  <div className="d-grid">
                    <button type="submit" className="btn btn-primary btn-lg">
                      Add Movie
                    </button>
                  </div>
                </form>
              </div>
            </div>

            {/* Movies Table */}
            {this.state.movies.length > 0 && (
              <div className="table-responsive mt-4">
                <table className="table table-hover table-striped align-middle">
                  <thead className="table-dark">
                    <tr>
                      <th>Title</th>
                      <th>Director</th>
                      <th>Release Year</th>
                      <th>Genre</th>
                      <th>Rating</th>
                      <th>Streaming Platforms</th>
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
              </div>
            )}
          </div>
        </div>
      </div>
    );
  }
}

export default MovieForm;
