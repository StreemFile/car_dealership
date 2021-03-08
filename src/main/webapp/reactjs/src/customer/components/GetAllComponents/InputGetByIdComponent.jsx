import React, {Component} from 'react';

class InputGetByIdComponent extends Component {

    getById(id){
        this.props.history.push(`customers/get/${id}`);
    }

    render() {
        return (
            <div>
                <form autoComplete="off">
                    <div className="input-group  ms-2 mb-3" style={{width: '500px'}}>
                        <input type="search" name="id" className="form-control"
                               id="idInput" placeholder="Search by id"/>
                        <button className="btn btn-success" type="submit" id="button-addon2"
                                onClick={() => this.getById(document.getElementById("idInput").value)}>Search</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default InputGetByIdComponent;