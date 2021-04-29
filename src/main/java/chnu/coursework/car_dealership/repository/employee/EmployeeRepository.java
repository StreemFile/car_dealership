package chnu.coursework.car_dealership.repository.employee;

import chnu.coursework.car_dealership.model.Employee;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends Neo4jRepository<Employee,String> {

}
