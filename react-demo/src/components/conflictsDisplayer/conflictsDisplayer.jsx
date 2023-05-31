import React, { Component } from "react";
class ConflictsDisplayer extends Component {
  state = {};
  render() {
    return (
      <div class="d-grid gap-2 d-md-block">
        <button class="btn btn-danger" type="button">
          Number of Conflits : 15
        </button>
      </div>
    );
  }
}

export default ConflictsDisplayer;
