import React from 'react';

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
                {
                    props.customers.map(
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
                                    <form>
                                        <button className="btn btn-warning mt-1" type="submit">Edit</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="" method="post">
                                        <button className="btn btn-danger mt-1" type="submit">Delete</button>
                                    </form>
                                </td>
                            </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    );
}

export default CustomerListComponent;