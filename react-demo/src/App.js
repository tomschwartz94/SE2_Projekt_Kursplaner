import React, { Component } from "react";
import "./index.css";
import "./App.css";
import Navbar from "./components/bars/navbar";
import Footer from "./components/bars/footer";
import "./components/dropdownns/css/dropdownCombined.css";
import SelectButton from "./components/button";
import SelectedModuleDisplayer from "./components/selectedModuleDisplayer/selectedModuleDisplayer";
import "./components/selectedModuleDisplayer/selectedModuleDipslayer.css";
import ConflictsDisplayer from "./components/conflictsDisplayer/conflictsDisplayer";
import IcsExporter from "./components/icsExporter/icsExporter";
import GeneralDropdown from "./components/dropdownns/bachelorDropdown";
import Semester from "./components/dropdownns/semester";
import Module from "./components/dropdownns/Modules";
import SelectedModuleDisplayers from "./components/selectedModuleDisplayer/selectedModuledisplayers";
import Bachelor from "./components/dropdownns/bachelorDropdown";
import NestedSelect from "./components/dropdownns/Nestedselect";
import DropdownForm from "./components/dropdownns/ParentComponent";
import ParentComponent from "./components/dropdownns/ParentComponent";
import ComponentA from "./components/dropdownns/ComponentA";
import ComponentB from "./components/dropdownns/ComponentB";
import "../src/components/dropdownns/css/displayfield.css";

import { SelectedValuesProvider } from "./components/dropdownns/contexts/SelectedValuesContext";
import Modules from "./components/dropdownns/Modules";
import Mycontext, {
  SelectedOptionsProvider,
} from "./components/dropdownns/contexts/displayfieldContext";

import "../src/components/dropdownns/css/button.css";
import ConflictsDisplayerBoard from "./components/conflictsDisplayer/ConflictsDisplayerBoard";

function App() {
  return (
    <React.Fragment>
      <Navbar />
      <main className="container">
        <SelectedValuesProvider>
          <SelectedOptionsProvider>
            <div className="combined-dropdown">
              <div style={{ display: "flex", flexDirection: "column" }}>
                <div style={{ display: "flex" }}>
                  <NestedSelect />
                  <Modules />
                </div>
                <div>
                  <SelectedModuleDisplayers />
                </div>
              </div>
            </div>
          </SelectedOptionsProvider>
        </SelectedValuesProvider>

        <div className="combined-dropdown">
          <div>
            <div>
              <ConflictsDisplayer />
              <IcsExporter />
            </div>
          </div>
          {/* <ConflictsDisplayerBoard /> */}
        </div>
      </main>

      <Footer />
    </React.Fragment>
  );
}

export default App;
