import React, {Component} from 'react';
import CustomerListComponent from "./CustomerListComponent";
import CustomerService from "../../service/CustomerService";
import CustomersGetAllButtonComponent from "../CustomersGetAllButtonComponent";

class CustomerGetById extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            customer: []
        }
    }

    componentDidMount(){
        CustomerService.getById(this.state.id).then(res => {
            this.setState({customer: res.data});
        })
    }

    render() {
        return (
            <div>
                <CustomerListComponent customer = {this.state.customer}/>
                <CustomersGetAllButtonComponent />
            </div>

        )
    }
}

export default CustomerGetById 