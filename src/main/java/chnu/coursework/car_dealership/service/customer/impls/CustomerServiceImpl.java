package chnu.coursework.car_dealership.service.customer.impls;

import chnu.coursework.car_dealership.dao.customer.impls.CustomerDAOImpl;
import chnu.coursework.car_dealership.data.FakeCustomer;
import chnu.coursework.car_dealership.model.Customer;
import chnu.coursework.car_dealership.repository.customer.CustomerRepository;
import chnu.coursework.car_dealership.service.customer.interfaces.ICustomerService;
import chnu.coursework.car_dealership.service.purchase.impls.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Autowired
    PurchaseServiceImpl purchaseService;

    @PostConstruct
    void init(){
//        repository.saveAll(fakeCustomer.getCustomers());
    }

    @Override
    public Customer create(Customer customer) {
        if(customer.getId() == null) {
            customer.setId(UUID.randomUUID().toString());
            customer.setCreated_at(LocalDateTime.now());
            customer.setModified_at(LocalDateTime.now());
        }
        return repository.save(customer);
//        return dao.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        customer.setModified_at(LocalDateTime.now());
        updatePurchaseWhenCustomerIsUpdated(customer);
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

    public List<Customer> getByTwoPlacesOfResidence(String name, String name2) {
        return  repository.findAllByPlaceOfResidenceEqualsOrPlaceOfResidenceEquals(name,name2);
    }
    public List<Customer> getByPlaceOfResidenceAndName(String place, String name) {
        return  repository.findAllByPlaceOfResidenceEqualsAndNameContains(place,name);
    }

    public List<Customer> getAllExceptFrom(String placeOfResidence){
        return repository.findDistinctByPlaceOfResidenceIsNot(placeOfResidence);
    }

    private void updatePurchaseWhenCustomerIsUpdated(Customer customer){
        purchaseService.getAll()
                       .stream()
                       .filter(item -> item.getCustomer().equals(customer))
                       .collect(Collectors.toList())
                       .forEach(item -> {
                           item.setCustomer(customer);
                           purchaseService.update(item);
                       });
    }
//    public List<Customer>
}
