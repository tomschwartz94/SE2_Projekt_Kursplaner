import React, { useContext } from "react";
import SelectedOptionscontext from "../Contexts/SelectionDisplayContext";
import SelectedModuleDisplayer from "./SelectionDisplayItem";
import ListGroup from 'react-bootstrap/ListGroup';

const SelectionDisplay = () => {
  const { selectedOptions } = useContext(SelectedOptionscontext);

  return (
     <div>
      <h4>Ausgewählte Kurse:</h4>
        {selectedOptions.length > 0 && (
          <ListGroup as="ol" numbered>
            { selectedOptions.map(option => (
              <SelectedModuleDisplayer key={option.id} option={option} />
            )) }
          </ListGroup>
        )}
    </div>
  );
};

export default SelectionDisplay;
