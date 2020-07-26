import React, {Component} from 'react';
import ClickCard from './ClickCard';
import Form from 'react-bootstrap/Form';
import Utils from "./Utils";



class Checkout extends Component{

    defaultState={
        boardingDogs:[]

    }
    constructor(){
        super();
        this.state = this.defaultState;
    
      }
      componentDidMount(){
        Utils.get("dogs").then(data =>{
            
          this.setState({boardingDogs: data});
          
        });
      }
       checkOut = dog=>{
           console.log(dog)
       }
    render(){
        return(
            <div > 
            <div className ="grid-page">
             {
                 this.state.boardingDogs.map(dog =>{
                  return(
                      <ClickCard
                      key ={"dog-card" + dog.name}
                      target = {dog}
                      title ={dog.name}
                      text ={<span><span>
                        {"dog breed: " + dog.breed}
                         <br/></span>
                         <span>{"dog's age: " + dog.age}<br/></span>
                         <span>{"kennel Size:" + dog.kennelSize}
                         </span>
                         </span>}
                         onButtonClick={this.checkout }
                      />
                  )
                 }

                 )
             }
            </div>
            
            </div>
        );
            
        
    }
}

export default Checkout;