import React, { useContext, useState } from "react";
import SelectedValuesContext from "./contexts/SelectedValuesContext";
import { Dropdown, Button } from "react-bootstrap";

function ComponentB() {
  const { selectedValues } = useContext(SelectedValuesContext);
  const [isOpen, setIsOpen] = useState(false);

  const handleToggle = () => {
    setIsOpen(!isOpen);
  };

  return (
    <Dropdown show={isOpen} onToggle={handleToggle}>
      <Dropdown.Toggle as={Button} variant="primary">
        Toggle Dropdown
      </Dropdown.Toggle>
      <Dropdown.Menu>
        {selectedValues.map((value, index) => (
          <Dropdown.Item key={index}>{value}</Dropdown.Item>
        ))}
      </Dropdown.Menu>
    </Dropdown>
  );
}

export default ComponentB;
