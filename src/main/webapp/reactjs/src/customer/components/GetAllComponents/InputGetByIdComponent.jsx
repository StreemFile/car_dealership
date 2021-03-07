import React from 'react';

const InputGetByIdComponent = () => {
    return (
        <div>
            <form action="#" autoComplete="off">
                <div className="input-group  ms-2 mb-3" style={{width: '500px'}}>
                    <input type="search" name="id" className="form-control" placeholder="Search by id" />
                    <a href="#">
                        <button className="btn btn-success" type="submit" id="button-addon2">Search</button>
                    </a>
                </div>
            </form>
        </div>
    );
}

export default InputGetByIdComponent;