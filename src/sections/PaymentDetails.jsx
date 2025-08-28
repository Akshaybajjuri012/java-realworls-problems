// src/sections/PaymentDetails.jsx
import React from "react";
import { Field, ErrorMessage, useFormikContext } from "formik";

export default function PaymentDetails() {
  const { values, setFieldValue } = useFormikContext();

  return (
    <div>
      <h5>Payment Details</h5>
      <div className="row g-3 mt-2">
        <div className="col-md-6">
          <label className="form-label">Payment Method</label>
          <Field as="select" name="paymentMethod" className="form-select">
            <option value="Credit Card">Credit Card</option>
            <option value="PayPal">PayPal</option>
            <option value="Invoice">Invoice</option>
          </Field>
          <div className="text-danger small"><ErrorMessage name="paymentMethod" /></div>
        </div>

        <div className="col-md-6">
          <label className="form-label">Promo Code</label>
          <Field name="promoCode" className="form-control" />
          <div className="text-danger small"><ErrorMessage name="promoCode" /></div>
        </div>

        <div className="col-12">
          <div className="form-check">
            <Field
              type="checkbox"
              name="invoiceRequired"
              className="form-check-input"
              id="invoiceRequired"
              onChange={(e) => {
                setFieldValue("invoiceRequired", e.target.checked);
                if (!e.target.checked) setFieldValue("invoiceAddress", "");
              }}
            />
            <label className="form-check-label" htmlFor="invoiceRequired">
              Require Invoice
            </label>
          </div>
        </div>

        {values.invoiceRequired && (
          <div className="col-12 mt-2">
            <label className="form-label">Invoice Address</label>
            <Field as="textarea" name="invoiceAddress" rows="3" className="form-control" />
            <div className="text-danger small"><ErrorMessage name="invoiceAddress" /></div>
          </div>
        )}
      </div>
    </div>
  );
}
