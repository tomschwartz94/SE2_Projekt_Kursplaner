import React, { useState } from "react";
import "./SelectionDisplayItem.css";
import ListGroup from 'react-bootstrap/ListGroup';

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
    <ListGroup.Item as="li" action onClick={() => handleClick(option.id)}>
      {option.name}
    </ListGroup.Item>
  );
};

export default SelectedModuleDisplayer;
