import React, {Component} from 'react';
import Button from  'react-bootstrap/Button';
import Card from  'react-bootstrap/Card';

class ClickCard extends Component{
handelClick =e=>{
    this.props.onButtonClick(
        this.props.target
    )

}
render(){
    return (
        <div className= "grid-item">
        <Card bg= "dark" border="dark">
        <Card.Body>
        <Card.Title>
        {this.props.title}
        </Card.Title>
        <Card.Text>
        {this.props.text}
        </Card.Text>
        <Button  variant ="primary" onClick ={this.handelClick}> Checkout
        </Button>
        </Card.Body>
        </Card>
        </div>


    )
}


}

export default ClickCard;