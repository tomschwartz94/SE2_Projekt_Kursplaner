import React, { useContext } from "react";
import SelectedOptionscontext from "../dropdownns/contexts/displayfieldContext";
import SelectedModuleDisplayer from "./selectedModuleDisplayer";

const SelectedModuleDisplayers = () => {
  const { selectedOptions } = useContext(SelectedOptionscontext);

  return (
    <div className="combined-dropdown">
      <div>
        {selectedOptions.length > 0 && (
          <div>
            <h4 style={{ fontFamily: "sans-serif" }}>Ausgewählte Kurse:</h4>
            <ul>
              {selectedOptions.map(option => (
                <SelectedModuleDisplayer key={option.id} option={option} />
              ))}
            </ul>
          </div>
        )}
      </div>
    </div>
  );
};

export default SelectedModuleDisplayers;
