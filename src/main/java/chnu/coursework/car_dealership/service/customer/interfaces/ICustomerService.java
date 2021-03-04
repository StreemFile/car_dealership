package chnu.coursework.car_dealership.service.customer.interfaces;

import chnu.coursework.car_dealership.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer create(Customer customer);
    Customer update(Customer customer);
    Customer delete(Customer customer);
    Customer getById(String id);
    List<Customer> getAll();
}
