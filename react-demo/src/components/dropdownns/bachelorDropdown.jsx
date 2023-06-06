import React, { useState } from "react";
import { Dropdown } from "react-bootstrap";

class Bachelor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      dict: {
        awesome: ["wow", "alo"],
        great: ["ano", "alo"],
      },
      selectedValue: "",
    };
  }

  handleSelect = (value) => {
    const { dict } = this.state;
    const selectedDictValue = dict[value];

    if (selectedDictValue) {
      this.setState({ selectedValue: selectedDictValue });
    } else {
      this.setState({ selectedValue: "" });
    }
  };

  render() {
    const { selectedValue } = this.state;

    return (
      <Dropdown onSelect={this.handleSelect}>
        <Dropdown.Toggle>Bachelor Degree Course</Dropdown.Toggle>
        <Dropdown.Menu>
          <Dropdown.Item eventKey="awesome">Awesome</Dropdown.Item>
          <Dropdown.Item eventKey="great">Great</Dropdown.Item>
        </Dropdown.Menu>

        {selectedValue && (
          <div>
            <h2>Selected Valuewww:</h2>
            <ul>
              {selectedValue.map((value, index) => (
                <li key={index}>{value}</li>
              ))}
            </ul>
          </div>
        )}
      </Dropdown>
    );
  }
}

export default Bachelor;
