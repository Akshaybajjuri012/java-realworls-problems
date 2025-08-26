import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage, FieldArray } from "formik";
import * as Yup from "yup";

const HockeyTournamentForm = () => {
  const [records, setRecords] = useState([]);

  // Age Calculation Helper
  const calculateAge = (dob) => {
    const today = new Date();
    const birthDate = new Date(dob);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    return age;
  };

  // Validation Schema
  const validationSchema = Yup.object({
    playerName: Yup.string()
      .matches(/^[A-Za-z ]+$/, "Only alphabets and spaces allowed")
      .min(3)
      .max(40)
      .required("Player name is required"),
    jerseyNumber: Yup.number()
      .min(1)
      .max(99)
      .required("Jersey number is required"),
    position: Yup.string().required("Position is required"),
    stickHand: Yup.string().required("Stick hand is required"),
    dateOfBirth: Yup.date()
      .required("Date of birth is required")
      .test("age", "Age must be between 10 and 55", function (value) {
        const age = calculateAge(value);
        return age >= 10 && age <= 55;
      }),
    nationality: Yup.string().required("Nationality is required"),
    email: Yup.string().email("Invalid email").required("Email is required"),
    phone: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Must be a valid 10-digit Indian number")
      .required("Phone is required"),
    playerId: Yup.string()
      .matches(/^HOCK-\d{4}$/, "Format must be HOCK-XXXX")
      .required("Player ID is required"),
    guardianName: Yup.string().when("dateOfBirth", (dob, schema) => {
      if (dob && calculateAge(dob) < 18) {
        return schema.required("Guardian name is required");
      }
      return schema.notRequired();
    }),
    teamName: Yup.string().required("Team name is required"),
    leagueLevel: Yup.string().required("League level is required"),
    tournamentName: Yup.string().required("Tournament name is required"),
    startDate: Yup.date().required("Start date is required"),
    endDate: Yup.date()
      .required("End date is required")
      .min(Yup.ref("startDate"), "End date must be after start date"),
    jerseySize: Yup.string().when("position", {
      is: (pos) => pos !== "Goalie",
      then: (schema) => schema.required("Jersey size is required"),
      otherwise: (schema) => schema.notRequired(),
    }),
    padSize: Yup.string().when("position", {
      is: "Goalie",
      then: (schema) => schema.required("Pad size is required"),
      otherwise: (schema) => schema.notRequired(),
    }),
    hasMedicalCondition: Yup.boolean(),
    medicalCertNumber: Yup.string().when("hasMedicalCondition", {
      is: true,
      then: (schema) =>
        schema
          .matches(/^MED-\d{4}$/, "Format must be MED-XXXX")
          .required("Medical certificate number required"),
      otherwise: (schema) => schema.notRequired(),
    }),
    consent: Yup.boolean().oneOf([true], "Consent is required"),
    pastTeams: Yup.array()
      .of(
        Yup.object({
          clubName: Yup.string()
            .min(2)
            .max(30)
            .required("Club name is required"),
          years: Yup.number()
            .min(1)
            .max(20)
            .required("Years is required"),
        })
      )
      .max(3, "You can add up to 3 past teams only"),
  });

  // Initial Values
  const initialValues = {
    playerName: "",
    jerseyNumber: "",
    position: "",
    stickHand: "",
    dateOfBirth: "",
    nationality: "",
    email: "",
    phone: "",
    playerId: "",
    guardianName: "",
    teamName: "",
    leagueLevel: "",
    tournamentName: "",
    startDate: "",
    endDate: "",
    jerseySize: "",
    padSize: "",
    hasMedicalCondition: false,
    medicalCertNumber: "",
    consent: false,
    pastTeams: [],
  };

  // Handle Submit
  const handleSubmit = (values, { resetForm }) => {
    console.log("Form Data:", values);
    setRecords([...records, values]);
    resetForm();
  };

  return (
    <div className="container my-5">
      <div className="card shadow">
        <div className="card-header bg-primary text-white">
          <h4 className="mb-0">Hockey Tournament Registration</h4>
        </div>
        <div className="card-body">
          <Formik
            initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={handleSubmit}
          >
            {({ values, isValid }) => (
              <Form>
                {/* Player Details */}
                <h5 className="mt-3">Player Details</h5>
                <div className="row">
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Player Name</label>
                    <Field name="playerName" className="form-control" />
                    <ErrorMessage name="playerName" className="text-danger" component="div" />
                  </div>
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Jersey Number</label>
                    <Field name="jerseyNumber" type="number" className="form-control" />
                    <ErrorMessage name="jerseyNumber" className="text-danger" component="div" />
                  </div>
                </div>

                <div className="row">
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Position</label>
                    <Field as="select" name="position" className="form-select">
                      <option value="">Select...</option>
                      <option value="Forward">Forward</option>
                      <option value="Defense">Defense</option>
                      <option value="Goalie">Goalie</option>
                    </Field>
                    <ErrorMessage name="position" className="text-danger" component="div" />
                  </div>
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Stick Hand</label>
                    <Field as="select" name="stickHand" className="form-select">
                      <option value="">Select...</option>
                      <option value="Left">Left</option>
                      <option value="Right">Right</option>
                    </Field>
                    <ErrorMessage name="stickHand" className="text-danger" component="div" />
                  </div>
                </div>

                <div className="row">
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Date of Birth</label>
                    <Field type="date" name="dateOfBirth" className="form-control" />
                    <ErrorMessage name="dateOfBirth" className="text-danger" component="div" />
                  </div>
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Nationality</label>
                    <Field name="nationality" className="form-control" />
                    <ErrorMessage name="nationality" className="text-danger" component="div" />
                  </div>
                </div>

                <div className="row">
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Email</label>
                    <Field type="email" name="email" className="form-control" />
                    <ErrorMessage name="email" className="text-danger" component="div" />
                  </div>
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Phone</label>
                    <Field name="phone" className="form-control" />
                    <ErrorMessage name="phone" className="text-danger" component="div" />
                  </div>
                </div>

                <div className="row">
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Player ID</label>
                    <Field name="playerId" className="form-control" />
                    <ErrorMessage name="playerId" className="text-danger" component="div" />
                  </div>
                  {values.dateOfBirth && calculateAge(values.dateOfBirth) < 18 && (
                    <div className="col-md-6 mb-3">
                      <label className="form-label">Guardian Name</label>
                      <Field name="guardianName" className="form-control" />
                      <ErrorMessage name="guardianName" className="text-danger" component="div" />
                    </div>
                  )}
                </div>

                {/* Team & Event */}
                <h5 className="mt-4">Team & Event Information</h5>
                <div className="row">
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Team Name</label>
                    <Field name="teamName" className="form-control" />
                    <ErrorMessage name="teamName" className="text-danger" component="div" />
                  </div>
                  <div className="col-md-6 mb-3">
                    <label className="form-label">League Level</label>
                    <Field as="select" name="leagueLevel" className="form-select">
                      <option value="">Select...</option>
                      <option value="Amateur">Amateur</option>
                      <option value="College">College</option>
                      <option value="Pro">Pro</option>
                    </Field>
                    <ErrorMessage name="leagueLevel" className="text-danger" component="div" />
                  </div>
                </div>

                <div className="row">
                  <div className="col-md-6 mb-3">
                    <label className="form-label">Tournament Name</label>
                    <Field name="tournamentName" className="form-control" />
                    <ErrorMessage name="tournamentName" className="text-danger" component="div" />
                  </div>
                  <div className="col-md-3 mb-3">
                    <label className="form-label">Start Date</label>
                    <Field type="date" name="startDate" className="form-control" />
                    <ErrorMessage name="startDate" className="text-danger" component="div" />
                  </div>
                  <div className="col-md-3 mb-3">
                    <label className="form-label">End Date</label>
                    <Field type="date" name="endDate" className="form-control" />
                    <ErrorMessage name="endDate" className="text-danger" component="div" />
                  </div>
                </div>

                {values.position !== "Goalie" && (
                  <div className="mb-3">
                    <label className="form-label">Jersey Size</label>
                    <Field name="jerseySize" className="form-control" />
                    <ErrorMessage name="jerseySize" className="text-danger" component="div" />
                  </div>
                )}
                {values.position === "Goalie" && (
                  <div className="mb-3">
                    <label className="form-label">Pad Size</label>
                    <Field name="padSize" className="form-control" />
                    <ErrorMessage name="padSize" className="text-danger" component="div" />
                  </div>
                )}

                {/* Medical & Consent */}
                <h5 className="mt-4">Medical & Consent</h5>
                <div className="form-check mb-3">
                  <Field type="checkbox" name="hasMedicalCondition" className="form-check-input" id="medCond" />
                  <label className="form-check-label" htmlFor="medCond">Has Medical Condition?</label>
                </div>
                {values.hasMedicalCondition && (
                  <div className="mb-3">
                    <label className="form-label">Medical Certificate Number</label>
                    <Field name="medicalCertNumber" className="form-control" />
                    <ErrorMessage name="medicalCertNumber" className="text-danger" component="div" />
                  </div>
                )}

                <div className="form-check mb-3">
                  <Field type="checkbox" name="consent" className="form-check-input" id="consent" />
                  <label className="form-check-label" htmlFor="consent">I agree to participate</label>
                  <ErrorMessage name="consent" component="div" className="text-danger" />
                </div>

                {/* Past Teams */}
                <h5 className="mt-4">Past Teams</h5>
                <FieldArray name="pastTeams">
                  {({ push, remove }) => (
                    <div>
                      {values.pastTeams.map((team, index) => (
                        <div key={index} className="row align-items-end mb-2">
                          <div className="col-md-5">
                            <Field
                              name={`pastTeams[${index}].clubName`}
                              placeholder="Club Name"
                              className="form-control"
                            />
                            <ErrorMessage
                              name={`pastTeams[${index}].clubName`}
                              className="text-danger"
                              component="div"
                            />
                          </div>
                          <div className="col-md-3">
                            <Field
                              name={`pastTeams[${index}].years`}
                              placeholder="Years"
                              type="number"
                              className="form-control"
                            />
                            <ErrorMessage
                              name={`pastTeams[${index}].years`}
                              className="text-danger"
                              component="div"
                            />
                          </div>
                          <div className="col-md-2">
                            <button
                              type="button"
                              className="btn btn-danger"
                              onClick={() => remove(index)}
                            >
                              Remove
                            </button>
                          </div>
                        </div>
                      ))}
                      {values.pastTeams.length < 3 && (
                        <button
                          type="button"
                          className="btn btn-secondary"
                          onClick={() => push({ clubName: "", years: "" })}
                        >
                          + Add Past Team
                        </button>
                      )}
                    </div>
                  )}
                </FieldArray>

                {/* Submit */}
                <div className="mt-4">
                  <button type="submit" className="btn btn-success" disabled={!isValid}>
                    Submit
                  </button>
                </div>
              </Form>
            )}
          </Formik>
        </div>
      </div>

      {/* Records Table */}
      {records.length > 0 && (
        <div className="card mt-4 shadow">
          <div className="card-header bg-dark text-white">
            <h5 className="mb-0">Registered Players</h5>
          </div>
          <div className="card-body p-0">
            <table className="table table-striped mb-0">
              <thead className="table-dark">
                <tr>
                  <th>Name</th>
                  <th>Jersey</th>
                  <th>Position</th>
                  <th>Stick</th>
                  <th>DOB</th>
                  <th>Email</th>
                  <th>Phone</th>
                  <th>Team</th>
                  <th>League</th>
                  <th>Tournament</th>
                </tr>
              </thead>
              <tbody>
                {records.map((rec, idx) => (
                  <tr key={idx}>
                    <td>{rec.playerName}</td>
                    <td>{rec.jerseyNumber}</td>
                    <td>{rec.position}</td>
                    <td>{rec.stickHand}</td>
                    <td>{rec.dateOfBirth}</td>
                    <td>{rec.email}</td>
                    <td>{rec.phone}</td>
                    <td>{rec.teamName}</td>
                    <td>{rec.leagueLevel}</td>
                    <td>{rec.tournamentName}</td>
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

export default HockeyTournamentForm;
