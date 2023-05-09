import React, { useState } from "react";
import { Dropdown } from "react-bootstrap";

function GeneralDropdown() {
  const [selectedValue, setSelectedValue] = useState("");

  const handleSelect = (value) => {
    setSelectedValue(value);
  };

  return (
    <Dropdown onSelect={handleSelect}>
      <Dropdown.Toggle>Bachelor Degree Course</Dropdown.Toggle>
      <Dropdown.Menu>
        <Dropdown.Item eventKey="Lecture">Lecture</Dropdown.Item>
        <Dropdown.Item eventKey="Praktikum">Praktikum</Dropdown.Item>
        <Dropdown.Item eventKey="Project">Projects</Dropdown.Item>
      </Dropdown.Menu>

      <p>{selectedValue}</p>
    </Dropdown>
  );
}

export default GeneralDropdown;

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
