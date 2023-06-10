import React, { useState } from "react";
import "./SelectionDisplayItem.css";


const SelectedModuleDisplayer = ({ option }) => {
  const [isComponentVisible, setComponentVisible] = useState(true);

  const handleClick = (option) => {
    setComponentVisible(false);
    var module = Array.from(window.$moduleAuswahlList);
    module = module.filter((ele) => ele.id !== option);
    window.$moduleAuswahlList = module;
  };

  if (!isComponentVisible) {
    return null; // Return null to remove the component from the DOM
  }
  return (
    <div className="combined-dropdown">
      <div className="togglebutton" id="mdiv" onClick={() => handleClick(option.id)}>
        <div class="mdiv">
          <div class="md"></div>
        </div>
      </div>
      <div>{option.name}</div>
    </div>
  );
};

export default SelectedModuleDisplayer;
