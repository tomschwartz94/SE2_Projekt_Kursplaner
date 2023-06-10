import React, { Component } from "react";
import "./ConflictCheckButton.css";


var konfliktData;

const ueberpruefenCall = async () => {
    
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

class ConflictsDisplayer extends Component {
  state = {};

  

  render() {
    return (
      <div class="d-grid gap-2 d-md-block">
        <button class="btn btn-danger" type="button" className="normale-button" onClick={() => ueberpruefenCall()}>
          Überprüfen
        </button>
      </div>
    );
  }
}

export default ConflictsDisplayer;
