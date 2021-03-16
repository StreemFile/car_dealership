package chnu.coursework.car_dealership.service.employee.impls;

import chnu.coursework.car_dealership.data.FakeEmployee;
import chnu.coursework.car_dealership.model.Employee;
import chnu.coursework.car_dealership.repository.dealership.DealershipRepository;
import chnu.coursework.car_dealership.repository.employee.EmployeeRepository;
import chnu.coursework.car_dealership.service.employee.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

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
    EmployeeRepository repository;

    @Autowired
    DealershipRepository dealershipRepository;

    @Autowired
    FakeEmployee fakeEmployee;

    @PostConstruct
    void init(){
        fakeEmployee.getEmployees().get(0).setDealership(dealershipRepository.findAll().get(0));
        fakeEmployee.getEmployees().get(1).setDealership(dealershipRepository.findAll().get(1));
        fakeEmployee.getEmployees().get(2).setDealership(dealershipRepository.findAll().get(2));
        fakeEmployee.getEmployees().get(3).setDealership(dealershipRepository.findAll().get(3));
        fakeEmployee.getEmployees().get(4).setDealership(dealershipRepository.findAll().get(4));
        fakeEmployee.getEmployees().get(5).setDealership(dealershipRepository.findAll().get(0));
        fakeEmployee.getEmployees().get(6).setDealership(dealershipRepository.findAll().get(1));
        fakeEmployee.getEmployees().get(7).setDealership(dealershipRepository.findAll().get(2));
        fakeEmployee.getEmployees().get(8).setDealership(dealershipRepository.findAll().get(3));
        fakeEmployee.getEmployees().get(9).setDealership(dealershipRepository.findAll().get(4));
        fakeEmployee.getEmployees().get(10).setDealership(dealershipRepository.findAll().get(0));
        fakeEmployee.getEmployees().get(11).setDealership(dealershipRepository.findAll().get(1));
        fakeEmployee.getEmployees().get(12).setDealership(dealershipRepository.findAll().get(2));
        fakeEmployee.getEmployees().get(13).setDealership(dealershipRepository.findAll().get(3));
        fakeEmployee.getEmployees().get(14).setDealership(dealershipRepository.findAll().get(4));
        fakeEmployee.getEmployees().get(15).setDealership(dealershipRepository.findAll().get(0));
        repository.saveAll(fakeEmployee.getEmployees());
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
//        return dao.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
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
}
