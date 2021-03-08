import React, {Component} from 'react';
import CustomerListComponent from "./CustomerListComponent";
import CustomerService from "../../service/CustomerService";
import CustomersGetAllButtonComponent from "../CustomersGetAllButtonComponent";
import {NavLink} from "react-router-dom";

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
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>ПІП</th>
                            <th>Телефон</th>
                            <th>Місце проживання</th>
                            <th>Адреса</th>
                            <th>Номер паспорту</th>
                            <th>description</th>
                            <th>created_at</th>
                            <th>modified_at</th>
                            <th>edit</th>
                            <th>delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr key={this.state.customer.id}>
                            <td>{this.state.customer.id}</td>
                            <td>{this.state.customer.name}</td>
                            <td>{this.state.customer.telephone}</td>
                            <td>{this.state.customer.address}</td>
                            <td>{this.state.customer.placeOfResidence}</td>
                            <td>{this.state.customer.passport}</td>
                            <td>{this.state.customer.description}</td>
                            <td>{this.state.customer.created_at}</td>
                            <td>{this.state.customer.modified_at}</td>
                            <td>
                                <NavLink to={`/customers/edit/${this.state.customer.id}`}>
                                    <button className="btn btn-warning mt-1" type="submit" >Edit</button>
                                </NavLink>
                            </td>
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