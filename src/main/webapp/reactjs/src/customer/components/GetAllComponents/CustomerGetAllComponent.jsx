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
        this.editCustomer = this.editCustomer.bind(this);
        this.deleteCustomer = this.deleteCustomer.bind(this);
    }

    editCustomer(id){
        this.props.history.push(`customers/edit/${id}`)
    }

    createCustomer(){
        this.props.history.push("customers/create")
    }

    getById(id){
        this.props.history.push(`customers/get/${id}`);
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
                <div>
                    <table className="table table-striped table-hover">
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
                        {
                            this.state.customers.map(
                                customer =>
                                    <tr key={customer.id}>
                                        <td>{customer.id}</td>
                                        <td>{customer.name}</td>
                                        <td>{customer.telephone}</td>
                                        <td>{customer.address}</td>
                                        <td>{customer.placeOfResidence}</td>
                                        <td>{customer.passport}</td>
                                        <td>{customer.description}</td>
                                        <td>{customer.created_at}</td>
                                        <td>{customer.modified_at}</td>
                                        <td>
                                            <NavLink to={`customers/edit/${customer.id}`}>
                                                <button className="btn btn-warning mt-1" type="submit" >Edit</button>
                                            </NavLink>
                                        </td>
                                        <td>
                                            <button className="btn btn-danger mt-1" onClick={() => this.deleteCustomer(customer.id)}>Delete</button>
                                        </td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
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