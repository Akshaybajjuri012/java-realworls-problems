import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

const ChessTournamentForm = () => {
  const [players, setPlayers] = useState([]);

  // Validation Schema using Yup
  const validationSchema = Yup.object({
    playerName: Yup.string()
      .min(3, "Must be at least 3 characters")
      .required("Required"),
    dob: Yup.date()
      .required("Required")
      .test("age", "Age must be between 5 and 90 years", function (value) {
        const today = new Date();
        const birthDate = new Date(value);
        const age = today.getFullYear() - birthDate.getFullYear();
        return age >= 5 && age <= 90;
      }),
    gender: Yup.string().required("Required"),
    fideId: Yup.string()
      .matches(/^\d{8}$/, "Must be exactly 8 digits")
      .required("Required"),
    rating: Yup.number()
      .min(100, "Min rating is 100")
      .max(3000, "Max rating is 3000")
      .required("Required"),
    email: Yup.string().email("Invalid email").required("Required"),
    mobile: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Must be a valid 10-digit number starting with 6-9")
      .required("Required"),
    country: Yup.string().required("Required"),
    category: Yup.string().required("Required"),
    parentContact: Yup.string().when("category", {
      is: "Under 12",
      then: (schema) =>
        schema
          .matches(/^[6-9]\d{9}$/, "Must be a valid 10-digit number")
          .required("Parent contact is required"),
      otherwise: (schema) => schema.notRequired(),
    }),
    paymentConfirmed: Yup.boolean().oneOf([true], "Must confirm payment"),
    terms: Yup.boolean().oneOf([true], "You must accept terms"),
  });

  // Initial values
  const initialValues = {
    playerName: "",
    dob: "",
    gender: "",
    fideId: "",
    rating: "",
    email: "",
    mobile: "",
    country: "",
    category: "",
    parentContact: "",
    paymentConfirmed: false,
    terms: false,
  };

  // On form submit
  const handleSubmit = (values, { resetForm }) => {
    console.log("Registration Data:", values);
    setPlayers([...players, values]);
    resetForm();
  };

  return (
    <div className="container my-5">
      <div className="card shadow">
        <div className="card-header bg-primary text-white">
          <h4 className="mb-0">Chess Tournament Registration</h4>
        </div>
        <div className="card-body">
          <Formik
            initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={handleSubmit}
          >
            {({ values }) => (
              <Form>
                {/* Player Name */}
                <div className="mb-3">
                  <label className="form-label">Player Name</label>
                  <Field name="playerName" className="form-control" />
                  <ErrorMessage name="playerName" component="div" className="text-danger" />
                </div>

                {/* Date of Birth */}
                <div className="mb-3">
                  <label className="form-label">Date of Birth</label>
                  <Field type="date" name="dob" className="form-control" />
                  <ErrorMessage name="dob" component="div" className="text-danger" />
                </div>

                {/* Gender */}
                <div className="mb-3">
                  <label className="form-label">Gender</label>
                  <Field as="select" name="gender" className="form-select">
                    <option value="">Select...</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                  </Field>
                  <ErrorMessage name="gender" component="div" className="text-danger" />
                </div>

                {/* FIDE ID */}
                <div className="mb-3">
                  <label className="form-label">FIDE ID</label>
                  <Field name="fideId" className="form-control" />
                  <ErrorMessage name="fideId" component="div" className="text-danger" />
                </div>

                {/* Rating */}
                <div className="mb-3">
                  <label className="form-label">Rating</label>
                  <Field name="rating" type="number" className="form-control" />
                  <ErrorMessage name="rating" component="div" className="text-danger" />
                </div>

                {/* Email */}
                <div className="mb-3">
                  <label className="form-label">Email</label>
                  <Field name="email" type="email" className="form-control" />
                  <ErrorMessage name="email" component="div" className="text-danger" />
                </div>

                {/* Mobile */}
                <div className="mb-3">
                  <label className="form-label">Mobile Number</label>
                  <Field name="mobile" className="form-control" />
                  <ErrorMessage name="mobile" component="div" className="text-danger" />
                </div>

                {/* Country */}
                <div className="mb-3">
                  <label className="form-label">Country</label>
                  <Field name="country" className="form-control" />
                  <ErrorMessage name="country" component="div" className="text-danger" />
                </div>

                {/* Category */}
                <div className="mb-3">
                  <label className="form-label">Category</label>
                  <Field as="select" name="category" className="form-select">
                    <option value="">Select...</option>
                    <option value="Under 12">Under 12</option>
                    <option value="Under 18">Under 18</option>
                    <option value="Open">Open</option>
                  </Field>
                  <ErrorMessage name="category" component="div" className="text-danger" />
                </div>

                {/* Parent Contact */}
                {values.category === "Under 12" && (
                  <div className="mb-3">
                    <label className="form-label">Parent Contact</label>
                    <Field name="parentContact" className="form-control" />
                    <ErrorMessage name="parentContact" component="div" className="text-danger" />
                  </div>
                )}

                {/* Payment Confirmation */}
                <div className="form-check mb-3">
                  <Field type="checkbox" name="paymentConfirmed" className="form-check-input" id="paymentConfirmed" />
                  <label className="form-check-label" htmlFor="paymentConfirmed">
                    Payment Confirmed
                  </label>
                  <ErrorMessage name="paymentConfirmed" component="div" className="text-danger" />
                </div>

                {/* Terms & Conditions */}
                <div className="form-check mb-3">
                  <Field type="checkbox" name="terms" className="form-check-input" id="terms" />
                  <label className="form-check-label" htmlFor="terms">
                    Accept Terms & Conditions
                  </label>
                  <ErrorMessage name="terms" component="div" className="text-danger" />
                </div>

                {/* Submit Button */}
                <button type="submit" className="btn btn-primary w-100">
                  Register Player
                </button>
              </Form>
            )}
          </Formik>
        </div>
      </div>

      {/* Display Registered Players Table */}
      {players.length > 0 && (
        <div className="card mt-5 shadow">
          <div className="card-header bg-success text-white">
            <h5 className="mb-0">Registered Players</h5>
          </div>
          <div className="card-body p-0">
            <table className="table table-striped mb-0">
              <thead className="table-dark">
                <tr>
                  <th>Player Name</th>
                  <th>DOB</th>
                  <th>Gender</th>
                  <th>FIDE ID</th>
                  <th>Rating</th>
                  <th>Email</th>
                  <th>Mobile</th>
                  <th>Country</th>
                  <th>Category</th>
                  <th>Parent Contact</th>
                  <th>Payment</th>
                  <th>Terms</th>
                </tr>
              </thead>
              <tbody>
                {players.map((player, index) => (
                  <tr key={index}>
                    <td>{player.playerName}</td>
                    <td>{player.dob}</td>
                    <td>{player.gender}</td>
                    <td>{player.fideId}</td>
                    <td>{player.rating}</td>
                    <td>{player.email}</td>
                    <td>{player.mobile}</td>
                    <td>{player.country}</td>
                    <td>{player.category}</td>
                    <td>{player.parentContact}</td>
                    <td>{player.paymentConfirmed ? "Yes" : "No"}</td>
                    <td>{player.terms ? "Yes" : "No"}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}
    </div>
  );
};

export default ChessTournamentForm;
