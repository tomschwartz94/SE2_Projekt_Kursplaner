import React, { Component } from "react";
import "../dropdownns/css/button.css";
class IcsExporter extends Component {
  constructor(props) {
    super(props);
  }
  state = {};
  render() {
    return (
      <div class="d-grid gap-2 d-md-block">
        <button class="btn btn-primary" type="button" className="export-button">
          Export as Ics file
        </button>
      </div>
    );
  }
}

export default IcsExporter;
