import React, {Component} from 'react';

class CustomerDeleteButtonComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
        }
    }

    render() {
        return (
            <div>
                <button className="btn btn-danger mt-1"
                        onClick={() => this.props.deleteCustomer(this.props.id)}>
                    Delete
                </button>
            </div>
        )
    }
}

export default CustomerDeleteButtonComponent 