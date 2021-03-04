package chnu.coursework.car_dealership.service.employee.interfaces;

import chnu.coursework.car_dealership.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);
    Employee update(Employee employee);
    Employee delete(Employee employee);
    Employee getById(String id);
    List<Employee> getAll();
}
