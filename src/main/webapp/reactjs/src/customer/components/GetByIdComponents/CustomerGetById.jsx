import React, {Component} from 'react';
import CustomerService from "../../service/CustomerService";
import CustomersGetAllButtonComponent from "../CustomersGetAllButtonComponent";
import {NavLink} from "react-router-dom";
import TableHeadComponent from "./TableHeadComponent";
import CustomerEditButtonComponent from "../CustomerEditButtonComponent";

class CustomerGetById extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            customer: []
        }
        this.deleteCustomer = this.deleteCustomer.bind(this);
    }

    deleteCustomer(id){
        CustomerService.delete(id).then(res =>{
            this.props.history.push("/customers");
        });
    }

    componentDidMount(){
        CustomerService.getById(this.state.id).then(res => {
            this.setState({customer: res.data});
        })
    }

    render() {
        return (
            <div>
                <div>
                    <table className = "table table-striped table-hover">
                        <TableHeadComponent />
                        <tbody>
                        <tr key={this.state.customer.id}>
                            <td>{this.state.customer.id}</td>
                            <td>{this.state.customer.name}</td>
                            <td>{this.state.customer.telephone}</td>
                            <td>{this.state.customer.placeOfResidence}</td>
                            <td>{this.state.customer.address}</td>
                            <td>{this.state.customer.passport}</td>
                            <td>{this.state.customer.description}</td>
                            <td>{this.state.customer.created_at}</td>
                            <td>{this.state.customer.modified_at}</td>
                            <td><CustomerEditButtonComponent id={this.state.customer.id} /></td>
                            <td>
                                <button className="btn btn-danger mt-1" onClick={() => this.deleteCustomer(this.state.customer.id)}>Delete</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <CustomersGetAllButtonComponent />
            </div>

        )
    }
}

export default CustomerGetById 