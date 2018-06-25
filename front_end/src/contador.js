//import React from 'react';
import React, { Component } from 'react';
import logo from './logo.svg';
//import './App.css';
//aprendendo react
//import React, { Component } from 'react';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    Container,
    Row,
    Col,
    Jumbotron,
    Button
} from 'reactstrap';


class Contador extends Component {
    constructor() {
        super();
        this.state = {
            contador : 0,
        }
    } 
    
    decrementar() {
        this.setState({
            contador: this.state.contador -1,
        }); 
    }
    
    incrementar() {
        this.setState({
            contador : this.state.contador +1,
        });
    }
    
    render() {
        return (
            <div class="container-fluid">
                <h1>{this.state.contador}</h1>
                <div >
                    <button color="danger" onClick={this.decrementar.bind(this)}>-</button>
                    <button color="blue" onClick={this.incrementar.bind(this)} >+</button>
                </div>
            </div>
        );
    }
}

export default Contador;



/*class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

export default App;
*/