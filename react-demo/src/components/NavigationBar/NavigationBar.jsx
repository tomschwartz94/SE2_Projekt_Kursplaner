//import  HAW-LOGO
import React, { Component } from "react";
import "./NavigationBar.css";

class Navbar extends Component {
  render() {
    return (
      <nav class="navbar fixed-top bg-primary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            HAW Kursplaner
          </a>
        </div>
      </nav>
    );
  }
}

export default Navbar;
