import React, {useState, useEffect} from 'react';
import './App.css';
import {BrowserRouter, Switch, Route} from 'react-router-dom';
import CustomerGetAllComponent from './customer/components/GetAllComponents/CustomerGetAllComponent';
import CustomerCreateComponent from "./customer/components/CreateComponents/CustomerCreateComponent";

function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <Switch>
                    <Route path="/customers" exact component={CustomerGetAllComponent}/>
                    <Route path="/customers/create" exact component={CustomerCreateComponent} />
                </Switch>
            </div>
        </BrowserRouter>
    );
}

export default App;
