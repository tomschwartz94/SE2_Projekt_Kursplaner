// import React, { useState } from "react";
// import { Dropdown } from "react-bootstrap";

// import "../dropdownns/css/nestedselect.css";

// const data = {
//   option1: {
//     subOption1: "Value 1-1",
//     subOption2: "Value 1-2",
//   },
//   option2: {
//     subOption1: "Value 2-1",
//     subOption2: "Value 2-2",
//   },
// };

// const NestedSelect = () => {
//   const [selectedOption, setSelectedOption] = useState("");
//   const [selectedSubOption, setSelectedSubOption] = useState("");
//   const [displayedValue, setDisplayedValue] = useState("");

//   const handleOptionChange = (option) => {
//     setSelectedOption(option);
//     setSelectedSubOption("");
//     setDisplayedValue("");
//   };

//   const handleSubOptionChange = (subOption) => {
//     setSelectedSubOption(subOption);
//     setDisplayedValue(data[selectedOption][subOption]);
//   };

//   return (
//     <div className="nested-select-container">
//       <h1>Nested Select</h1>
//       <div className="nested-select">
//         <Dropdown>
//           <Dropdown.Toggle variant="primary">Select Option</Dropdown.Toggle>
//           <Dropdown.Menu>
//             {Object.keys(data).map((option) => (
//               <Dropdown.Item
//                 key={option}
//                 onClick={() => handleOptionChange(option)}
//               >
//                 {option}
//               </Dropdown.Item>
//             ))}
//           </Dropdown.Menu>
//         </Dropdown>

//         {selectedOption && (
//           <Dropdown>
//             <Dropdown.Toggle variant="primary">
//               Select Sub-Option
//             </Dropdown.Toggle>
//             <Dropdown.Menu>
//               {Object.keys(data[selectedOption]).map((subOption) => (
//                 <Dropdown.Item
//                   key={subOption}
//                   onClick={() => handleSubOptionChange(subOption)}
//                 >
//                   {subOption}
//                 </Dropdown.Item>
//               ))}
//             </Dropdown.Menu>
//           </Dropdown>
//         )}
//       </div>

//       {displayedValue && (
//         <div className="displayed-value">
//           <h2>Selected Value:</h2>
//           <p>{displayedValue}</p>
//         </div>
//       )}
//     </div>
//   );
// };

// export default NestedSelect;

import React, { useState } from "react";
import { useContext } from "react";
import SelectedValuesContext from "./contexts/SelectedValuesContext";
import { Dropdown } from "react-bootstrap";
import "../dropdownns/css/nestedselect.css";
import "../dropdownns/css/button.css";

const data = {
  Vorlesung: {
    semester1: ["DM", "PM1"],
    semester2: ["AF", "PMP 2"],
  },
};

const NestedSelect = ({ onSelectedValuesChange }) => {
  const [selectedOption, setSelectedOption] = useState("");
  const [selectedSubOption, setSelectedSubOption] = useState("");
  const [displayedValue, setDisplayedValue] = useState("");
  const { selectedValues, setSelectedValues } = useContext(
    SelectedValuesContext
  );

  const handleOptionChange = (option) => {
    setSelectedOption(option);
    setSelectedSubOption("");
    setDisplayedValue("");
  };

  const handleSubOptionChange = (subOption) => {
    setSelectedSubOption(subOption);
    const values = data[selectedOption][subOption];
    setDisplayedValue(values);
    setSelectedValues([...selectedValues, ...values]);
  };

  return (
    <div className="nested-select-container">
      <div className="nested-select">
        <Dropdown>
          <Dropdown.Toggle
            variant="primary"
            className="togglebutton"
            style={{ borderRadius: "0" }}
          >
            Studiengang
          </Dropdown.Toggle>
          <Dropdown.Menu>
            {Object.keys(data).map((option) => (
              <Dropdown.Item
                className="togglebutton"
                key={option}
                onClick={() => handleOptionChange(option)}
              >
                {option}
              </Dropdown.Item>
            ))}
          </Dropdown.Menu>
        </Dropdown>

        {selectedOption && (
          <Dropdown>
            <Dropdown.Toggle
              className="togglebutton"
              style={{ borderRadius: "0" }}
            >
              Semester
            </Dropdown.Toggle>
            <Dropdown.Menu>
              {Object.keys(data[selectedOption]).map((subOption) => (
                <Dropdown.Item
                  key={subOption}
                  className="togglebutton"
                  onClick={() => handleSubOptionChange(subOption)}
                >
                  {subOption}
                </Dropdown.Item>
              ))}
            </Dropdown.Menu>
          </Dropdown>
        )}
      </div>
    </div>
  );
};

export default NestedSelect;
