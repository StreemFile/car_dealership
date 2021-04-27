package chnu.coursework.car_dealership.service.customer.impls;

import chnu.coursework.car_dealership.data.FakeCustomer;
import chnu.coursework.car_dealership.model.Customer;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.customer.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.StudentServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 17.02.2021|13:25
 * @Version StudentServiceImpl: 1.0
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    FakeCustomer fakeCustomer;

    @Autowired
    GenericService genericService;
    String className = "customer";

    @PostConstruct
    void init(){
//        fakeCustomer.getCustomers().forEach(this::create);
    }

    @Override
    public Customer create(Customer customer) {
        return genericService.create(customer, customer.getId(), className);
    }

    @Override
    public Customer update(Customer customer) {
        return genericService.update(customer, customer.getId(), className);
    }

    @Override
    public Customer delete(Customer customer) {
        return genericService.delete(customer, customer.getId(), className);
    }

    @Override
    public Customer getById(String id) {
        return genericService.getById(id, className, Customer.class);
    }

    @Override
    public List<Customer> getAll() {
        return genericService.getAll(className, Customer.class);
    }

}
