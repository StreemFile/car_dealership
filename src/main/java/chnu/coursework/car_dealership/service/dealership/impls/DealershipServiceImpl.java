package chnu.coursework.car_dealership.service.dealership.impls;

import chnu.coursework.car_dealership.data.FakeDealership;
import chnu.coursework.car_dealership.model.AutomobileAvailability;
import chnu.coursework.car_dealership.model.Dealership;
import chnu.coursework.car_dealership.model.Employee;
import chnu.coursework.car_dealership.repository.company.CompanyRepository;
import chnu.coursework.car_dealership.repository.dealership.DealershipRepository;
import chnu.coursework.car_dealership.requestModel.TotalSalary;
import chnu.coursework.car_dealership.service.automobile.impls.AutomobileServiceImpl;
import chnu.coursework.car_dealership.service.dealership.interfaces.IDealershipService;
import chnu.coursework.car_dealership.service.employee.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.DealershipServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:34
 * @Version DealershipServiceImpl: 1.0
 */
@Service
public class DealershipServiceImpl implements IDealershipService {

    @Autowired
    DealershipRepository repository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    AutomobileServiceImpl automobileService;

    @Autowired
    FakeDealership fakeDealership;

    @PostConstruct
    void init() {
//        fakeDealership.getDealerships().get(0).setCompany(companyRepository.findAll().get(0));
//        fakeDealership.getDealerships().get(1).setCompany(companyRepository.findAll().get(0));
//        fakeDealership.getDealerships().get(2).setCompany(companyRepository.findAll().get(0));
//        fakeDealership.getDealerships().get(3).setCompany(companyRepository.findAll().get(0));
//        fakeDealership.getDealerships().get(4).setCompany(companyRepository.findAll().get(0));
//        repository.saveAll(fakeDealership.getDealerships());
    }

    @Override
    public Dealership create(Dealership dealership) {
        if (dealership.getId() == null) {
            dealership.setId(UUID.randomUUID().toString());
            dealership.setCreated_at(LocalDateTime.now());
            dealership.setModified_at(LocalDateTime.now());
        }
        return repository.save(dealership);
//        return dao.create(dealership);
    }

    @Override
    public Dealership update(Dealership dealership) {
        dealership.setModified_at(LocalDateTime.now());
        updateAutomobileWhenDealershipIsUpdated(dealership);
        updateEmployeeWhenDealershipIsUpdated(dealership);
        return repository.save(dealership);
//        return dao.update(dealership);
    }

    @Override
    public Dealership delete(Dealership dealership) {
        repository.delete(dealership);
        return dealership;
//        return dao.delete(dealership);
    }

    @Override
    public Dealership getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<Dealership> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }

    public List<TotalSalary> getEachDealershipTotalSalary() {
        return employeeService.getAll()
                              .stream()
                              .collect(Collectors.groupingBy(
                                      item -> item.getDealership().getCity(),
                                      Collectors.summingInt(Employee::getSalary)
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
                                      LinkedHashMap::new)).entrySet()
                              .stream()
                              .map(item -> new TotalSalary(item.getKey(), item.getValue()))
                              .collect(Collectors.toList());
    }

    public String getIdByEnglishCityName(String city) {
        Dealership dealership = repository.findAll()
                                          .stream()
                                          .filter(item -> item.getCityEnglish().equals(city))
                                          .findFirst()
                                          .orElse(null);
        if (dealership != null) {
            return dealership.getId();
        }
        return null;
    }

    private void updateAutomobileWhenDealershipIsUpdated(Dealership dealership) {
        automobileService.getAll()
                         .stream()
                         .filter(item -> item.getDealership().equals(dealership))
                         .filter(item -> !item.getAvailability()
                                              .equals(AutomobileAvailability.SOLD
                                                              .toString()))
                         .collect(Collectors.toList())
                         .forEach(item -> {
                             item.setDealership(dealership);
                             automobileService.update(item);
                         });
    }

    private void updateEmployeeWhenDealershipIsUpdated(Dealership dealership) {
        employeeService.getAll()
                       .stream()
                       .filter(item -> item.getDealership().equals(dealership))
                       .collect(Collectors.toList())
                       .forEach(item -> {
                           item.setDealership(dealership);
                           employeeService.update(item);
                       });
    }
}
