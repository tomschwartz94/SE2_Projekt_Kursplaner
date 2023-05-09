import React, { useState } from "react";
import { Dropdown } from "react-bootstrap";

function Module() {
  const [selectedValue, setSelectedValue] = useState("");

  const handleSelect = (value) => {
    setSelectedValue(value);
  };

  return (
    <Dropdown onSelect={handleSelect}>
      <Dropdown.Toggle>Modules available</Dropdown.Toggle>
      <Dropdown.Menu>
        <Dropdown.Item eventKey="SE1">SE1</Dropdown.Item>
        <Dropdown.Item eventKey="SE2">SE2</Dropdown.Item>
        <Dropdown.Item eventKey="SE_Whatever">SE_Whatever</Dropdown.Item>
      </Dropdown.Menu>

      <p>{selectedValue}</p>
    </Dropdown>
  );
}

export default Module;

// import Dropdown from "react-bootstrap/Dropdown";

// function BasicExample() {
//   return (
//     <Dropdown>
//       <Dropdown.Toggle variant="success" id="dropdown-basic">
//         Dropdown Button
//       </Dropdown.Toggle>

//       <Dropdown.Menu>
//         <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
//         <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
//         <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
//       </Dropdown.Menu>
//     </Dropdown>
//   );
// }

// export default BasicExample;
