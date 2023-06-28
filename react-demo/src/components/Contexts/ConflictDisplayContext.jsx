import React, { createContext, useState } from "react";

const ConflictContext = createContext();

export const ConflictProvider = ({ children }) => {
  const [conflictOptions, setConflictOptions] = useState();

  return (
    <ConflictContext.Provider
      value = {{ conflictOptions, setConflictOptions }} >
      {children}
    </ConflictContext.Provider>
  );
};

export default ConflictContext;
