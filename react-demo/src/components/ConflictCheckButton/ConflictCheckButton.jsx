import React, { Component } from "react";
import "./ConflictCheckButton.css";


var konfliktData;

const fetchUeberpruefen = async (ob) => {
    
  const requestOptions = {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(window.$moduleAuswahlList)
  };

  try {
    await fetch('api/kalender/check', requestOptions)
    .then(response => response.json())
    .then(data => {
      konfliktData = data;
    });
  } catch (error) {
    console.error(error);
  };
  console.log(konfliktData);
  
};

class ConflictCheckButton extends Component {
  constructor() {
    super();
    this.state = { 
      style: "btn btn-outline-dark"
    };
    this.onClick = this.onClick.bind(this);
  }

  onClick(event) {
    fetchUeberpruefen();
    this.setState({ 
      style: "btn btn-outline-danger"
    });
 }

  render() {
    return (
      <div class="d-grid gap-2 d-md-block">
        <button class={this.state.style} type="button" onClick={this.onClick}>
          Überprüfen
        </button>
      </div>
    );
  }
}

export default ConflictCheckButton;
