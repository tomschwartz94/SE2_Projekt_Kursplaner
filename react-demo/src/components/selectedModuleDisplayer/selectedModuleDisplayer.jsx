import React, { useState } from "react";

const SelectedModuleDisplayer = ({ option }) => {
  const [isComponentVisible, setComponentVisible] = useState(true);

  const handleClick = () => {
    setComponentVisible(false);
  };

  if (!isComponentVisible) {
    return null; // Return null to remove the component from the DOM
  }
  return (
    <div className="combined-dropdown">
      <div id="mdiv" onClick={handleClick}>
        <div class="mdiv">
          <div class="md"></div>
        </div>
      </div>
      <div>{option}</div>
    </div>
  );
};

export default SelectedModuleDisplayer;
