package chnu.coursework.car_dealership.dao.customer.impls;

import chnu.coursework.car_dealership.dao.customer.interfaces.ICustomerDAO;
import chnu.coursework.car_dealership.data.FakeCustomer;
import chnu.coursework.car_dealership.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.CustomerDAOImpl
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:37
 * @Version CustomerDAOImpl: 1.0
 */

@Repository
public class CustomerDAOImpl implements ICustomerDAO {
    @Autowired
    FakeCustomer fakeCustomer;

    @Override
    public Customer create(Customer customer) {
        this.getAll().add(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        Customer updatedCustomer = this.getById(customer.getId());
        updatedCustomer.setName(customer.getName());
        updatedCustomer.setTelephone(customer.getTelephone());
        updatedCustomer.setPlaceOfResidence(customer.getPlaceOfResidence());
        updatedCustomer.setAddress(customer.getAddress());
        updatedCustomer.setPassport(customer.getPassport());
        updatedCustomer.setDescription(customer.getDescription());
        updatedCustomer.setModified_at(LocalDateTime.now());

        return customer;
    }

    @Override
    public Customer delete(Customer customer) {
        this.getAll().remove(customer);
        return customer;
    }

    @Override
    public Customer getById(String id) {
        return this.getAll().stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Customer> getAll() {
        return fakeCustomer.getCustomers();
    }
}
