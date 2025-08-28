import React from "react";
import { Field, ErrorMessage } from "formik";

export default function PersonalDetails() {
  return (
    <div>
      <h5>Personal Details</h5>
      <div className="row g-3 mt-2">
        <div className="col-md-6">
          <label className="form-label">Name</label>
          <Field name="name" className="form-control" />
          <div className="text-danger small"><ErrorMessage name="name" /></div>
        </div>

        <div className="col-md-6">
          <label className="form-label">Email</label>
          <Field name="email" type="email" className="form-control" />
          <div className="text-danger small"><ErrorMessage name="email" /></div>
        </div>

        <div className="col-md-6">
          <label className="form-label">Phone</label>
          <Field name="phone" className="form-control" />
          <div className="text-danger small"><ErrorMessage name="phone" /></div>
        </div>

        <div className="col-md-6">
          <label className="form-label">Organization</label>
          <Field name="organization" className="form-control" />
          <div className="text-danger small"><ErrorMessage name="organization" /></div>
        </div>
      </div>
    </div>
  );
}
