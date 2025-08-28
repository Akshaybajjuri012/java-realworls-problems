// src/sections/SessionPreferences.jsx
import React from "react";
import { Field, ErrorMessage } from "formik";

export default function SessionPreferences() {
  return (
    <div>
      <h5>Session Preferences</h5>
      <div className="form-check mt-2">
        <Field type="checkbox" name="sessions.workshopA" className="form-check-input" id="workshopA" />
        <label className="form-check-label" htmlFor="workshopA">Workshop A</label>
      </div>

      <div className="form-check">
        <Field type="checkbox" name="sessions.panelB" className="form-check-input" id="panelB" />
        <label className="form-check-label" htmlFor="panelB">Panel B</label>
      </div>

      <div className="form-check">
        <Field type="checkbox" name="sessions.keynote" className="form-check-input" id="keynote" />
        <label className="form-check-label" htmlFor="keynote">Keynote</label>
      </div>

      <div className="text-danger small"><ErrorMessage name="sessions" /></div>
    </div>
  );
}
