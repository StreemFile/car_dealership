import React, {Component} from 'react';
import CustomerService from "../service/CustomerService";

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
                            <th>delete</th>
                            <th>edit</th>
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
                                        <form action="" method="post">
                                            <button className="btn btn-warning mt-1" type="submit">Delete</button>
                                        </form>
                                    </td>
                                    <td><a href=""
                                           className="btn btn-warning mt-1">Edit</a></td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default CustomerGetAllComponent