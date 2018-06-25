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

import Time from './Time';
import Time from './Partida';
class Placar extends Component {
    
    render() {
        return (
                <div>
                    <div>
                        <Time/>
                    </div>
                    <div>
                        <Partida/>
                    </div>
                    <div>
                        <Time/>
                    </div>
                </div>
        )
    }
}

export default Placar;
