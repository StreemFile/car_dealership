import React, {Component} from 'react';
import CustomerService from "../../service/CustomerService";
import CustomerListComponent from "./CustomerListComponent";
import {NavLink} from "react-router-dom";

class CustomerGetAllComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            customers: []
        }
        this.createCustomer = this.createCustomer.bind(this);
    }

    createCustomer() {
        this.props.history.push("customers/create")
    }

    getById(id){
        console.log(id);
        this.props.history.push(`customers/get/${id}`);
    }

    componentDidMount() {
        CustomerService.getAll().then((res) =>{
                this.setState({customers: res.data});
            });
    }


    render() {
        return (
            <div>
               <CustomerListComponent customers = {this.state.customers} />
                <div>
                    <button type="submit" className="btn btn-success m-2"  onClick={this.createCustomer}>Create</button>
                </div>
               <div>
                   <form autoComplete="off">
                       <div className="input-group  ms-2 mb-3" style={{width: '500px'}}>
                           <input type="search" name="id" className="form-control"
                                  id="idInput" placeholder="Search by id"/>
                           <button className="btn btn-success" type="submit" id="button-addon2"
                                   onClick={() => this.getById(document.getElementById("idInput").value)}>Search</button>
                       </div>
                   </form>
               </div>
            </div>
        )
    }
}

export default CustomerGetAllComponent;