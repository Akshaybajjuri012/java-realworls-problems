// src/sections/TicketSelection.jsx
import React from "react";
import { Field, ErrorMessage, useFormikContext } from "formik";

export default function TicketSelection() {
  const { values, setFieldValue } = useFormikContext();

  return (
    <div>
      <h5>Ticket Selection</h5>
      <div className="row g-3 mt-2">
        <div className="col-md-6">
          <label className="form-label">Ticket Type</label>
          <Field as="select" name="ticketType" className="form-select">
            <option value="Regular">Regular</option>
            <option value="VIP">VIP</option>
            <option value="Student">Student</option>
          </Field>
          <div className="text-danger small"><ErrorMessage name="ticketType" /></div>
        </div>

        <div className="col-md-3">
          <label className="form-label">Quantity</label>
          <div className="input-group">
            <button
              type="button"
              className="btn btn-outline-secondary"
              onClick={() => setFieldValue("quantity", Math.max(1, values.quantity - 1))}
            >-</button>
            <Field type="number" name="quantity" className="form-control text-center" min="1" />
            <button
              type="button"
              className="btn btn-outline-secondary"
              onClick={() => setFieldValue("quantity", Math.min(10, values.quantity + 1))}
            >+</button>
          </div>
          <div className="text-danger small"><ErrorMessage name="quantity" /></div>
        </div>
      </div>
    </div>
  );
}
