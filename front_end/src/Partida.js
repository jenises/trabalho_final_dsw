import React, { Component } from 'react';
class Partida extends Component {
    
    render() {
        return (
                <div>
                    <h2>{this.props.estadio.estadio}</h2>
                    <div>
                        <span>{this.props.estadio.data}</span>
                        <span> - </span>
                        <span>{this.props.estadio.horario}</span>
                    </div>
                </div>
        )
    }
}

export default Partida;

