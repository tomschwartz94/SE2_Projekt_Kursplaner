import React, { useEffect, useState } from "react";
import { Dropdown } from "react-bootstrap";
import "../dropdownns/css/nestedselect.css";
import "../dropdownns/css/button.css";

const semester = [1, 2, 3, 4, 5, 6];
var semesterA;
var moduleA;

const NestedSelect = () => {

  const [studiengaenge, setStudiengaenge] = useState([]);
  const [module, setModule] = useState(null);

  var [studiengangAnzeige, setStudiengangAnzeige] = useState('Studiengang');
  var [studiengangAuswahl, setStudiengangAuswahl] = useState(null);
  var [semesterAnzeige, setSemesterAnzeige] = useState('Semester');
  var [modulAnzeige, setModulAnzeige] = useState('Modul');


  const fetchData = async (id) => {
    try {
      const response = await fetch('api/modul/'+ id);
      const jsonData = await response.json();
      setModule(jsonData);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetch('api/studiengang')
      .then(response => response.json())
      .then(data => {
        setStudiengaenge(data);
      })
  }, []);

  const auswahlStudiengang = (option) => {
    console.log(studiengaenge);
    setStudiengangAnzeige(option.name);
    setStudiengangAuswahl(option);
    semesterA = [];
    semester.map(sem => {
      semesterA.push(
      <Dropdown.Item
        className="togglebutton"
        key={sem}
        onClick={() => auswahlSemester(sem)}
      >
        {sem}
      </Dropdown.Item>)   
    })
    fetchData(option.id);
  };

  const auswahlSemester = (subOption) => {
    setSemesterAnzeige(subOption);
    fetchData(studiengangAuswahl.id);
    moduleA = [];
    module.map(modul =>{
      if(modul.semester == subOption){
        moduleA.push(<Dropdown.Item
          className="togglebutton"
          key={modul.name}
          onClick={() => auswahlModul(modul)}
        >
          {modul.name}
        </Dropdown.Item>)
      }})
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
              {moduleA}
          </Dropdown.Menu>
        </Dropdown>

      </div>
    </div>
  );
};

export default NestedSelect;
