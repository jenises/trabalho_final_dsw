import React, { Component } from 'react';
import Partida from './Partida';
import Time from './Time';
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


class PartidaContainer extends Component {
    constructor() {
        super();
        this.state = {
            gols_casa : 0,
            gols_vistante : 0,
        };
    }
        
    marcarGolCasa() {
        this.setState({
            gols_casa : this.state.gols_casa +1,
        });
    }
    
    marcarGolVisitante() {
        this.setState({
            gols_vistante : this.state.gols_vistante +1,
        });
    }
    
    render() {
        return (
                <div>
                   <div style={{float: 'left', "marginRight": '20px'}}>
                        <h3>Casa</h3>
                        <Time nome={this.props.casa.nome}
                              gols ={this.state.gols_casa}
                              marcarGol={this.marcarGolCasa.bind(this)}/>
                   </div>
                   <div style={{float: 'left', "marginRight": '20px'}}>
                       <Partida estadio={this.props.partida}/>
                   </div>
                   <div style={{float: 'left', "marginRight": '20px'}}>
                       <h3>Visitante</h3>
                        <Time nome={this.props.visitante.nome}
                              gols={this.state.gols_vistante} 
                              marcarGol={this.marcarGolVisitante.bind(this)}/>
                   </div>
                   <div style={{clear:"both"}}></div> 
                </div>
        )
    }
}

export default PartidaContainer;



