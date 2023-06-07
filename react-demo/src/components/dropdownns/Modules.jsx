import React, { useContext, useState } from "react";
import SelectedValuesContext from "./contexts/SelectedValuesContext";
import { Dropdown, Button } from "react-bootstrap";
import SelectedModuleDisplayer from "../selectedModuleDisplayer/selectedModuleDisplayer";
import SelectedOptionscontext, {
  SelectedOptionsProvider,
} from "./contexts/displayfieldContext";
import "../dropdownns/css/displayfield.css";

function Modules() {
  const { selectedValues } = useContext(SelectedValuesContext);
  // const [selectedOptions, setSelectedOptions] = useState([]);
  const { selectedOptions, setSelectedOptions } = useContext(
    SelectedOptionscontext
  );
  const [isOpen, setIsOpen] = useState(false);

  const handleToggle = () => {
    setIsOpen(!isOpen);
  };

  const handleOptionSelect = (option) => {
    setSelectedOptions([...selectedOptions, option]);
    //setSelectedOption(option);
    //setSelectedOption(option);
  };

  return (
    <div>
      <Dropdown show={isOpen} onToggle={handleToggle}>
        <Dropdown.Toggle
          as={Button}
          variant="primary"
          className="togglebutton"
          style={{ borderRadius: "0" }}
        >
          Available Modules
        </Dropdown.Toggle>
        <Dropdown.Menu className="dropdown-menu">
          {selectedValues.map((value, index) => (
            <Dropdown.Item
              className="togglebutton"
              key={index}
              onClick={() => handleOptionSelect(value)}
            >
              {value}
            </Dropdown.Item>
          ))}
        </Dropdown.Menu>
      </Dropdown>

      {/* {selectedOptions.length > 0 && (
        <div>
          <h4>Selected Modules:</h4>
          <ul>
            {selectedOptions.map((option, index) => (
              <SelectedModuleDisplayer key={index} />
            ))}
          </ul>
        </div>
      )} */}
    </div>
  );
}

export default Modules;