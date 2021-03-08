import React, {useState, useEffect} from 'react';
import './App.css';
import {BrowserRouter, Switch, Route} from 'react-router-dom';
import CustomerGetAllComponent from './customer/components/GetAllComponents/CustomerGetAllComponent';
import CustomerCreateComponent from "./customer/components/CreateComponents/CustomerCreateComponent";
import CustomerGetById from "./customer/components/GetByIdComponents/CustomerGetById";
import CustomerUpdateComponent from "./customer/components/UpdateComponents/CustomerUpdateComponent";


function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <Switch>
                    <Route path="/customers" exact component={CustomerGetAllComponent}/>
                    <Route path="/customers/create" exact component={CustomerCreateComponent} />
                    <Route path="/customers/get/:id" exact component={CustomerGetById} />
                    <Route path="/customers/edit/:id" exact component={CustomerUpdateComponent} />
                </Switch>
            </div>
        </BrowserRouter>
    );
}

export default App;
