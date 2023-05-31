import React, { useState } from "react";
import { Dropdown } from "react-bootstrap";

function Semester() {
  const [selectedValue, setSelectedValue] = useState("");

  const handleSelect = (value) => {
    setSelectedValue(value);
  };

  return (
    <Dropdown onSelect={handleSelect}>
      <Dropdown.Toggle>Semester</Dropdown.Toggle>
      <Dropdown.Menu>
        <Dropdown.Item eventKey="1">1</Dropdown.Item>
        <Dropdown.Item eventKey="2">2</Dropdown.Item>
        <Dropdown.Item eventKey="3">3</Dropdown.Item>
      </Dropdown.Menu>

      <p>{selectedValue}</p>
    </Dropdown>
  );
}

export default Semester;

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
