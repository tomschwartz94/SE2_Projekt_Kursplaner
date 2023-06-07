import React, { Component } from "react";
import Navbar from "./components/bars/navbar";
import Footer from "./components/bars/footer";
import SelectedModuleDisplayer from "./components/selectedModuleDisplayer/selectedModuleDisplayer";
import ConflictsDisplayer from "./components/conflictsDisplayer/conflictsDisplayer";
import IcsExporter from "./components/icsExporter/icsExporter";
import Module from "./components/dropdownns/Modules";
import SelectedModuleDisplayers from "./components/selectedModuleDisplayer/selectedModuledisplayers";
import NestedSelect from "./components/dropdownns/Nestedselect";
import { SelectedValuesProvider } from "./components/dropdownns/contexts/SelectedValuesContext";
import Modules from "./components/dropdownns/Modules";
import Mycontext, {
  SelectedOptionsProvider,
} from "./components/dropdownns/contexts/displayfieldContext";
import ConflictsDisplayerBoard from "./components/conflictsDisplayer/ConflictsDisplayerBoard";
import "./index.css";
import "./App.css";
import "./components/dropdownns/css/dropdownCombined.css";
import "./components/selectedModuleDisplayer/selectedModuleDipslayer.css";
import "../src/components/dropdownns/css/displayfield.css";
import "../src/components/dropdownns/css/button.css";

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
