package chnu.coursework.car_dealership.repository.employee;

import chnu.coursework.car_dealership.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
