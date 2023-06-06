import React, { useContext } from "react";
import SelectedValuesContext from "../dropdownns/contexts/SelectedValuesContext";
import SelectedOptionscontext from "../dropdownns/contexts/displayfieldContext";
import SelectedModuleDisplayer from "./selectedModuleDisplayer";

const SelectedModuleDisplayers = () => {
  const { selectedOptions } = useContext(SelectedOptionscontext);

  return (
    <div className="combined-dropdown">
      {/* <div id="mdiv">
        <div class="mdiv">
          <div class="md"></div>
        </div>
      </div> */}
      <div>
        {selectedOptions.length > 0 && (
          <div>
            <h4 style={{ fontFamily: "sans-serif" }}>Selected Modules:</h4>
            <ul>
              {selectedOptions.map((option, index) => (
                <SelectedModuleDisplayer key={index} option={option} />
              ))}
            </ul>
          </div>
        )}
      </div>
    </div>
  );
};

export default SelectedModuleDisplayers;
