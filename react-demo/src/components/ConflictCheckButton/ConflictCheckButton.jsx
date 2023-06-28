import React, { useContext, useState } from "react";
import "./ConflictCheckButton.css";
import ConflictProvider from "../Contexts/ConflictDisplayContext";


const ConflictCheckButton = () => {

  const [buttonStyle, setButtonStyle] = useState('btn btn-outline-dark');
  const { setConflictOptions } = useContext(ConflictProvider);

  const fetchUeberpruefen = async (ob) => {
    
    const requestOptions = {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(window.$moduleAuswahlList)
    };
  
    try {
      return await fetch('api/kalender/check', requestOptions)
      .then(response => response.json());
    } catch (error) {
      console.error(error);
    };
  };

  const dataEvaluation = (data) => {

    var new_data = [];
    var new_ob = {name: "",
                  value: []
                  };
    var data_raw = Object.assign([], data.termin_error);
    var k = false;

    data_raw.forEach(ele =>{
      var name = ele.termin_a.modul.name + " x " + ele.termin_b.modul.name;
      k = false;
      for( var i=0; i < new_data.length; i++){
        if(new_data[i].name === name){
          new_data[i].value.push(ele);
          k = true;
        }
      }
      if(!k){
        new_ob = {name: name,
        value: [ele]
        };
        new_data.push(new_ob);
      }
      
    });
    setConflictOptions(new_data);
  };

  const onClick = () => {
    setButtonStyle('btn btn-outline-dark');
    setConflictOptions(undefined)
    if(window.$moduleAuswahlList.length >= 2){ 
     
      fetchUeberpruefen().then(data => {
        if(data.error_anzahl > 0){
          setButtonStyle('btn btn-outline-danger');
          dataEvaluation(data);
        }
        else{
          setButtonStyle('btn btn-outline-success');
        }
      });
    } 
  }

  return (
    <div class="d-grid gap-2 d-md-block">
      <button class={buttonStyle} type="button" onClick={() => onClick()} data-toggle="tooltip" data-placement="top" title="Test">
        Überprüfen
      </button>
    </div>
  );
  
}

export default ConflictCheckButton;
