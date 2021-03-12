import React, {Component} from 'react';

import InputGetByIdComponent from "./InputGetByIdComponent.jsx";
import TableBodyComponent from "./TableBodyComponent";

import TableHeadComponent from "./TableHeadComponent.jsx";
import CustomerCreateButtonComponent from "./CustomerCreateButtonComponent.jsx";

class CustomerGetAllComponent extends Component {
    render() {
        return (
            <div>
                <table className="table table-striped table-hover">
                    <TableHeadComponent/>
                    <TableBodyComponent/>
                </table>
                <CustomerCreateButtonComponent/>
                <InputGetByIdComponent/>
            </div>
        )
    }
}

export default CustomerGetAllComponent;