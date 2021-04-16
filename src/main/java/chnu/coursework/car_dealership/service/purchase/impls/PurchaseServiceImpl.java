package chnu.coursework.car_dealership.service.purchase.impls;

import chnu.coursework.car_dealership.data.FakePurchase;
import chnu.coursework.car_dealership.model.Purchase;
import chnu.coursework.car_dealership.repository.automobile.AutomobileRepository;
import chnu.coursework.car_dealership.repository.customer.CustomerRepository;
import chnu.coursework.car_dealership.repository.employee.EmployeeRepository;
import chnu.coursework.car_dealership.repository.purchase.PurchaseRepository;
import chnu.coursework.car_dealership.service.purchase.interfaces.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.PurchaseServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:59
 * @Version PurchaseServiceImpl: 1.0
 */
@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    PurchaseRepository repository;

    @Autowired
    AutomobileRepository automobileRepository;

    @Autowired
    FakePurchase fakePurchase;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    void init(){
        fakePurchase.getPurchases().get(0).setAutomobile(automobileRepository.findAll().get(2));
        fakePurchase.getPurchases().get(0).setCustomer(customerRepository.findAll().get(0));
        fakePurchase.getPurchases().get(0).setEmployee(employeeRepository.findAll().get(1));
        repository.saveAll(fakePurchase.getPurchases());
    }

    @Override
    public Purchase create(Purchase purchase) {
        return repository.save(purchase);
//        return dao.create(purchase);
    }

    @Override
    public Purchase update(Purchase purchase) {
        return repository.save(purchase);
//        return dao.update(purchase);
    }

    @Override
    public Purchase delete(Purchase purchase) {
        repository.delete(purchase);
        return purchase;
//        return dao.delete(purchase);
    }

    @Override
    public Purchase getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<Purchase> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }
}
