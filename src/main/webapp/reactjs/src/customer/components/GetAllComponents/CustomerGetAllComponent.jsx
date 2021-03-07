import React, {Component} from 'react';
import CustomerService from "../../service/CustomerService";
import CustomerListComponent from "./CustomerListComponent";
import InputGetByIdComponent from "./InputGetByIdComponent";

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

    componentDidMount() {
        CustomerService.getAll().then((res) =>{
                this.setState({customers: res.data});
            });
    }

    render() {
        return (
            <div>
               <CustomerListComponent customers = {this.state.customers}/>
                <div>
                    <button type="submit" className="btn btn-success m-2"  onClick={this.createCustomer}>Create</button>
                </div>
               <InputGetByIdComponent />
            </div>
        )
    }
}

export default CustomerGetAllComponent;