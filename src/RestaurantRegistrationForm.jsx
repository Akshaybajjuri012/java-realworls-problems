import React, { useState, useEffect } from 'react';
const RestaurantRegistrationForm = () => {
  const [formData, setFormData] = useState({
    restaurantName: '',
    ownerName: '',
    email: '',
    contact: '',
    address: '',
    cuisineType: '',
    openingHours: ''
  });

  const [jsonOutput, setJsonOutput] = useState('');

  // 🔁 Every render
  useEffect(() => {
    console.log('Rendered or re-rendered');
  });

  // 🟢 On mount
  useEffect(() => {
    console.log('Component mounted');
  }, []);

  // 🔄 On form data change
  useEffect(() => {
    setJsonOutput(JSON.stringify(formData, null, 2));
  }, [formData]);

  // 💾 Auto-save every 5 seconds
  useEffect(() => {
    const intervalId = setInterval(() => {
      console.log('Auto-saving form data:', formData);
    }, 5000);
    return () => clearInterval(intervalId);
  }, [formData]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Form submitted:', formData);
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">🍽️ Restaurant Registration Form</h2>
      <form onSubmit={handleSubmit} className="row g-3">
        {[
          { label: 'Restaurant Name', name: 'restaurantName' },
          { label: 'Owner Name', name: 'ownerName' },
          { label: 'Email', name: 'email', type: 'email' },
          { label: 'Contact Number', name: 'contact' },
          { label: 'Address', name: 'address' },
          { label: 'Cuisine Type', name: 'cuisineType' },
          { label: 'Opening Hours', name: 'openingHours' }
        ].map(({ label, name, type = 'text' }) => (
          <div className="col-md-6" key={name}>
            <label className="form-label">{label}</label>
            <input
              type={type}
              name={name}
              value={formData[name]}
              onChange={handleChange}
              className="form-control"
              placeholder={`Enter ${label}`}
            />
          </div>
        ))}

        <div className="col-12">
          <button type="submit" className="btn btn-primary">Submit</button>
        </div>
      </form>

      <div className="mt-5">
        <h4>📦 Submitted Data (JSON Format)</h4>
        <pre className="bg-light p-3 border rounded">{jsonOutput}</pre>
      </div>
    </div>
  );
};

export default RestaurantRegistrationForm;