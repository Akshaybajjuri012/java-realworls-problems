import React, { useEffect, useState } from "react";
import axios from "axios";
import { useFormik } from "formik";
import * as Yup from "yup";

const FootballPlayers = () => {
  const [players, setPlayers] = useState([]);
  const [editingPlayer, setEditingPlayer] = useState(null);
  const [message, setMessage] = useState("");

  // Fetch players on load
  useEffect(() => {
    fetchPlayers();
  }, []);

  const fetchPlayers = () => {
    axios.get("http://localhost:5001/players")
      .then(res => setPlayers(res.data))
      .catch(err => console.error(err));
  };

  // Formik setup with Yup validation
  const formik = useFormik({
    initialValues: {
      name: "",
      age: "",
      position: "",
      club: "",
      nationality: "",
      goals: "",
      matchesPlayed: "",
      jerseyNumber: "",
      email: "",
      contactNumber: ""
    },
    validationSchema: Yup.object({
      name: Yup.string().min(3, "Min 3 characters").required("Required"),
      age: Yup.number().min(16).max(40).required("Required"),
      position: Yup.string().oneOf(["Forward", "Midfielder", "Defender", "Goalkeeper"]).required("Required"),
      club: Yup.string().required("Required"),
      nationality: Yup.string().required("Required"),
      goals: Yup.number().min(0).required("Required"),
      matchesPlayed: Yup.number().min(0).required("Required"),
      jerseyNumber: Yup.number().min(1).max(99).required("Required"),
      email: Yup.string().email("Invalid email").required("Required"),
      contactNumber: Yup.string().matches(/^[0-9]{10}$/, "Must be 10 digits").required("Required")
    }),
    onSubmit: (values, { resetForm }) => {
      if (editingPlayer) {
        // Update player
        axios.put(`http://localhost:5001/players/${editingPlayer.id}`, values)
          .then(() => {
            setMessage("✅ Player updated successfully");
            fetchPlayers();
            resetForm();
            setEditingPlayer(null);
          });
      } else {
        // Add player
        axios.post("http://localhost:5001/players", values)
          .then(() => {
            setMessage("✅ Player added successfully");
            fetchPlayers();
            resetForm();
          });
      }
    }
  });

  const handleEdit = (player) => {
    setEditingPlayer(player);
    formik.setValues(player);
  };

  const handleDelete = (id) => {
    axios.delete(`http://localhost:5001/players/${id}`)
      .then(() => {
        setMessage("🗑️ Player deleted");
        fetchPlayers();
      });
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-3">Player Form</h2>

      {/* ✅ Success/Error message */}
      {message && <div className="alert alert-success">{message}</div>}

      {/* Form */}
      <form onSubmit={formik.handleSubmit} className="row g-3 border p-3 rounded">
        {[
          { label: "Name", name: "name", type: "text" },
          { label: "Age", name: "age", type: "number" },
          { label: "Position", name: "position", type: "select", options: ["Forward", "Midfielder", "Defender", "Goalkeeper"] },
          { label: "Club", name: "club", type: "text" },
          { label: "Nationality", name: "nationality", type: "text" },
          { label: "Goals", name: "goals", type: "number" },
          { label: "Matches Played", name: "matchesPlayed", type: "number" },
          { label: "Jersey Number", name: "jerseyNumber", type: "number" },
          { label: "Email", name: "email", type: "text" },
          { label: "Contact Number", name: "contactNumber", type: "text" }
        ].map((field, i) => (
          <div className="col-md-6" key={i}>
            <label className="form-label">{field.label}</label>
            {field.type === "select" ? (
              <select
                name={field.name}
                className="form-select"
                value={formik.values[field.name]}
                onChange={formik.handleChange}
              >
                <option value="">--Select--</option>
                {field.options.map(opt => <option key={opt} value={opt}>{opt}</option>)}
              </select>
            ) : (
              <input
                type={field.type}
                name={field.name}
                className="form-control"
                value={formik.values[field.name]}
                onChange={formik.handleChange}
              />
            )}
            {formik.touched[field.name] && formik.errors[field.name] && (
              <div className="text-danger">{formik.errors[field.name]}</div>
            )}
          </div>
        ))}

        <div className="col-12">
          <button type="submit" className="btn btn-primary me-2">
            {editingPlayer ? "Update Player" : "Add Player"}
          </button>
          {editingPlayer && (
            <button type="button" className="btn btn-secondary" onClick={() => {
              setEditingPlayer(null);
              formik.resetForm();
            }}>Cancel</button>
          )}
        </div>
      </form>

      {/* Player List */}
      <h3 className="mt-4">Player List</h3>
      <table className="table table-bordered text-center">
        <thead className="table-dark">
          <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Position</th>
            <th>Club</th>
            <th>Goals</th>
            <th>Matches Played</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {players.map(player => (
            <tr key={player.id}>
              <td>{player.name}</td>
              <td>{player.age}</td>
              <td>{player.position}</td>
              <td>{player.club}</td>
              <td>{player.goals}</td>
              <td>{player.matchesPlayed}</td>
              <td>
                <button className="btn btn-sm btn-warning me-2" onClick={() => handleEdit(player)}>Edit</button>
                <button className="btn btn-sm btn-danger" onClick={() => handleDelete(player.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FootballPlayers;
