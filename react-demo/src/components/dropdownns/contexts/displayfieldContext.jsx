import React, { createContext, useState } from "react";

const SelectedOptionscontext = createContext();

export const SelectedOptionsProvider = ({ children }) => {
  const [selectedOptions, setSelectedOptions] = useState([]);

  return (
    <SelectedOptionscontext.Provider
      value = {{ selectedOptions, setSelectedOptions }} >
      {children}
    </SelectedOptionscontext.Provider>
  );
};

export default SelectedOptionscontext;
