import React, { useEffect, useState } from "react";
import { useContext } from "react";
import SelectedValuesContext from "./contexts/SelectedValuesContext";
import { Dropdown } from "react-bootstrap";
import "../dropdownns/css/nestedselect.css";
import "../dropdownns/css/button.css";


const semester = [1, 2, 3, 4, 5, 6];
var semesterA;
var moduleA;

const NestedSelect = ({ onSelectedValuesChange }) => {

  const [studiengaenge, setStudiengaenge] = useState([]);
  var [module, setModule] = useState([]);

  var [studiengangAnzeige, setStudiengangAnzeige] = useState('Studiengang');
  var [semesterAnzeige, setSemesterAnzeige] = useState('Semester');
  var [modulAnzeige, setModulAnzeige] = useState('Modul');

  useEffect(() => {

    fetch('api/studiengang')
      .then(response => response.json())
      .then(data => {
        setStudiengaenge(data);
      })
  }, []);

  const [selectedOption, setSelectedOption] = useState("");
  const [selectedSubOption, setSelectedSubOption] = useState("");
  const [displayedValue, setDisplayedValue] = useState("");
  const { selectedValues, setSelectedValues } = useContext(
    SelectedValuesContext
  );

  const auswahlStudiengang = (option) => {
    setSelectedOption(option); //?
    setStudiengangAnzeige(option.name);
    fetch('api/modul/'+ option.id)
        .then(response => response.json())
        .then(data => {
          setModule(data);
        })
      
    semesterA = [];
    semester.map(sem => (
      semesterA.push(
      <Dropdown.Item
        className="togglebutton"
        key={sem}
        onClick={() => auswahlSemester(sem)}
      >
        {sem}
      </Dropdown.Item>)
          
      ))

  };

  const auswahlSemester = (subOption) => {
    setSemesterAnzeige(subOption);
    module.map(modul =>{
      if(modul.semester == subOption){
        moduleA.push(modul)
      }
    })
  };
  const auswahlModul = (subsubOption) => {};
  
  return (
    <div className="nested-select-container">
      <div className="nested-select">
        <Dropdown>
          <Dropdown.Toggle
            variant="primary"
            className="togglebutton"
            style={{ borderRadius: "0" }}
          >
            {studiengangAnzeige}
          </Dropdown.Toggle>
          <Dropdown.Menu>
            {studiengaenge.map(studiengang => (
              <Dropdown.Item
                className="togglebutton"
                key={studiengang.name}
                onClick={() => auswahlStudiengang(studiengang)}
              >
                {studiengang.name}
              </Dropdown.Item>
            ))}
          </Dropdown.Menu>
        </Dropdown>

        <Dropdown>
          <Dropdown.Toggle
            className="togglebutton"
            style={{ borderRadius: "0" }}
          >
            {semesterAnzeige}
          </Dropdown.Toggle>
          <Dropdown.Menu>
            {semesterA}
          </Dropdown.Menu>
        </Dropdown>
            
        <Dropdown>
          <Dropdown.Toggle
            variant="primary"
            className="togglebutton"
            style={{ borderRadius: "0" }}
          >
            {modulAnzeige}
          </Dropdown.Toggle>
          <Dropdown.Menu>
              {/* {moduleA.map(m =>(
                <Dropdown.Item
                className="togglebutton"
                key={m.name}
                onClick={() => auswahlModul(m)}
              >
                {m.name}
              </Dropdown.Item>
              ))} */}
          </Dropdown.Menu>
        </Dropdown>

      </div>
    </div>
  );
};

export default NestedSelect;
