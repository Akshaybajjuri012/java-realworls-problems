// src/withFormLayout.js
import React, { useState } from "react";
import { Formik, Form, ErrorMessage, useFormikContext } from "formik";
import { Alert, Button } from "react-bootstrap";

export default function withFormLayout(WrappedComponent, options = {}) {
  const { initialValues, validationSchema, title = "Registration", submitText = "Register" } = options;

  return function WrappedWithLayout() {
    const [submittedValues, setSubmittedValues] = useState(null);

    const handleSubmit = async (values, formikHelpers) => {
      setSubmittedValues(values); // store values for confirmation
      formikHelpers.setSubmitting(false);
    };

    if (submittedValues) {
      // Display confirmation page
      const sessions = [];
      if (submittedValues.sessions?.workshopA) sessions.push("Workshop A");
      if (submittedValues.sessions?.panelB) sessions.push("Panel B");
      if (submittedValues.sessions?.keynote) sessions.push("Keynote");

      return (
        <div className="container my-5">
          <div className="card shadow-sm">
            <div className="card-header bg-white">
              <h2 className="mb-0">Registration Confirmation</h2>
            </div>
            <div className="card-body">
              <p className="text-success">Your registration was successful. Here are the details:</p>

              <h5>Personal Details</h5>
              <dl className="row">
                <dt className="col-sm-3">Name</dt>
                <dd className="col-sm-9">{submittedValues.name}</dd>

                <dt className="col-sm-3">Email</dt>
                <dd className="col-sm-9">{submittedValues.email}</dd>

                <dt className="col-sm-3">Phone</dt>
                <dd className="col-sm-9">{submittedValues.phone}</dd>

                <dt className="col-sm-3">Organization</dt>
                <dd className="col-sm-9">{submittedValues.organization || "-"}</dd>
              </dl>

              <h5>Ticket</h5>
              <dl className="row">
                <dt className="col-sm-3">Type</dt>
                <dd className="col-sm-9">{submittedValues.ticketType}</dd>

                <dt className="col-sm-3">Quantity</dt>
                <dd className="col-sm-9">{submittedValues.quantity}</dd>
              </dl>

              <h5>Sessions</h5>
              <p>{sessions.length ? sessions.join(", ") : "No sessions selected"}</p>

              <h5>Payment</h5>
              <dl className="row">
                <dt className="col-sm-3">Method</dt>
                <dd className="col-sm-9">{submittedValues.paymentMethod}</dd>

                <dt className="col-sm-3">Promo</dt>
                <dd className="col-sm-9">{submittedValues.promoCode || "-"}</dd>

                <dt className="col-sm-3">Invoice Address</dt>
                <dd className="col-sm-9">{submittedValues.invoiceRequired ? submittedValues.invoiceAddress : "Not requested"}</dd>
              </dl>

              <Button variant="primary" onClick={() => setSubmittedValues(null)}>
                Register Another
              </Button>
            </div>
          </div>
        </div>
      );
    }

    return (
      <div className="container my-5">
        <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={handleSubmit}>
          {(formik) => {
            const errorCount = Object.keys(formik.errors).length;
            return (
              <Form noValidate>
                <div className="card shadow-sm">
                  <div className="card-header bg-white">
                    <h2 className="mb-0">{title}</h2>
                  </div>
                  <div className="card-body">
                    {errorCount > 0 && formik.submitCount > 0 && (
                      <Alert variant="danger">
                        <strong>{errorCount} validation error{errorCount > 1 ? "s" : ""} — please fix:</strong>
                        <ul className="mb-0 mt-2">
                          {Object.entries(formik.errors).map(([key, val]) => (
                            <li key={key}>{String(val)}</li>
                          ))}
                        </ul>
                      </Alert>
                    )}

                    <WrappedComponent />
                  </div>
                  <div className="card-footer text-end">
                    <Button type="submit" variant="primary" disabled={formik.isSubmitting}>
                      {submitText}
                    </Button>
                  </div>
                </div>
              </Form>
            );
          }}
        </Formik>
      </div>
    );
  };
}
