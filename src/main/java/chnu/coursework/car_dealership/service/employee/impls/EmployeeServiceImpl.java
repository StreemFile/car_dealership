package chnu.coursework.car_dealership.service.employee.impls;

import chnu.coursework.car_dealership.MongoCollectionGetter;
import chnu.coursework.car_dealership.ToObjectListConverter;
import chnu.coursework.car_dealership.data.FakeEmployee;
import chnu.coursework.car_dealership.model.Employee;
import chnu.coursework.car_dealership.repository.dealership.DealershipRepository;
import chnu.coursework.car_dealership.repository.employee.EmployeeRepository;
import chnu.coursework.car_dealership.service.employee.interfaces.IEmployeeService;
import chnu.coursework.car_dealership.service.purchase.impls.PurchaseServiceImpl;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.*;

/**
 * Created by IntelliJ IDEA.
 * car_dealership.EmployeeServiceImpl
 *
 * @Autor: vovamv
 * @DateTime: 28.02.2021|22:36
 * @Version EmployeeServiceImpl: 1.0
 */

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private  EmployeeRepository repository;

    @Autowired
    private  DealershipRepository dealershipRepository;

    @Autowired
    private  FakeEmployee fakeEmployee;

    @Autowired
    private  MongoCollectionGetter mongoCollectionGetter;

    @Autowired
    PurchaseServiceImpl purchaseService;


    private  ToObjectListConverter toObjectListConverter = new ToObjectListConverter();

    private final String collection = "employee";

    @PostConstruct
    void init() {
//        fakeEmployee.getEmployees().get(0).setDealership(dealershipRepository.findAll().get(0));
//        fakeEmployee.getEmployees().get(1).setDealership(dealershipRepository.findAll().get(1));
//        fakeEmployee.getEmployees().get(2).setDealership(dealershipRepository.findAll().get(2));
//        fakeEmployee.getEmployees().get(3).setDealership(dealershipRepository.findAll().get(3));
//        fakeEmployee.getEmployees().get(4).setDealership(dealershipRepository.findAll().get(4));
//        fakeEmployee.getEmployees().get(5).setDealership(dealershipRepository.findAll().get(0));
//        fakeEmployee.getEmployees().get(6).setDealership(dealershipRepository.findAll().get(1));
//        fakeEmployee.getEmployees().get(7).setDealership(dealershipRepository.findAll().get(2));
//        fakeEmployee.getEmployees().get(8).setDealership(dealershipRepository.findAll().get(3));
//        fakeEmployee.getEmployees().get(9).setDealership(dealershipRepository.findAll().get(4));
//        fakeEmployee.getEmployees().get(10).setDealership(dealershipRepository.findAll().get(0));
//        fakeEmployee.getEmployees().get(11).setDealership(dealershipRepository.findAll().get(1));
//        fakeEmployee.getEmployees().get(12).setDealership(dealershipRepository.findAll().get(2));
//        fakeEmployee.getEmployees().get(13).setDealership(dealershipRepository.findAll().get(3));
//        fakeEmployee.getEmployees().get(14).setDealership(dealershipRepository.findAll().get(4));
//        fakeEmployee.getEmployees().get(15).setDealership(dealershipRepository.findAll().get(0));
//        repository.saveAll(fakeEmployee.getEmployees());
    }

    @Override
    public Employee create(Employee employee) {
        if(employee.getId() == null) {
            employee.setId(UUID.randomUUID().toString());
            employee.setCreated_at(LocalDateTime.now());
            employee.setModified_at(LocalDateTime.now());
        }
        return repository.save(employee);
//        return dao.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        employee.setModified_at(LocalDateTime.now());
        updatePurchaseWhenEmployeeIsUpdated(employee);
        return repository.save(employee);
//        return dao.update(employee);
    }

    @Override
    public Employee delete(Employee employee) {
        repository.delete(employee);
        return employee;
//        return dao.delete(employee);
    }

    @Override
    public Employee getById(String id) {
        return repository.findById(id).orElse(null);
//        return dao.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
//        return dao.getAll();
    }

    public List<Employee> getAllByNameAsc(){
        return repository.findByOrderByNameAsc();
    }

    public List<Employee> getAllByNameDesc(){
        return repository.findByOrderByNameDesc();
    }

    public List<Employee> getAllByDealershipCityAsc(){
        return repository.findByOrderByDealershipCityAsc();
    }

    public List<Employee> getAllByDealershipCityDesc(){
        return repository.findByOrderByDealershipCityDesc();
    }

    public List<Employee> getAllBySalaryDesc(){
        return repository.findByOrderBySalaryDesc();
    }

    public List<Employee> getAllBySalaryAsc(){
        return repository.findByOrderBySalaryAsc();
    }

    public List<Object> getTotalSalaryInChernivtsiAndMamaivtsi() {

        Bson match = Aggregates.match(or(
                eq("dealership.city", "Чернівці"),
                eq("dealership.city", "Мамаївці")
        ));

        Bson project = Aggregates.project(Projections.fields(
                Projections.excludeId(),
                Projections.include("dealership", "salary")
        ));

        Bson group = Aggregates.group(
                "$dealership.city",
                Accumulators.sum("totalSalary", "$salary")
        );

        Bson sort = Aggregates.sort(Sorts.descending("totalSalary"));

        return toObjectListConverter.convert(
                mongoCollectionGetter.getCollection(collection).aggregate(
                                Arrays.asList(
                                        match,
                                        project,
                                        group,
                                        sort
                                )
                )
        );
    }

    public Object getHighestTotalSalary() {
        Bson project = Aggregates.project(Projections.fields(
                Projections.excludeId(),
                Projections.include("dealership", "salary")
        ));

        Bson group = Aggregates.group(
                "$dealership.city",
                Accumulators.sum("totalSalary", "$salary")
        );

        Bson sort = Aggregates.sort(Sorts.descending("totalSalary"));

        Bson limit = Aggregates.limit(1);

        return toObjectListConverter.convert(
                mongoCollectionGetter.getCollection(collection).aggregate(
                        Arrays.asList(
                                project,
                                group,
                                sort,
                                limit
                        )
                )
        ).get(0);
    }

    public List<Object> getEmployeesWithSalaryBetween10000And14000(){

        Bson match = Aggregates.match(and(
              gte("salary",10000),
              lte("salary",14000)
        ));

        Bson project = Aggregates.project(Projections.fields(
                Projections.excludeId(),
                Projections.include("salary", "name")
        ));

        Bson sort = Aggregates.sort(Sorts.descending("salary"));

        return toObjectListConverter.convert(
                mongoCollectionGetter.getCollection(collection).aggregate(
                        Arrays.asList(
                                match,
                                project,
                                sort
                        )
                )
        );
    }

    public List<Object> getNameAndSalary(){
        Bson project = Aggregates.project(Projections.fields(
           Projections.include("name","salary")
        ));
        return toObjectListConverter.convert(
          mongoCollectionGetter.getCollection(collection).aggregate(
                  Arrays.asList(
                          project
                  )
          )
        );
    }

    public List<Employee> getBySalary(int salary){
        return repository.findBySalary(salary);
    }

    public List<Employee> getBySalaryAfter(int salary){
        return repository.findBySalaryAfter(salary);
    }

    public List<Employee> getBySalaryAfterEquals(int salary){
        return repository.findDistinctBySalaryGreaterThanEqual(salary);
    }
    public List<Employee> getBySalaryBeforeEquals(int salary){
        return repository.findDistinctBySalaryLessThanEqual(salary);
    }

    public List<Employee> getBySalaryIn(String salaries) {
        List<Integer> intSalaries = new ArrayList<>();
        List<String> stringSalaries = Arrays.asList(salaries.split("_"));
        stringSalaries.forEach(item -> intSalaries.add(Integer.valueOf(item)));
        return repository.findDistinctBySalaryIn(intSalaries);
    }
    private void updatePurchaseWhenEmployeeIsUpdated(Employee employee){
        purchaseService.getAll()
                       .stream()
                       .filter(item -> item.getEmployee().equals(employee))
                       .collect(Collectors.toList())
                       .forEach(item -> {
                           item.setEmployee(employee);
                           purchaseService.update(item);
                       });
    }

}
