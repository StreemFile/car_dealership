package chnu.coursework.car_dealership.service.employee.impls;

import chnu.coursework.car_dealership.MongoCollectionGetter;
import chnu.coursework.car_dealership.ToObjectListConverter;
import chnu.coursework.car_dealership.data.FakeEmployee;
import chnu.coursework.car_dealership.model.Employee;
import chnu.coursework.car_dealership.model.Employee;
import chnu.coursework.car_dealership.repository.dealership.DealershipRepository;
import chnu.coursework.car_dealership.repository.employee.EmployeeRepository;
import chnu.coursework.car_dealership.service.GenericService;
import chnu.coursework.car_dealership.service.dealership.impls.DealershipServiceImpl;
import chnu.coursework.car_dealership.service.employee.interfaces.IEmployeeService;
import com.google.gson.Gson;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private  FakeEmployee fakeEmployee;

    @Autowired
    DealershipServiceImpl dealershipService;

    @Autowired
    GenericService genericService;

    String className = "employee";

    @PostConstruct
    void init() {
//            fakeEmployee.getEmployees().get(0).setDealership(dealershipService.getAll().get(0));
//            fakeEmployee.getEmployees().get(1).setDealership(dealershipService.getAll().get(1));
//            fakeEmployee.getEmployees().get(2).setDealership(dealershipService.getAll().get(2));
//            fakeEmployee.getEmployees().get(3).setDealership(dealershipService.getAll().get(3));
//            fakeEmployee.getEmployees().get(4).setDealership(dealershipService.getAll().get(4));
//            fakeEmployee.getEmployees().get(5).setDealership(dealershipService.getAll().get(0));
//            fakeEmployee.getEmployees().get(6).setDealership(dealershipService.getAll().get(1));
//            fakeEmployee.getEmployees().get(7).setDealership(dealershipService.getAll().get(2));
//            fakeEmployee.getEmployees().get(8).setDealership(dealershipService.getAll().get(3));
//            fakeEmployee.getEmployees().get(9).setDealership(dealershipService.getAll().get(4));
//            fakeEmployee.getEmployees().get(10).setDealership(dealershipService.getAll().get(0));
//            fakeEmployee.getEmployees().get(11).setDealership(dealershipService.getAll().get(1));
//            fakeEmployee.getEmployees().get(12).setDealership(dealershipService.getAll().get(2));
//            fakeEmployee.getEmployees().get(13).setDealership(dealershipService.getAll().get(3));
//            fakeEmployee.getEmployees().get(14).setDealership(dealershipService.getAll().get(4));
//            fakeEmployee.getEmployees().get(15).setDealership(dealershipService.getAll().get(0));
//
//            fakeEmployee.getEmployees().forEach(this::create);
    }

    @Override
    public Employee create(Employee employee) {

        return genericService.create(employee, employee.getId(), className);
    }

    @Override
    public Employee update(Employee employee) {
        return genericService.update(employee, employee.getId(), className);
    }

    @Override
    public Employee delete(Employee employee) {
        return genericService.delete(employee, employee.getId(), className);
    }

    @Override
    public Employee getById(String id) {
        return genericService.getById(id, className, Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        return genericService.getAll(className, Employee.class);
    }


}
