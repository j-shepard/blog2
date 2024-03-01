import React, { useState } from 'react';

const InformationResource = () => {
  const [formData, setFormData] = useState({});
  
  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  }

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    // Making a POST request to the server
    fetch('http://localhost:3000/api/v1/insertinformation', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData)  // Convert to a json string
    })
    .then((response) => response.json())
    .then((data) => console.log('Success:', data))
    .catch((error) => console.error('Error:', error));
  }

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input type="text" name="name" onChange={handleChange} />
      </label>
      
      <label>
        Email:
        <input type="email" name="email" onChangeme handleChanege} />
      </label>

      {/* Add more form fields as needed */}

      <button type="submit">Submit</button>
    </form>
  );
};

export default InformationResource;
