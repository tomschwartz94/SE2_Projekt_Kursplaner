import React, { useEffect, useState, useContext } from "react";
import { Dropdown } from "react-bootstrap";
import SelectedOptionscontext from "../Contexts/SelectionDisplayContext";
import "./SelectionMenu.css";


const semester = [1, 2, 3, 4, 5, 6];
var semesterA;
var moduleA;
var module = [];
var studiengangID;

const SelectionMenu = () => {
  const { setSelectedOptions } = useContext(SelectedOptionscontext);
  const [studiengaenge, setStudiengaenge] = useState([]);
  const [studiengangAnzeige, setStudiengangAnzeige] = useState('Studiengang');
  const [semesterAnzeige, setSemesterAnzeige] = useState('Semester');
  const [modulAnzeige, setModulAnzeige] = useState('Veranstaltung');

  const fetchModule = async () => {
    try {
      await fetch('api/modul/' + studiengangID).then(response => response.json()).then(data => {
        module = Array.from(data);
      });
    } catch (error) {
      console.error(error);
    }
  };

  //Studiengaenge laden
  useEffect(() => {
    fetch('api/studiengang').then(response => response.json()).then(data => {
      setStudiengaenge(data);
    });
  }, []);

  const auswahlStudiengang = option => {
    setStudiengangAnzeige(option.name);
    studiengangID = option.id;
    fetchModule();
    semesterA = [];
    semester.forEach(sem => {
      semesterA.push(
      <Dropdown.Item key={sem} onClick={() => auswahlSemester(sem)}>
        {sem}
      </Dropdown.Item>
      );

    });
  };

  const auswahlSemester = subOption => {
    setSemesterAnzeige(subOption);
    moduleA = [];
    module.forEach(modul => {
      if (modul.semester === subOption) {
        moduleA.push(<Dropdown.Item key={modul.name} onClick={() => auswahlModul(modul)}>
          {modul.name}
        </Dropdown.Item>);
      }
    });
  };

  const auswahlModul = subsubOption => {
    setModulAnzeige(subsubOption.name);

    if (!window.$moduleAuswahlList.some(ele => ele.id === subsubOption.id)) {
      setSelectedOptions(selectedOptions => [...selectedOptions, subsubOption]);
      window.$moduleAuswahlList.push(subsubOption);
    }

    ;
  };

  return <div className="nested-select-container">
      <div className="nested-select">
        <Dropdown>
          <Dropdown.Toggle variant="primary">
            {studiengangAnzeige}
          </Dropdown.Toggle>
          <Dropdown.Menu>
            {studiengaenge.map(studiengang => <Dropdown.Item key={studiengang.name} onClick={() => auswahlStudiengang(studiengang)}>
                {studiengang.name}
              </Dropdown.Item>)}
          </Dropdown.Menu>
        </Dropdown>

        <Dropdown>
          <Dropdown.Toggle variant="primary">
            {semesterAnzeige}
          </Dropdown.Toggle>
          <Dropdown.Menu>
            {semesterA}
          </Dropdown.Menu>
        </Dropdown>
            
        <Dropdown>
          <Dropdown.Toggle variant="primary">
            {modulAnzeige}
          </Dropdown.Toggle>
          <Dropdown.Menu>
              {moduleA}
          </Dropdown.Menu>
        </Dropdown>
      </div>
    </div>;
};

export default SelectionMenu;