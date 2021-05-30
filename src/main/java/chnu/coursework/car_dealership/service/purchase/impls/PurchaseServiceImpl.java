package chnu.coursework.car_dealership.service.purchase.impls;

import chnu.coursework.car_dealership.data.FakePurchase;
import chnu.coursework.car_dealership.model.Purchase;
import chnu.coursework.car_dealership.repository.automobile.AutomobileRepository;
import chnu.coursework.car_dealership.repository.customer.CustomerRepository;
import chnu.coursework.car_dealership.repository.employee.EmployeeRepository;
import chnu.coursework.car_dealership.repository.purchase.PurchaseRepository;
import chnu.coursework.car_dealership.requestModel.SoldMake;
import chnu.coursework.car_dealership.service.purchase.interfaces.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
    void init() {
//        fakePurchase.getPurchases().get(0).setAutomobile(automobileRepository.findAll().get(2));
//        fakePurchase.getPurchases().get(0).setCustomer(customerRepository.findAll().get(0));
//        fakePurchase.getPurchases().get(0).setEmployee(employeeRepository.findAll().get(1));
//        repository.saveAll(fakePurchase.getPurchases());
    }

    @Override
    public Purchase create(Purchase purchase) {
        if (purchase.getId() == null) {
            purchase.setId(UUID.randomUUID().toString());
            purchase.setCreated_at(LocalDateTime.now());
            purchase.setModified_at(LocalDateTime.now());
        }
        return repository.save(purchase);
//        return dao.create(purchase);
    }

    @Override
    public Purchase update(Purchase purchase) {
        purchase.setModified_at(LocalDateTime.now());
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

    public Integer getIncomeBetweenDates(String after, String before) {

        return getPurchasesBetweenDates(after, before).stream()
                                                      .mapToInt(Purchase::getSoldPrice)
                                                      .sum() -
               getPurchasesBetweenDates(after, before)
                       .stream()
                       .mapToInt(item -> item.getAutomobile().getActualPrice())
                       .sum();
    }

    public List<SoldMake> groupAndCountSoldMakes() {
        return repository.findAll()
                         .stream()
                         .collect(Collectors.groupingBy(
                                 item -> item.getAutomobile().getModelAndPackage().getMake().getName(),
                                 Collectors.counting()
                                                       ))
                         .entrySet()
                         .stream()
                         .sorted(Map.Entry.comparingByValue())
                         .collect(Collectors.toMap(
                                 Map.Entry::getKey,
                                 Map.Entry::getValue,
                                 (u, v) -> {
                                     throw new IllegalStateException(
                                             String.format("Duplicate key %s", u));
                                 },
                                 LinkedHashMap::new))
                         .entrySet()
                         .stream()
                         .map(item -> new SoldMake(item.getKey(), item.getValue()))
                         .collect(Collectors.toList());
    }

    private List<Purchase> getPurchasesBetweenDates(String after, String before) {
        return repository.findByPurchaseDateIsBetween(LocalDate.parse(before).minusDays(1),
                                                      LocalDate.parse(after).plusDays(1));
    }
}
