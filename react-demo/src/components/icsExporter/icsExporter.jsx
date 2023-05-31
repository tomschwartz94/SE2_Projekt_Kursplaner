import React, { Component } from "react";
class IcsExporter extends Component {
  constructor(props) {
    super(props);
  }
  state = {};
  render() {
    return (
      <div class="d-grid gap-2 d-md-block">
        <button class="btn btn-primary" type="button">
          Export as Ics file
        </button>
      </div>
    );
  }
}

export default IcsExporter;
