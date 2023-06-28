import React from "react";
import Navbar from "./components/NavigationBar/NavigationBar";
import Footer from "./components/Footer/Footer";
import ConflictCheckButton from "./components/ConflictCheckButton/ConflictCheckButton";
import SelectionDisplay from "./components/SelectionDisplay/SelectionDisplay";
import SelectionMenu from "./components/SelectionMenu/SelectionMenu";
import { SelectedOptionsProvider } from "./components/Contexts/SelectionDisplayContext";
import "./index.css";
import "./App.css";
import ConflictDisplay from "./components/ConflictDisplay/ConflictDisplay";
import { ConflictProvider } from "./components/Contexts/ConflictDisplayContext";

window.$moduleAuswahlList = [];

function App() {
  return (
    <React.Fragment>
      <Navbar />
      <main className="container">
          <div className="combined-dropdown">
            <div align="left" style={{ display: "flex", flexDirection: "column" }}>
            <ConflictProvider>
              <SelectedOptionsProvider>
                <div style={{ display: "flex" }}>
                  <SelectionMenu />
                  <ConflictCheckButton />
                </div>
                <div style={{ display: "flex" }}>
                  <SelectionDisplay />
                  <ConflictDisplay />
                </div>
              </SelectedOptionsProvider>
              </ConflictProvider>
            </div>
          </div>
      </main>
      <Footer />
    </React.Fragment>
  );
}

export default App;
