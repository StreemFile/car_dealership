import React from 'react';
import {NavLink} from "react-router-dom";

const CustomersGetAllButtonComponent = () => {
    return (
        <div>
            <NavLink to="/customers"><button className="btn btn-warning m-2" >Get all</button></NavLink>
        </div>
    );
}

export default CustomersGetAllButtonComponent;