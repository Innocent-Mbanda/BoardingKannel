import React, { Component } from "react";
import Form from "react-bootstrap/Form";
import Utils from "./Utils"

class CheckIn extends Component {
  defaultState ={
    name:'',
    breed: '',
    age:'',
    Allergies:'',
    isFed:false,
    amountOfFed:'',
    AmountOfFood:'',
    kennelSize:'',
    shouwAmountFed:''
  }

  constructor(){
    super();
    this.state = this.defaultState;

  }

  onChange =(e)=>{
    this.setState({[e.target.name]:e.target.value});

  }
 onRadioChange = (e)=>{
   if(e.target.id.includes('yes')){
     this.setState({ [e.target.name]: true});
     this.setState({shouwAmountFed:true});
   } else{
    this.setState({ [e.target.name]: false});
    this.setState({shouwAmountFed:false});
   }
 }


  handleSubmit =(e)=>{ 
    e.preventDefault();//this keeps page from refreshing
    const postData ={
     
         'breed': this.state.breed,
       'age':parseInt(this.state.age.charAt(0)),
         'name':this.state.name,
         'allergies':this.state.Allergies,
        'amountOfFood':parseInt(this.state.AmountOfFood.charAt(0)),
         'amountOfFed':parseInt(this.state.amountOfFed.charAt(0)), 
        'isfeed':this.state.isFed,
        'kannelSize':this.state.kennelSize.toUpperCase()
    }
    Utils.post("/addDog",postData)
    this.resetState();
  }
 resetState(){
   this.setState(this.defaultState)
 }
  render() {
    return (
      <div>
        <Form onSubmit ={this.handleSubmit}>
          <Form.Group controlId="DogName">
            <Form.Label>Dog's Name</Form.Label>
            <Form.Control type="input" name="name" value ={this.state.name} onChange = {this.onChange} />
          </Form.Group>

          <Form.Group controlId>
            <Form.Label> How old is your dog?</Form.Label>
            <Form.Control as="select" name="age" value ={this.state.age} onChange = {this.onChange}>
              <option> >6 months</option>
              <option>1 year</option>
              <option>2 years</option>
              <option>3 years</option>
              <option>4 years</option>
              <option>5 years</option>
              <option>6 years</option>
              <option>7 years</option>
            </Form.Control>
          </Form.Group>
          <Form.Group controlId>
            <Form.Label>Breed</Form.Label>
            <Form.Control type name="breed" value ={this.state.breed} onChange = {this.onChange} />
          </Form.Group>

          <Form.Group controlId>
            <Form.Label> List Of Allergies </Form.Label>
            <Form.Control as="textarea" rows="3" name="Allergies" value ={this.state.Allergies} onChange = {this.onChange} />
          </Form.Group>
          
          <Form.Group controlId ="Feeding">
            <Form.Label> How many cups of food does your dog eat?</Form.Label>
            <Form.Control as="select" name="AmountOfFood" value ={this.state.AmountOfFood} onChange = {this.onChange}>
              
              <option>1 cup</option>
              <option>2 cups</option>
              <option>3 cups</option>
              <option>4 cups</option>
              <option>5 cups</option>
              <option>6 cups</option>
              <option>7 cups</option>
            </Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Has your dog been fed today?</Form.Label>
            <div key={"hasBeenFed"} className="mb-2" >
              <Form.Check
                inline
                onChange={this.onRadioChange}
                name="isFed"
                type="radio"
                id="yes-Fed"
                label={"Yes"}
                checked ={this.state.isFed}
              />
              <Form.Check
                inline
                onChange={this.onRadioChange}
                name="isFed"
                type="radio"
                id="No-Fed"
                label={"No"}
                check ={!this.state.isfed}
              />
            </div>
          </Form.Group>
          <Form.Group controlId>
            <Form.Label> How many cups of food has your dog been fed today?</Form.Label>
            <Form.Control as="select" name="amountOfFed" value ={this.state.amountOfFed} onChange = {this.onChange}>
              <option>1 Cup</option>
              <option>2 Cups</option>
              <option>3 Cups</option>
              <option>4 Cups</option>
            </Form.Control>
          </Form.Group>
          <Form.Group controlId>
            <Form.Label> Kennel Size</Form.Label>
            <Form.Control as="select" name="kennelSize" value ={this.state.kennelSize} onChange = {this.onChange}>
              <option>Small</option>
              <option>Medium</option>
              <option>Large</option>
            </Form.Control>
          </Form.Group>
          <button variant ="primary" type="submit">
          submit
          </button>
        </Form>
      </div>
    );
  }
}

export default CheckIn;
