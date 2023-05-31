import React, { Component } from "react";
import "./index.css";
import "./App.css";
import Navbar from "./components/bars/navbar";
import Footer from "./components/bars/footer";
import "D:/SE1/react/react-demo/src/components/dropdownns/css/dropdownCombined.css";
import SelectButton from "./components/button";
import SelectedModuleDisplayer from "./components/selectedModuleDisplayer/selectedModuleDisplayer";
import "D:/SE1/react/react-demo/src/components/selectedModuleDisplayer/selectedModuleDipslayer.css";
import ConflictsDisplayer from "./components/conflictsDisplayer/conflictsDisplayer";
import IcsExporter from "./components/icsExporter/icsExporter";
import GeneralDropdown from "./components/dropdownns/bachelorDropdown";
import Semester from "./components/dropdownns/semester";
import Module from "./components/dropdownns/Modules";
function App() {
  return (
    <React.Fragment>
      <Navbar />
      <main className="container">
        <div className="combined-dropdown">
          <GeneralDropdown />
          <Semester />
          <Module />
          <SelectButton />
        </div>
        <div className="combined-dropdown">
          <div>
            <div>
              <p>Selected Modules:</p>
              <SelectedModuleDisplayer />
              <SelectedModuleDisplayer />
              <SelectedModuleDisplayer />
              <p>Click the X to remove a module</p>
            </div>
            <div>
              <ConflictsDisplayer />
              <IcsExporter />
            </div>
          </div>

          <form disabled>
            <textarea disabled id="w3review" name="w3review" rows="4" cols="50">
              This is just to display conflicts, don worry its gonna look better
              .im just too busy to fix it now !!!
            </textarea>
          </form>
        </div>
      </main>

      <Footer />
    </React.Fragment>
  );
}

export default App;
