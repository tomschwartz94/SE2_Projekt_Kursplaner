// // import React, { useContext } from "react";
// // import SelectedValuesContext from "./SelectedValuesContext";

// // function ComponentB() {
// //   const { selectedValues } = useContext(SelectedValuesContext);

// //   return (
// //     <div>
// //       {selectedValues.map((value, index) => (
// //         <p key={index}>{value}</p>
// //       ))}
// //     </div>
// //   );
// // }

// // export default ComponentB;

// import React, { useContext, useState } from "react";
// import SelectedValuesContext from "./SelectedValuesContext";
// import { Dropdown, Button } from "react-bootstrap";

// function Modules() {
//   const { selectedValues } = useContext(SelectedValuesContext);
//   const [isOpen, setIsOpen] = useState(false);

//   const handleToggle = () => {
//     setIsOpen(!isOpen);
//   };

//   return (
//     <Dropdown show={isOpen} onToggle={handleToggle}>
//       <Dropdown.Toggle as={Button} variant="primary">
//         Available Modules
//       </Dropdown.Toggle>
//       <Dropdown.Menu>
//         {selectedValues.map((value, index) => (
//           <Dropdown.Item key={index}>{value}</Dropdown.Item>
//         ))}
//       </Dropdown.Menu>
//     </Dropdown>
//   );
// }

// export default Modules;

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

// import React, { useContext, useState } from "react";
// import SelectedValuesContext from "./SelectedValuesContext";
// import { Dropdown, Button, Card } from "react-bootstrap";
// import Mycontext from "./MyContext";

// function Modules() {
//   const { selectedValues } = useContext(SelectedValuesContext);
//   const [isOpen, setIsOpen] = useState(false);
//   const [selectedOption, setSelectedOption] = useState("");

//   const { selectedValue, setSelectedValue } = useContext(Mycontext);

//   const handleToggle = () => {
//     setIsOpen(!isOpen);
//   };

//   const handleOptionSelect = (option) => {
//     setSelectedOption(option);
//     setSelectedValue(op);
//   };

//   return (
//     <div>
//       <Dropdown show={isOpen} onToggle={handleToggle}>
//         <Dropdown.Toggle as={Button} variant="primary">
//           Available Modules
//         </Dropdown.Toggle>
//         <Dropdown.Menu>
//           {selectedValues.map((value, index) => (
//             <Dropdown.Item
//               key={index}
//               onClick={() => handleOptionSelect(value)}
//             >
//               {value}
//             </Dropdown.Item>
//           ))}
//         </Dropdown.Menu>
//       </Dropdown>

//       {selectedOption && (
//         <Card className="mt-4">
//           <Card.Body>
//             <Card.Title>Selected Option:</Card.Title>
//             <Card.Text>{selectedValue}</Card.Text>
//           </Card.Body>
//         </Card>
//       )}
//     </div>
//   );
// }

// export default Modules;
