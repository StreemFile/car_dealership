import React, {Component} from 'react';
import CustomerService from "../../service/CustomerService";
import {NavLink} from "react-router-dom";
import TableHeadComponent from "./TableHeadComponent";
import TableBodyComponent from "./TableBodyComponent";
import CustomerEditButtonComponent from "../CustomerEditButtonComponent";
import InputGetByIdComponent from "./InputGetByIdComponent";
import CustomerCreateButtonComponent from "./CustomerCreateButtonComponent";
import CustomerDeleteButtonComponent from "./CustomerDeleteButtonComponent";

class CustomerGetAllComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            customers: []
        }
        this.deleteCustomer = this.deleteCustomer.bind(this);
    }

    deleteCustomer(id){
        CustomerService.delete(id).then(res =>{
            this.setState({customers: this.state.customers.filter(customer => customer.id !== id)});
        });
    }

    componentDidMount() {
        CustomerService.getAll().then((res) =>{
                this.setState({customers: res.data});
            });
    }

    render() {
        return (
            <div>
                    <table className="table table-striped table-hover">
                       <TableHeadComponent />
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
                                        <td><CustomerEditButtonComponent id={customer.id} /></td>
                                        <td>
                                            <button className="btn btn-danger mt-1" onClick={() => this.deleteCustomer(customer.id)}>Delete</button>
                                            {/*<CustomerDeleteButtonComponent id = {customer.id} />*/}
                                        </td>
                                    </tr>
                            )
                        }
                        </tbody>
                        <TableBodyComponent customers = {this.state.customers} />
                    </table>
               <CustomerCreateButtonComponent />
               <InputGetByIdComponent />
            </div>
        )
    }
}

export default CustomerGetAllComponent;