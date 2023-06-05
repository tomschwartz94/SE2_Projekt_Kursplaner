import React, { createContext, useState } from "react";

const SelectedValuesContext = createContext();

export const SelectedValuesProvider = ({ children }) => {
  const [selectedValues, setSelectedValues] = useState([]);

  return (
    <SelectedValuesContext.Provider
      value={{ selectedValues, setSelectedValues }}
    >
      {children}
    </SelectedValuesContext.Provider>
  );
};

export default SelectedValuesContext;
