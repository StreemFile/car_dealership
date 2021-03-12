import React, {Component} from 'react';

import CustomerService from "../../service/CustomerService.jsx";

import CustomerEditButtonComponent from "../CustomerEditButtonComponent.jsx";
import CustomerDeleteButtonComponent from "./CustomerDeleteButtonComponent.jsx";

class TableBodyComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            customers: []
        }
        this.deleteCustomer = this.deleteCustomer.bind(this);
    }

    deleteCustomer(id){
        CustomerService.delete(id).then(res => {
            this.setState(
                {customers:
                        this.state.customers
                            .filter(customer => customer.id !== id)});
        });
    }

    componentDidMount() {
        CustomerService.getAll().then((res) =>{
            this.setState({customers: res.data});
        });
    }

    render() {
        return (
            <tbody>
            {
                this.state.customers.map(
                    customer =>
                        <tr key={customer.id}>
                            <td>{customer.id}</td>
                            <td>{customer.name}</td>
                            <td>{customer.telephone}</td>
                            <td>{customer.placeOfResidence}</td>
                            <td>{customer.address}</td>
                            <td>{customer.passport}</td>
                            <td>{customer.description}</td>
                            <td>{customer.created_at}</td>
                            <td>{customer.modified_at}</td>
                            <td>
                                <CustomerEditButtonComponent id={customer.id}/>
                            </td>
                            <td>
                                <button className="btn btn-danger mt-1" onClick={() => this.deleteCustomer(customer.id)}>Delete
                                </button>
                                {/*<CustomerDeleteButtonComponent customers = {this.state.customers} id = {customer.id} />*/}
                            </td>
                        </tr>
                )
            }
            </tbody>
        );
    }
}

export default TableBodyComponent