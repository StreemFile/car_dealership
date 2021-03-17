import React, {Component} from 'react';

import CustomerDeleteButtonComponent from "../CustomerDeleteButtonComponent";
import CustomerService from "../../service/CustomerService";

import CustomerEditButtonComponent from "../CustomerEditButtonComponent";


class TableBodyComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {}
        this.deleteCustomer = this.deleteCustomer.bind(this);
    }

    deleteCustomer(id) {
        CustomerService.delete(id).then(res => {
            this.props.history.push("/customers");
        });
    }

    render() {
        return (
            <tbody>
            <tr key={this.props.customer.id}>
                <td>{this.props.customer.id}</td>
                <td>{this.props.customer.name}</td>
                <td>{this.props.customer.telephone}</td>
                <td>{this.props.customer.placeOfResidence}</td>
                <td>{this.props.customer.address}</td>
                <td>{this.props.customer.passport}</td>
                <td>{this.props.customer.description}</td>
                <td>{this.props.customer.created_at}</td>
                <td>{this.props.customer.modified_at}</td>
                <td>
                    <CustomerEditButtonComponent
                        id={this.props.customer.id}/>
                </td>
                <td>
                    <CustomerDeleteButtonComponent
                        deleteCustomer={this.deleteCustomer}
                        id={this.props.customer.id}/>
                </td>
            </tr>
            </tbody>
        )
    }
}

export default TableBodyComponent 