import React from 'react';
import {NavLink} from "react-router-dom";

const CustomerEditButtonComponent = (props) => {
    return (
        <div>
            <NavLink to={`/customers/edit/${props.id}`}>
                <button className="btn btn-warning mt-1" type="submit" >Edit</button>
            </NavLink>
        </div>
    );
}

export default CustomerEditButtonComponent;