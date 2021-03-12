import React from 'react';
import {NavLink} from "react-router-dom";

const CustomerCreateButtonComponent = () => {
    return (
        <div>
            <NavLink to="/customers/create">
                <button type="submit" className="btn btn-success m-2">Create</button>
            </NavLink>
        </div>
    );
}

export default CustomerCreateButtonComponent;