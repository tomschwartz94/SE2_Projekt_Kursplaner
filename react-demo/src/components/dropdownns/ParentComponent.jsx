// import React, { useState } from "react";

// import NestedSelect from "./Nestedselect";
// import SelectedValuesList from "./SelectedValueList";

// const ParentComponent = () => {
//   const [selectedValues, setSelectedValues] = useState([]);

//   const handleSelectedValuesChange = (values) => {
//     setSelectedValues(values);
//   };

//   return (
//     <div>
//       <NestedSelect onSelectedValuesChange={handleSelectedValuesChange} />
//       <SelectedValuesList selectedValues={selectedValues} />
//     </div>
//   );
// };

// export default ParentComponent;

import React, { useState } from "react";

const DropdownForm = () => {
  const [selectedValue, setSelectedValue] = useState("");
  const [valueArray, setValueArray] = useState([]);

  const handleSelect = (event) => {
    const value = event.target.value;
    setSelectedValue(value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    setValueArray([...valueArray, selectedValue]);
    setSelectedValue("");
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <select value={selectedValue} onChange={handleSelect}>
          <option value="">Select an option</option>
          <option value="Option 1">Option 1</option>
          <option value="Option 2">Option 2</option>
          <option value="Option 3">Option 3</option>
        </select>
        <button type="submit">Add to Array</button>
      </form>

      <h2>Selected Values:</h2>
      <ul>
        {valueArray.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
    </div>
  );
};

export default DropdownForm;

//import React, { useState } from "react";
// import ComponentA from "./ComponentA";
// import ComponentB from "./ComponentB";

// function ParentComponent() {
//   const [selectedValues, setSelectedValues] = useState([]);

//   const handleSelect = (selectedValue) => {
//     setSelectedValues([...selectedValues, selectedValue]);
//   };

//   return (
//     <div>
//       <ComponentA handleSelect={handleSelect} />
//       <ComponentB selectedValues={selectedValues} />
//     </div>
//   );
// }

// function ComponentA({ handleSelect }) {
//   const handleChange = (event) => {
//     const selectedValue = event.target.value;
//     handleSelect(selectedValue);
//   };

//   return (
//     <div>
//       <select onChange={handleChange}>
//         <option value="Option 1">Option 1</option>
//         <option value="Option 2">Option 2</option>
//         <option value="Option 3">Option 3</option>
//       </select>
//     </div>
//   );
// }

// function ComponentB({ selectedValues }) {
//   return (
//     <div>
//       {selectedValues.map((value, index) => (
//         <p key={index}>{value}</p>
//       ))}
//     </div>
//   );
// }

// export default ParentComponent;
