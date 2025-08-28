import React from "react";
import * as Yup from "yup";
import withFormLayout from "../withFormLayout";
import PersonalDetails from "./PersonalDetails";
import TicketSelection from "./TicketSelection";
import SessionPreferences from "./SessionPreferences";
import PaymentDetails from "./PaymentDetails";

const initialValues = {
  name: "", email: "", phone: "", organization: "",
  ticketType: "Regular", quantity: 1,
  sessions: { workshopA: false, panelB: false, keynote: false },
  paymentMethod: "Credit Card", promoCode: "", invoiceAddress: "", invoiceRequired: false
};

const schema = Yup.object().shape({
  name: Yup.string().required("Name is required"),
  email: Yup.string().email("Enter a valid email").required("Email is required"),
  phone: Yup.string().required("Phone is required").matches(/^[0-9 ()+-]{7,20}$/, "Enter a valid phone number"),
  organization: Yup.string().nullable(),
  ticketType: Yup.string().oneOf(["Regular","VIP","Student"]).required("Ticket type is required"),
  quantity: Yup.number().required().min(1).max(10),
  sessions: Yup.object().shape({
    workshopA: Yup.boolean(),
    panelB: Yup.boolean(),
    keynote: Yup.boolean()
  }).test("at-least-one","Select at least one session", val => Object.values(val||{}).some(Boolean)),
  paymentMethod: Yup.string().oneOf(["Credit Card","PayPal","Invoice"]).required(),
  promoCode: Yup.string().nullable(),
  invoiceRequired: Yup.boolean(),
  invoiceAddress: Yup.string().when("invoiceRequired", (invoiceRequired, schema) => 
  invoiceRequired ? schema.required("Invoice address required") : schema
)
});

function RegistrationForm() {
  return (
    <>
      <PersonalDetails />
      <hr />
      <TicketSelection />
      <hr />
      <SessionPreferences />
      <hr />
      <PaymentDetails />
    </>
  );
}

export default withFormLayout(RegistrationForm, {
  initialValues,
  validationSchema: schema,
  title: "Online Event Registration",
  submitText: "Register"
});
