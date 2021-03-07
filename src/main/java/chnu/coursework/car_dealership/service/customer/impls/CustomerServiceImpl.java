package chnu.coursework.car_dealership.service.customer.impls;

import chnu.coursework.car_dealership.dao.customer.impls.CustomerDAOImpl;
import chnu.coursework.car_dealership.data.FakeCustomer;
import chnu.coursework.car_dealership.model.Customer;
import chnu.coursework.car_dealership.repository.customer.CustomerRepository;
import chnu.coursework.car_dealership.service.customer.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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
    CustomerDAOImpl dao;

    @Autowired
    CustomerRepository repository;

    @Autowired
    FakeCustomer fakeCustomer;

    @PostConstruct
    void init(){
//        repository.saveAll(fakeCustomer.getAll());
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
//        return dao.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        customer.setModified_at(LocalDateTime.now());
        return repository.save(customer);
//        return dao.update(customer);
    }

    @Override
    public Customer delete(Customer customer) {
        repository.delete(customer);
        return customer;
//        return dao.delete(customer);
    }

    @Override
    public Customer getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
