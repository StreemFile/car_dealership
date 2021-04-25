package chnu.coursework.car_dealership.service.purchase.impls;

import chnu.coursework.car_dealership.data.FakePurchase;
import chnu.coursework.car_dealership.model.Purchase;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.automobile.impls.AutomobileServiceImpl;
import chnu.coursework.car_dealership.service.customer.impls.CustomerServiceImpl;
import chnu.coursework.car_dealership.service.employee.impls.EmployeeServiceImpl;
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
    FakePurchase fakePurchase;

    @Autowired
    AutomobileServiceImpl automobileService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    GenericService genericService;

    String className = "purchase";

    @PostConstruct
    void init(){
//        fakePurchase.getPurchases().get(0).setAutomobile(automobileService.getAll().get(2));
//        fakePurchase.getPurchases().get(0).setCustomer(customerService.getAll().get(0));
//        fakePurchase.getPurchases().get(0).setEmployee(employeeService.getAll().get(1));
//        fakePurchase.getPurchases().forEach(this::create);
    }

    @Override
    public Purchase create(Purchase purchase) {
       return genericService.create(purchase, purchase.getId(), className);
    }

    @Override
    public Purchase update(Purchase purchase) {
        return genericService.update(purchase, purchase.getId(), className);
    }

    @Override
    public Purchase delete(Purchase purchase) {
        return genericService.delete(purchase, purchase.getId(), className);
    }

    @Override
    public Purchase getById(String id) {
        return genericService.getById(id, className, Purchase.class);
    }

    @Override
    public List<Purchase> getAll() {
        return genericService.getAll(className, Purchase.class);
    }
}
