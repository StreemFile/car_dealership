import React, {Component} from 'react';
import axios from 'axios';

const CUSTOMER_API_BASE_URL = "http://localhost:8080/api/customers"

class CustomerService extends Component {
    constructor(props) {
        super(props);

        this.state = {}
    }

    getCustomers(){
        return axios.get(CUSTOMER_API_BASE_URL);
    }

    render() {
        return (
            <div>

            </div>
        )
    }
}

export default new CustomerService()