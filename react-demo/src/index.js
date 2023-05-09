import React from "react";
import ReactDOM from "react-dom/client";

import App from "./App";
import reportWebVitals from "./reportWebVitals";

import Navbar from "./components/bars/navbar";
//currrently using bootsrap 5.2
import "bootstrap";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap.js";
import SelectButton from "./components/button";
import SelectedModuleDisplayer from "./components/selectedModuleDisplayer/selectedModuleDisplayer";
import ConflictsDisplayer from "./components/conflictsDisplayer/conflictsDisplayer";
import IcsExporter from "./components/icsExporter/icsExporter";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();