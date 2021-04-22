package chnu.coursework.car_dealership.repository.employee;


import chnu.coursework.car_dealership.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

}
