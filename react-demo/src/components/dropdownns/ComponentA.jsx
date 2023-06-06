import React, { useContext } from "react";
import SelectedValuesContext from "./contexts/SelectedValuesContext";

function ComponentA() {
  const { selectedValues, setSelectedValues } = useContext(
    SelectedValuesContext
  );

  const handleSelect = (event) => {
    const selectedValue = event.target.value;
    setSelectedValues([...selectedValues, selectedValue]);
  };

  return (
    <div>
      <select onChange={handleSelect}>
        <option value="Option 1">Option 1</option>
        <option value="Option 2">Option 2</option>
        <option value="Option 3">Option 3</option>
      </select>
    </div>
  );
}

export default ComponentA;
