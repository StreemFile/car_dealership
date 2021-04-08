package chnu.coursework.car_dealership.service.dealership.impls;

import chnu.coursework.car_dealership.data.FakeDealership;
import chnu.coursework.car_dealership.model.Dealership;
import chnu.coursework.car_dealership.model.Employee;
import chnu.coursework.car_dealership.repository.company.CompanyRepository;
import chnu.coursework.car_dealership.repository.dealership.DealershipRepository;
import chnu.coursework.car_dealership.service.dealership.interfaces.IDealershipService;
import chnu.coursework.car_dealership.service.employee.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        return repository.save(dealership);
//        return dao.create(dealership);
    }

    @Override
    public Dealership update(Dealership dealership) {
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

    public Map<String, Integer> getEachDealershipTotalSalary() {
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
                               item -> item.getKey(),
                               item -> item.getValue(),
                               (u, v) -> {
                                   throw new IllegalStateException(String.format("Duplicate key %s", u));
                               },
                               LinkedHashMap::new));
    }
}
