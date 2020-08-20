import React, { Component } from "react";
import ClickCard from "./ClickCard";
import Form from "react-bootstrap/Form";
import Utils from "./Utils";

class Checkout extends Component {
  defaultState = {
    boardingDogs: [],
    search:""
  };
  constructor() {
    super();
    this.state = this.defaultState;
  }
  componentDidMount() {
    Utils.get("dogs").then((data) => {
      this.setState({ boardingDogs: data });
    });
  }
  onChange=(e)=>{
    this.setState({
      search:e.target.value
    })
  }
  checkout = (dog) => {
      console.log(dog)
    const postData = {
      id: dog.id
    };
    Utils.post("checkOutDog", postData).then(data=>{
      this.setState({
        boardingDogs:data
      })
    })
    console.log(postData)
  }
  render() {
    return (
      <div>
      <div><Form.Control type="text"
       placeholder="Search" onChange ={this.onChange}/> </div>
        <div className="grid-page">
          {this.state.boardingDogs.map((dog) => {
            const search =this.state.search;
            if(search !== ''
            && dog.name.toLowerCase().indexOf(search.toLowerCase()) === -1){
              return null;
            }
            return (
              <ClickCard
                key={"dog-card" + dog.name}
                target={dog}
                title={dog.name}
                text={
                  <span>
                    <span>
                      {"dog breed: " + dog.breed}
                      <br />
                    </span>
                    <span>
                     {"dog's age: " + dog.age}
                      <br />
                    </span>
                    <span>{"kennel Size:" + dog.kennelSize}</span>
                  </span>
                }
                onButtonClick={this.checkout}
              />
            );
          })}
        </div>
      </div>
    );
  }
}

export default Checkout;
