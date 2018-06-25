import React, { Component } from 'react';

import { Card, Button, CardImg, CardTitle, CardText, CardDeck,
 CardSubtitle, CardBody } from 'reactstrap';
import axios from 'axios';

class GrupoProduto extends Component {
    
    constructor(props) {
        super(props);
        this.state = { listaItens: [] }

        this.refresh = this.refresh.bind(this);  
    }
    
    refresh(Nome = '') {
        try {
            axios.get('http://localhost:8080/trabalho_final/web/produto').
                  then (response => {this.setState({listaItens : response.data})});
        }
        catch(e) {
            console.log('ERRO AO RECUPERAR OS DADOS');
        }    
    }
    
    componentdidMount() {
        this.refresh();
    }
    
    
    render() {
        return (
        <CardDeck>
            <Card>
              <CardImg top width="100%" src="http://montink.camisadimona.com.br/image/cache/data/camisas/camiseta-selecao-brasileira-copa-russia-2018-5acd03d7cbb65-470x668.png" alt="Card image cap" />
              <CardBody>
                <CardTitle>Camisa Maasc. Seleção Brasileira Original</CardTitle>
                <CardSubtitle>R$109,90</CardSubtitle>
                <CardText>Esta camisa e muito boa e blablablablablablablablablablablablablablablablablablablablablabla</CardText>
               <Button color="success">Comprar</Button>
              </CardBody>
            </Card>
            <Card>
              <CardImg top width="100%" src="http://montink.camisadimona.com.br/image/cache/data/camisas/camiseta-selecao-brasileira-copa-russia-2018-5acd03d7cbb65-2-680x969.png" alt="Card image cap" />
              <CardBody>
                <CardTitle>Camisa Fem. Seleção Brasileira</CardTitle>
                <CardSubtitle>R$105,90</CardSubtitle>
                <CardText>Esta camisa também e muito boma  blablablablabla blablabla</CardText>
                <Button color="success">Comprar</Button>
              </CardBody>
            </Card>
            <Card>
              <CardImg top width="100%" src="http://montink.camisadimona.com.br/image/cache/data/camisas/alien-messi-5ab63f88a669c-680x969.png" alt="Card image cap" />
              <CardBody>
                <CardTitle>Camisa do Messi</CardTitle>
                <CardSubtitle>R$50,99</CardSubtitle>
                <CardText>Camisa do messi que joga no barcelona a na seleçao da argentina bla bla bla bla</CardText>
                <Button color="success">Comprar</Button>
              </CardBody>
            </Card>
          </CardDeck>        
       )
            
    }
    
}
export default GrupoProduto;