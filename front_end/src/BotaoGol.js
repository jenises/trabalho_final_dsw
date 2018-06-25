import React, { Component } from 'react';

import {
    Button
} from 'reactstrap';


class BotaoGol extends Component {
    handleClick(event) {
        event.preventDefault();
        this.props.marcarGol();
    }
    
    render() {
        return (
                <div>
                <Button color="info" onClick={this.handleClick.bind(this)}>Gol</Button>
                </div>
        )
    }
}

export default BotaoGol;

