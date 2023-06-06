import React from "react";

const SelectedValuesList = ({ selectedValues }) => {
  return (
    <div>
      <h2>Selected Values List:</h2>
      <ul>
        {selectedValues.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
    </div>
  );
};

export default SelectedValuesList;
