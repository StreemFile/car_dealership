import React, {Component} from 'react';
import CustomerService from "../service/CustomerService";
import CustomerList from "./GetAllComponents/CustomerList";
import CreateButton from "./GetAllComponents/CreateButton"
import GetById from "./GetAllComponents/GetById";

class CustomerGetAllComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            customers: []
        }
    }

    componentDidMount() {
        CustomerService.getCustomers().then((res) =>{
                this.setState({customers: res.data});
            });
    }

    render() {
        return (
            <div>
               <CustomerList customers = {this.state.customers}/>
               <CreateButton />
               <GetById />
            </div>
        )
    }
}

export default CustomerGetAllComponent