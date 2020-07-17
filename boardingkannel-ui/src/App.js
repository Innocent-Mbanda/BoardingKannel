import React from "react";
import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Navbar, Nav, Button, } from "react-bootstrap";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Home from "./component/Home";
import Checkin from "./component/CheckIn";
import Availability from "./component/Availability";
import Checkout from "./component/Checkout";

function App() {
  return (
    <div className="App">
      <Router>
        <div className="App-header">
          <Navbar
            bg="dark"
            variant="dark"
            expanded="true"
            expand="lg"
            fixed="top"
          >
            <Navbar.Brand href="/">Boarding Kennel</Navbar.Brand>
            <Nav className="mr-auto">
              <Nav.Link href="/checkin">Check-in Dog</Nav.Link>
              <Nav.Link href="/checkout">Check-out dog</Nav.Link>
              <Nav.Link href="/availability">Availability</Nav.Link>
            </Nav>
          </Navbar>
          <div className="component">
            <Route path="/" exact component={Home} />
            <Route path="/checkin" component={Checkin} />
            <Route path="/checkout" component={Checkout} />
            <Route path="/availability" component={Availability} />
          </div>
        </div>
      </Router>
    </div>
  );
}

export default App;
