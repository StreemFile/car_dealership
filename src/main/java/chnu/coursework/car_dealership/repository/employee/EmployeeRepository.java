package chnu.coursework.car_dealership.repository.employee;

import chnu.coursework.car_dealership.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
     List<Employee> findBySalary(int salary);
     List<Employee> findBySalaryAfter(int salary);
     List<Employee> findDistinctBySalaryGreaterThanEqual(int salary);
     List<Employee> findDistinctBySalaryLessThanEqual(int salary);
     List<Employee> findDistinctBySalaryIn(List<Integer> salary);

}
