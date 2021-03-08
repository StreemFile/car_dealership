import React from 'react';
import {NavLink} from "react-router-dom";

const CustomerListComponent = (props) => {
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
                    <th>edit</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                <tr key={props.customer.id}>
                    <td>{props.customer.id}</td>
                    <td>{props.customer.name}</td>
                    <td>{props.customer.telephone}</td>
                    <td>{props.customer.address}</td>
                    <td>{props.customer.placeOfResidence}</td>
                    <td>{props.customer.passport}</td>
                    <td>{props.customer.description}</td>
                    <td>{props.customer.created_at}</td>
                    <td>{props.customer.modified_at}</td>
                    <td>
                        <NavLink to={`/customers/edit/${props.customer.id}`}>
                            <button className="btn btn-warning mt-1" type="submit" >Edit</button>
                        </NavLink>
                    </td>
                    <td>
                        <form  method="post">
                            <button className="btn btn-danger mt-1" type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
}

export default CustomerListComponent;