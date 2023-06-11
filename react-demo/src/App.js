import React from "react";
import Navbar from "./components/NavigationBar/NavigationBar";
import Footer from "./components/Footer/Footer";
import ConflictCheckButton from "./components/ConflictCheckButton/ConflictCheckButton";
import SelectionDisplay from "./components/SelectionDisplay/SelectionDisplay";
import SelectionMenu from "./components/SelectionMenu/SelectionMenu";
import { SelectedOptionsProvider } from "./components/Contexts/SelectionDisplayContext";
import "./index.css";
import "./App.css";

window.$moduleAuswahlList = [];

function App() {
  return (
    <React.Fragment>
      <Navbar />
      <main className="container">
        <SelectedOptionsProvider>
          <div className="combined-dropdown">
            <div style={{ display: "flex", flexDirection: "column" }}>
              <div style={{ display: "flex" }}>
                <SelectionMenu />
              </div>
              <div>
                <SelectionDisplay />
              </div>
            </div>
          </div>
        </SelectedOptionsProvider>

        <div className="combined-dropdown">
          <ConflictCheckButton />
        </div>
      </main>

      <Footer />
    </React.Fragment>
  );
}

export default App;
